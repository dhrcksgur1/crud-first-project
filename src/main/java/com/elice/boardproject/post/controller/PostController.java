package com.elice.boardproject.post.controller;

import com.elice.boardproject.comment.entity.Comment;
import com.elice.boardproject.comment.service.CommentService;
import com.elice.boardproject.post.entity.Post;
import com.elice.boardproject.post.entity.PostPostDto;
import com.elice.boardproject.post.service.PostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    @GetMapping("/create")
    public String createPost(@RequestParam Long boardId, Model model) {
        model.addAttribute("boardId", boardId);
        return "post/createPost";
    }

    //Pagination
    @GetMapping("/{postId}")
    public String getPostDetail(@PathVariable Long postId,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size,
                                @RequestParam(required = false) String error,
                                Model model) {
        Post post = postService.findPost(postId);
        Pageable pageable = PageRequest.of(page, size);
        Page<Comment> comments = commentService.getCommentListByDesc(post, pageable);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        model.addAttribute("error", error);
        return "post/post";
    }

    @PostMapping("/create")
    public String createPostPost(@Valid @ModelAttribute PostPostDto postPostDto, @RequestParam Long boardId) {
        Post createdPost = postService.createPost(postPostDto, boardId);
        return "redirect:/boards/" + createdPost.getBoard().getId();
    }

    @GetMapping("/{postId}/edit")
    public String editPost(@PathVariable Long postId, Model model) {
        Post post = postService.findPost(postId);
        model.addAttribute("post", post);
        return "post/editPost";
    }

    @PostMapping("/{postId}/edit")
    public String editPost(@PathVariable Long postId, @ModelAttribute PostPostDto postPostDto, RedirectAttributes redirectAttributes) {
        Post updatedPost = postService.updatePost(postPostDto, postId);

        redirectAttributes.addAttribute("postId", updatedPost.getId());
        redirectAttributes.addFlashAttribute("message", "게시글이 수정되었습니다.");
        return "redirect:/posts/{postId}";
    }

    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable Long postId, RedirectAttributes redirectAttributes) {
        postService.deletePost(postId);
        redirectAttributes.addFlashAttribute("message", "과목이 제거되었습니다.");
        return "redirect:/posts";
    }
}
