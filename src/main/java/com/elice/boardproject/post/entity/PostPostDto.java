package com.elice.boardproject.post.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostPostDto {

    @NotBlank(message = "공백입력x")
    private String title;
    private String content;
}
