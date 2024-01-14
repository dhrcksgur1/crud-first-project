package com.example.boardproject.dto;

import com.example.boardproject.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
public class BoardDto {

    private Long id;
    private String name;
    private String description;

}
