package com.market.apple.domain.article.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Article {
    @Id
    Long id;
}
