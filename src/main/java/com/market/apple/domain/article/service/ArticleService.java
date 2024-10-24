package com.market.apple.domain.article.service;

import com.market.apple.domain.article.entity.Article;
import com.market.apple.domain.article.repository.ArticleRepository;
import com.market.apple.domain.member.entity.Member;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {
    @Autowired
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

    public List<Article> getList() {
        return this.articleRepository.findAll();
    }

    public Article getArticle(Long id) {
        Optional<Article> oq = this.articleRepository.findById(id);
        if (oq.isEmpty()) {
            return null;
        }
        return oq.get();
    }

    @Transactional
    public void updateArticle(Article article) {
        Article existingArticle = articleRepository.findById(article.getId()).orElseThrow();
        existingArticle.setTitle(article.getTitle());
        existingArticle.setContent(article.getContent());
        articleRepository.save(existingArticle);
    }
    public void modify(Article article, String title, String content) {
        article.setTitle(title);
        article.setContent(content);
        this.articleRepository.save(article);
    }


    public void delete(Long id) {
        this.articleRepository.deleteById(id);
    }
}
