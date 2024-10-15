package com.market.apple.domain.article.entity;

import com.market.apple.domain.member.entity.Member;
import com.market.apple.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseEntity {
    @ManyToOne
    private Member member;

    @ManyToOne
    private Article article;

    @Column(columnDefinition = "TEXT")
    private String content;
}
