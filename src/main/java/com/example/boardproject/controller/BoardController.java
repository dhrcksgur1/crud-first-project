package com.example.boardproject.controller;

import com.example.boardproject.domain.Board;
import com.example.boardproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }
    @GetMapping("/{boardId}")
    public Board getBoardById(@PathVariable("boardId") Long id) {
        return boardService.getBoardById(id);
    }

    @PostMapping
    public Board createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }

//    @PutMapping("/{id}")
//    public Board updateBoard(@PathVariable Long id, @RequestBody Board board) {
//        return boardService.updateBoard(id, board);
//    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }

}