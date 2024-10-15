package com.market.apple.domain.quiz.entity;

import com.market.apple.global.jpa.BaseEntity;
import jakarta.persistence.Column;
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
public class Choice extends BaseEntity {
    @ManyToOne
    private Quiz quiz;

    @Column(columnDefinition = "TEXT")
    private String choice_content;

    @Column
    private int orderCount;
}
