package com.elice.boardproject.comment.service;

import com.elice.boardproject.comment.entity.Comment;
import com.elice.boardproject.comment.entity.CommentDto;
import com.elice.boardproject.comment.repository.CommentRepository;
import com.elice.boardproject.global.exception.ExceptionCode;
import com.elice.boardproject.global.exception.ServiceLogicException;
import com.elice.boardproject.post.entity.Post;
import com.elice.boardproject.post.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    public Page<Comment> getCommentListByDesc(Post post, Pageable pageable){
        return commentRepository.findAllByPostOrderByCreatedAtDesc(post, pageable);
    }

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public void createComment(Long postId, CommentDto commentDto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ServiceLogicException(ExceptionCode.POST_NOT_FOUND));

        Comment comment = new Comment(post, commentDto.getContent());
        commentRepository.save(comment);
    }

    public Comment updateComment(Long commentId, CommentDto commentDto) {
        Comment foundComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ServiceLogicException(ExceptionCode.COMMENT_NOT_FOUND));

        Optional.ofNullable(commentDto.getContent())
                .ifPresent(content -> foundComment.setContent(content));

        return commentRepository.save(foundComment);
    }

    public void deleteComment(Long commentId) {
        Comment foundcomment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ServiceLogicException(ExceptionCode.COMMENT_NOT_FOUND));

        commentRepository.delete(foundcomment);
    }

}
