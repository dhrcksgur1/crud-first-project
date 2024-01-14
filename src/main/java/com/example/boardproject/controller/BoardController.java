package com.example.boardproject.controller;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.Post;
import com.example.boardproject.dto.BoardDto;
import com.example.boardproject.service.BoardService;
import com.example.boardproject.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/boards")
//public class BoardController {
//
//    private final BoardService boardService;
//
//    @GetMapping
//    public List<Board> getAllBoards() {
//        return boardService.getAllBoards();
//    }
//    @GetMapping("/{boardId}")
//    public Board getBoardById(@PathVariable("boardId") Long id) {
//        return boardService.getBoardById(id);
//    }
//
//    @PostMapping
//    public Board createBoard(@RequestBody Board board) {
//        return boardService.createBoard(board);
//    }
//
//    @PutMapping("/{id}")
//    public Board updateBoard(@PathVariable Long id, @RequestBody Board board) {
//        return boardService.updateBoard(id, board);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteBoard(@PathVariable Long id) {
//        boardService.deleteBoard(id);
//    }
//
//}

@Controller
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;
    private final PostService postService;
//    private final BoardMapper boardMapper;
    private final BoardDto boardDto;

    public BoardController(BoardService boardService, PostService postService, BoardDto boardDto) {//BoardMapper boardMapper
        this.boardService = boardService;
        this.postService = postService;
        this.boardDto = boardDto;
//        this.boardMapper = boardMapper;
    }

    @GetMapping
    public String getBoards(Model model) {
        List<Board> boards = boardService.findBoards();
        model.addAttribute("boards", boards);
        return "board/boards";
    }

    /*
     comment 키워드 검색 기능 추가
     */
    @GetMapping("/{boardId}")
    public String getBoard(@PathVariable Long boardId,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size,
                           @RequestParam(required = false) String keyword,
                           Model model) {
        Board board = boardService.findBoardById(boardId);
        PageRequest pageRequest = PageRequest.of(page, size);
//        Page<Post> postPage = postService.findPostsByBoardAndKeyword(board, keyword, pageRequest);

        model.addAttribute("board", board);
        model.addAttribute("keyword", keyword);
//        model.addAttribute("postPage", postPage);
        return "board/board";
    }

    @GetMapping("/create")
    public String createBoard(Model model) {
        return "board/createBoard";
    }

    // PostMapping 게시판 생성
    @PostMapping("/create")
    public String createBoardPost(@ModelAttribute BoardDto boardDto) {
        Board board = new Board();
        boardService.createBoard(board);
        return "redirect:/boards";
    }
    // GetMapping 게시판 수정페이지 조회
    @GetMapping("/{boardId}/edit")
    public String editBoard(@PathVariable Long boardId, Model model) {
        Board board = boardService.findBoardById(boardId);
        model.addAttribute("board", board);

        return "board/editBoard";
    }
    // PostMapping 게시판 수정
    @PostMapping("/{boardId}/edit")
    public String editBoardPost(@PathVariable Long boardId, @ModelAttribute BoardDto boardDto) {
        BoardDto board = boardDto.toBuilder().id(boardId).build();
        boardService.updateBoard(board);

        return "redirect:/boards";
    }
    // DeleteMapping 게시판 삭제
    @DeleteMapping("/{boardId}/delete")
    public String deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);

        return "redirect:/boards";
    }

}
