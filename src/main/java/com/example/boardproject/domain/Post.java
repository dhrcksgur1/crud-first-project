package com.example.boardproject.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;


@NoArgsConstructor(access = AccessLevel.PROTECTED)  //기본생성자 자동추가 public Post{}
@Getter //게터메소드 자동추가
//@Setter Setter를 무분별하게 사용하다보면 여기저기서 entity값을 변경할수 있기 때문에 일관성을 보장할수 없다.
@Entity
public class Post extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 값이 없어도 자동 할당
    private Long id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    //why불필요?
//    @ManyToOne
//    @JoinColumn(name="comment_id")
//    private Comment comment;

    @Builder //builder 클래스 자동 생성> 생성자 대신 사용
    public Post(Board board, String title, String content){//Board board 공부
        this.board = board;
        this.title = title;
        this.content = content;
    }
}
