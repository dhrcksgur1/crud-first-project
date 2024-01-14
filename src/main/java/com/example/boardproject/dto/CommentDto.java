package com.example.boardproject.dto;

import com.example.boardproject.domain.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;


@Getter
@Setter
public class CommentDto {
    private Long commentID;
    private String content;
}


