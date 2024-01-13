package com.example.boardproject.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor //기본생성자 자동추가 == public Board{}
@Getter //게터메소드 자동추가
@Entity
public class Board extends BaseTime{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private String title;

    @Builder //builder 클래스 자동 생성> 생성자 대신 사용
    public Board(Long boardId, String title){
        this.boardId = boardId;
        this.title = title;
    }
}

