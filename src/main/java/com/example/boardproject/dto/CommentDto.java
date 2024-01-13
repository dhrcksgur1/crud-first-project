package com.example.boardproject.dto;

import com.example.boardproject.domain.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;


@Getter
@Setter
@ToString
public class CommentDto {

    private Long commentID;
    private String content;
//    private Date date;

    @Builder
    public Comment toEntity(){
        return Comment.builder()
                .commentId(commentID)
//                .date(date)
                .content(content)
                .build();
    }
}


