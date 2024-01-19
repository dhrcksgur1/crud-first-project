package com.elice.boardproject.comment.controller;

import com.elice.boardproject.board.service.BoardService;
import com.elice.boardproject.comment.entity.Comment;
import com.elice.boardproject.comment.entity.CommentDto;
import com.elice.boardproject.comment.service.CommentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final BoardService boardService;


    @PostMapping
    public String createComment(@Valid @ModelAttribute CommentDto commentDto, @RequestParam Long postId, RedirectAttributes redirectAttributes) {
        commentService.createComment(postId, commentDto);
        redirectAttributes.addAttribute("postId", postId);

        return "redirect:/posts/{postId}";
    }

    @PostMapping("/{commentId}/edit")
    public String updateComment(@PathVariable Long commentId, @ModelAttribute CommentDto commentDto, RedirectAttributes redirectAttributes) {
        Comment updatedComment = commentService.updateComment(commentId, commentDto);

        redirectAttributes.addAttribute("postId", updatedComment.getPost().getId());
        return "redirect:/posts/{postId}";
    }

    @DeleteMapping("/{commentId}")
    public String deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return "redirect:/posts";
    }
}
