package com.example.boardproject.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

//@Getter
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
//public abstract class BaseTime {
//
//    @Column(value = "created_date")
//    @CreatedDate
//    private LocalDateTime createdDate;   // 생성일시
//
//    @Column(value = "modified_date")
//    @LastModifiedDate
//    private LocalDateTime modifiedDate;  // 최종 수정일시
//
//}

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTime {

    @Column(value = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;   // 생성일시

    @Column(value = "modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;  // 최종 수정일시

}
