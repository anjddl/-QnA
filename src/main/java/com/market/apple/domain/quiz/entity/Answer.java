package com.market.apple.domain.quiz.entity;

import com.market.apple.domain.member.entity.Member;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Quiz quiz;

    @ManyToOne
    private Choice choice;

    private LocalDateTime createDate;

    private LocalDateTime modifiedDate;
}
