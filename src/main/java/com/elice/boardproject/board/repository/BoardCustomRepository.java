package com.elice.boardproject.board.repository;

import com.elice.boardproject.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCustomRepository extends JpaRepository<Board, Long> {
}
