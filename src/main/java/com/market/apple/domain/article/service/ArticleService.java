package com.market.apple.domain.article.service;

import com.market.apple.domain.article.entity.Article;
import com.market.apple.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    public void create(String title, String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        articleRepository.save(article);
    }
}
