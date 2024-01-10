package com.example.boardproject.controller;

import com.example.boardproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class PostController {
    @Autowired //의존성 주입
    PostRepository postRepository;

    @GetMapping
    public String test(){
        return "Hello World!";
    }
//    //글 상세보기
//    @PostMapping
//    public String
//
//    //글 작성
//
//    //글 수정
//
//    // 글 삭제
}
