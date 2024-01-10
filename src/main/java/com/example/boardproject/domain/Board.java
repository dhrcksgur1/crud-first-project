package com.example.boardproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor //기본생성자 자동추가 == public Board{}
@Getter //게터메소드 자동추가
@Entity
public class Board extends BaseTime{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    //@Column(length = 255, nullable = false)

}

