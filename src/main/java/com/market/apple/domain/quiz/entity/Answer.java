package com.market.apple.domain.quiz.entity;

import com.market.apple.domain.member.entity.Member;
import com.market.apple.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
public class Answer extends BaseEntity {
    @ManyToOne
    private Member member;

    @ManyToOne
    private Quiz quiz;

    @ManyToOne
    private Choice choice;

}
