package com.elice.boardproject.post.entity;

import java.util.ArrayList;
import java.util.List;

import com.elice.boardproject.board.entity.Board;
import com.elice.boardproject.comment.entity.Comment;
import com.elice.boardproject.global.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @Column(nullable = false, length = 30)
    private String title;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    public Post(Board board, String title, String content) {
        this.board = board;
        this.title = title;
        this.content = content;
    }

    /*
      양방향 연관관계를 보다 안전하게 매핑하기 위한 setter 메서드
     */
    public void setBoard(Board board) {
        this.board = board;
        if (!this.board.getPosts().contains(this)) {
            this.board.getPosts().add(this);
        }
    }

    /*
    단방향 관계라 아래 코드 불필요
     */
//    @OneToMany(mappedBy = "post")
//    final private List<Comment> comments = new ArrayList<>();
}
