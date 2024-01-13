package com.example.boardproject.repository;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
