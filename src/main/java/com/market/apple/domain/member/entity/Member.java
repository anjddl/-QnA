package com.market.apple.domain.member.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    private LocalDateTime createDate;

    private LocalDateTime modifiedDate;
}
