package com.example.boardproject.repository;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}