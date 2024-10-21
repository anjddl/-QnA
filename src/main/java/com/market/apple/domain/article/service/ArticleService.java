package com.market.apple.domain.article.service;

import com.market.apple.domain.article.entity.Article;
import com.market.apple.domain.article.repository.ArticleRepository;
import com.market.apple.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    public Article create(String title, String content, boolean isNotice, Member member) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setMember(member);
        article.setNotice(isNotice);
        article.setCount(0);
        return articleRepository.save(article);
    }

    public List<Article> getList () {
        return this.articleRepository.findAll();
    }

    public Article getArticle(Long id) {
        Optional<Article> oq =  this.articleRepository.findById(id);
        if (oq.isEmpty()) {
            return null;
        }
        return oq.get();
    }
}
