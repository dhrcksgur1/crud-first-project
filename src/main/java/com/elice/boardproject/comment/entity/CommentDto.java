package com.elice.boardproject.comment.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommentDto {
    @NotEmpty(message = "댓글을 입력해 주세요")
    private String content;
}
