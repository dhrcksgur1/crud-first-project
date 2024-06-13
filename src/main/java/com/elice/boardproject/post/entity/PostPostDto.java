package com.elice.boardproject.post.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostPostDto {

    @NotBlank(message = "공백은 입력되지 않습니다.")
    private String title;
    @NotBlank(message = "공백은 입력되지 않습니다.")
    private String content;
}
