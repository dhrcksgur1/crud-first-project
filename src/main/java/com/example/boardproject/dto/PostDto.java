package com.example.boardproject.dto;

import com.example.boardproject.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class PostDto {
    private Long postId;
    private String title;
    private String content;

}

