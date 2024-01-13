package com.example.boardproject.controller;

import com.example.boardproject.domain.Post;
import com.example.boardproject.service.PostService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/post")
public class PostController {


    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


}
