package com.example.boardproject.dto;

import com.example.boardproject.domain.Board;
import com.example.boardproject.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class BoardDto {
    private Long boardId;
    private String title;

    //dto -> entity DB등록
    @Builder
    public Board toEntity(){
        return Board.builder()
                .boardId(boardId)
                .title(title)
                .build();
    }
}
