package com.example.boardproject.service;

import com.example.boardproject.domain.Board;
import com.example.boardproject.dto.BoardDto;
import com.example.boardproject.global.exception.ExceptionCode;
import com.example.boardproject.global.exception.ServiceLogicException;
import com.example.boardproject.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository boardRepository;
    private Board foundBoard;

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
    // 게시판 생성 메서드

    public Board createBoard(Board board) {
        return boardRepository.create(board);
    }
    // 게시판 수정 메서드

    public Board updateBoard(BoardDto board) {
        foundBoard = boardRepository.findById(board.getId())
                .orElseThrow(() -> new ServiceLogicException(ExceptionCode.BOARD_NOT_FOUND));

        Optional.ofNullable(board.getName())
                .ifPresent(name -> { foundBoard = foundBoard.toBuilder().name(name).build(); });

        foundBoard = foundBoard.toBuilder().description(board.getDescription()).build();

        return boardRepository.update(foundBoard);
    }
    // 게시판 삭제 메서드

    public void deleteBoard(Long id) {
        // id를 사용하여 게시판을 찾기
        foundBoard = boardRepository.findById(id)
                .orElseThrow(() -> new ServiceLogicException(ExceptionCode.BOARD_NOT_FOUND));
        // 해당 게시판 삭제
        boardRepository.delete(foundBoard);
    }

}
