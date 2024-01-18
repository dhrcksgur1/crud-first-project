package com.elice.boardproject.comment.repository;

import com.elice.boardproject.comment.entity.Comment;
import com.elice.boardproject.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
    
    //페이지네이션
    Page<Comment> getComments(Post post, Pageable pageable);
}
