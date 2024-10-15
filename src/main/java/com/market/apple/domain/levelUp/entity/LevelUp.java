package com.market.apple.domain.levelUp.entity;

import com.market.apple.domain.member.entity.Member;
import com.market.apple.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LevelUp extends BaseEntity  {
    @ManyToOne
    private Member member;

    @Column(length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        W, Y, N
    }
}
