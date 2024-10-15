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
public class Article extends BaseEntity {
    @ManyToOne
    private Member member;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean isNotice;

    @Column(length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private int count;

}
