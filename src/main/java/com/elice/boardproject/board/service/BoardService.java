package com.elice.boardproject.board.service;

import com.elice.boardproject.board.entity.Board;
import com.elice.boardproject.board.entity.BoardPostDto;
import com.elice.boardproject.board.repository.BoardCustomRepository;
import com.elice.boardproject.board.repository.BoardRepository;
import com.elice.boardproject.global.exception.ExceptionCode;
import com.elice.boardproject.global.exception.ServiceLogicException;
import com.elice.boardproject.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    
    private final BoardRepository boardRepository;
    private Board board;
    private PostRepository postRepository;
    private BoardCustomRepository boardCustomRepository;

    public BoardService(BoardRepository boardRepository, PostRepository postRepository) {
        this.boardRepository = boardRepository;
        this.postRepository = postRepository;
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

    @Transactional
    public void deleteBoard(Long id) {
        Optional<Board> board = boardCustomRepository.findById(id);
        if (board.isEmpty()) {
            throw new ServiceLogicException(ExceptionCode.BOARD_NOT_FOUND);
        }

        boardCustomRepository.delete(board.get());

//        board = boardRepository.findById(id)
//                                    .orElseThrow(() -> new ServiceLogicException(ExceptionCode.BOARD_NOT_FOUND));
//        postRepository.deleteAll(board.getPosts());
//        boardRepository.delete(board);
    }
}


