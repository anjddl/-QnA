package com.market.apple.domain.quiz.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Quiz quiz;

    @Column(columnDefinition = "TEXT")
    private String choice_content;

    @Column
    private int order;

    private LocalDateTime createDate;

    private LocalDateTime modifiedDate;

}
