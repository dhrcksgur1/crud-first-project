package com.elice.boardproject.board.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BoardPostDto {
    @NotEmpty(message = "게시판 이름을 입력해 주세요")
    private String name;

    @NotEmpty(message = "게시판 내용을 입력해 주세요")
    private String description;
}
