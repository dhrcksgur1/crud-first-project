package com.example.boardproject.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Writer;
import java.sql.Date;
import java.time.LocalDateTime;


@NoArgsConstructor //기본생성자 자동추가 == public Board{}
@Getter //게터메소드 자동추가
@Entity
@Table(name = "comment")
public class Comment extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(length = 1000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


    @Builder //builder 클래스 자동 생성> 생성자 대신 사용
    public Comment(Long commentId, String content, Date date ,String writer){
        this.commentId = commentId;
        this.content = content;
    }

}

