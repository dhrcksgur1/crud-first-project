package com.example.boardproject.service;

import com.example.boardproject.domain.Board;
import com.example.boardproject.dto.BoardDto;
import com.example.boardproject.repository.BoardRepository;
import jakarta.persistence.EntityNotFoundException;//추가
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board getBoardById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Board not found with id: " + id));
    }

    public Board createBoard(Board board) {
        // Additional validation if needed
        return boardRepository.save(board);
    }

//    public Board updateBoard(Long id, Board updatedBoard) {
//        Board existingBoard = getBoardById(id);
//
//        existingBoard.setTitle(updatedBoard.getTitle());
//        existingBoard.setContent(updatedBoard.getContent());
//
//        return boardRepository.save(existingBoard);
//    }

    public void deleteBoard(Long id) {
        Board board = getBoardById(id);
        boardRepository.delete(board);
    }
}
