package com.market.apple.domain.levelUp.entity;

import com.market.apple.domain.member.entity.Member;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class LevelUp {
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
    private Status status;

    private LocalDateTime createDate;

    private LocalDateTime modifiedDate;

    public enum Status {
        W, Y, N
    }
}
