package com.example.boardproject.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor //기본생성자 자동추가 == public Board{}
@Builder(toBuilder = true) //builder 클래스 자동 생성> 생성자 대신 사용
@Getter //게터메소드 자동추가
@Entity

public class Board extends BaseTime{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String name;

    @Column(length = 200)
    private String description;

    @OneToMany(mappedBy = "board")
    final private List<Post> posts = new ArrayList<>();
//    public Board(Long id, String name, String description){
//        this.id = id;
//        this.name = name;
//        this.description = description;
//    }
}

//@EntityListeners(AuditingEntityListener.class)
//@Getter
//@Entity
//@Builder(toBuilder = true)
//@NoArgsConstructor//기본생성자 자동추가 == public Board{}
//@AllArgsConstructor
//public class Board {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, unique = true, length = 20)
//    private String name;
//
//    @Column(length = 200)
//    private String description;
//
//    @CreatedDate
//    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
//    private LocalDateTime createdAt;
//
//    @OneToMany(mappedBy = "board")
//    final private List<Post> posts = new ArrayList<>();
//
//    // Board 클래스의 생성자를 정의하고 name과 description 매개변수 두개를 받아 클래스의 멤버 변수에 할당하기
//    public Board(String name, String description) {
//        this.name = name;
//        this.description = description;
//    }
//}

