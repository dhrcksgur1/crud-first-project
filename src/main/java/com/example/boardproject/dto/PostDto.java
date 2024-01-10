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
//    private Date date;

    //dto -> entity DB등록
    @Builder
    public Post toEntity(){
        return Post.builder()
                .postId(postId)
                .title(title)
                .content(content)
//                .date(date)
                .build();
    }//https://tmdrl5779.tistory.com/51
}

