package com.elice.boardproject.board.controller;

import java.util.List;
import java.util.Objects;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elice.boardproject.board.entity.Board;
import com.elice.boardproject.board.entity.BoardPostDto;
import com.elice.boardproject.board.service.BoardService;
import com.elice.boardproject.post.entity.Post;
import com.elice.boardproject.post.service.PostService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/boards")
public class BoardController {
    
    private final BoardService boardService;
    private final PostService postService;

    public BoardController(BoardService boardService, PostService postService) {
        this.boardService = boardService;
        this.postService = postService;
    }

    @GetMapping
    public String getBoards(Model model) {
        List<Board> boards = boardService.findBoards();
        model.addAttribute("boards", boards);
        return "board/boards";
    }

    @GetMapping("/{boardId}")
    public String getBoard(@PathVariable(name = "boardId") Long boardId,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size,
                           @RequestParam(required = false) String keyword,
                           Model model) {
        Board board = boardService.findBoardById(boardId);
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Post> postPage = postService.findPostsByBoardAndKeyword(board, keyword, pageRequest);

        model.addAttribute("board", board);
        model.addAttribute("keyword", keyword);
        model.addAttribute("postPage", postPage);

        return "board/board";
    }
    
    @GetMapping("/createBoard")
    public String create(
        @RequestParam(required = false) String error, Model model) {
        model.addAttribute("error",error);
        return "board/createBoard";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Valid BoardPostDto boardPostDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addAttribute("error", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            return "redirect:/boards/createBoard";
        }

        boardService.createBoard(boardPostDto);
        return "redirect:/boards";
    }

    @GetMapping("/{boardId}/edit")
    public String editBoard(@PathVariable(name = "boardId") Long boardId, Model model) {
        Board board = boardService.findBoardById(boardId);
        model.addAttribute("board", board);

        return "board/editBoard";
    }

    @PostMapping("/{boardId}/edit")
    public String editBoardPost(@PathVariable(name = "boardId") Long boardId, @ModelAttribute BoardPostDto boardPostDto) {
        boardService.updateBoard(boardId, boardPostDto);

        return "redirect:/boards";
    }

    @DeleteMapping("/{boardId}/delete")
    public String deleteBoard(@PathVariable(name = "boardId") Long boardId) {
        boardService.deleteBoard(boardId);

        return "redirect:/boards";
    }
    
}
