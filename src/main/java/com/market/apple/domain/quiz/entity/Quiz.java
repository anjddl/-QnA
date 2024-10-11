package com.market.apple.domain.quiz.entity;

import com.market.apple.domain.member.entity.Member;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @Column(length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    private Type type;

    private LocalDateTime createDate;

    private LocalDateTime modifiedDate;

    public enum Type {
        OXQ, MCQ
    }

}
