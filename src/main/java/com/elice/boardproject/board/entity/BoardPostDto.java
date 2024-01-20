package com.elice.boardproject.board.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor

public class BoardPostDto {

    @NotBlank(message = "공백금지")
    private String name;
    private String description;
}
