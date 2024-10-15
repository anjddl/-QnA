package com.market.apple.domain.home.controller;

import com.market.apple.domain.article.entity.Article;
import com.market.apple.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final ArticleService articleService;

    @GetMapping("/")
    public String root(Model model) {
        List<Article> aritcleList = articleService.getList();

        model.addAttribute("articleList", aritcleList);

        return "main";
    }
}

