package com.elice.boardproject.board.service;

import java.util.List;
import java.util.Optional;

import com.elice.boardproject.board.entity.BoardPostDto;
import org.springframework.stereotype.Service;

import com.elice.boardproject.board.entity.Board;
import com.elice.boardproject.board.repository.BoardRepository;
import com.elice.boardproject.global.exception.ExceptionCode;
import com.elice.boardproject.global.exception.ServiceLogicException;

@Service
public class BoardService {
    
    private final BoardRepository boardRepository;
    private Board board;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

    public Board findBoardById(Long id) {
        return boardRepository.findById(id)
                            .orElseThrow(() -> new ServiceLogicException(ExceptionCode.BOARD_NOT_FOUND));
    }

    public Board createBoard(BoardPostDto boardPostDto) {
        Board board = new Board(
            boardPostDto.getName(),
            boardPostDto.getDescription()
        );

        return boardRepository.create(board);
    }

    public Board updateBoard(Long boardId, BoardPostDto boardPostDto) {
        board = boardRepository.findById(boardId)
                                    .orElseThrow(() -> new ServiceLogicException(ExceptionCode.BOARD_NOT_FOUND));

        Optional.ofNullable(boardPostDto.getName())
                .ifPresent(name -> board = board.toBuilder().name(name).build());

        board = board.toBuilder().description(boardPostDto.getDescription()).build();
        
        return boardRepository.update(board);
    }

    public void deleteBoard(Long id) {
        board = boardRepository.findById(id)
                                    .orElseThrow(() -> new ServiceLogicException(ExceptionCode.BOARD_NOT_FOUND));
        
        boardRepository.delete(board);
    }

}
