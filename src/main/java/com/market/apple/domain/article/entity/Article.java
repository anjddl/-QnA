package com.market.apple.domain.article.entity;

import com.market.apple.domain.member.entity.Member;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    @ManyToOne
    private Member member;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean is_notice;

    @Column(length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private int count;

    private LocalDateTime createDate;

    private LocalDateTime modifiedDate;

}
