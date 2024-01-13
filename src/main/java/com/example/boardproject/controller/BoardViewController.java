package com.example.boardproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/view/boards")
public class BoardViewController {

    @GetMapping
    public String getView() {
        return "/board/board";
    }

}
