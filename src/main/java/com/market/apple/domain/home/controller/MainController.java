package com.market.apple.domain.home.controller;

import com.market.apple.domain.article.entity.Article;
import com.market.apple.domain.article.service.ArticleService;
import com.market.apple.domain.levelup.entity.Levelup;
import com.market.apple.domain.levelup.service.LevelupService;
import com.market.apple.domain.quiz.entity.Quiz;
import com.market.apple.domain.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final ArticleService articleService;
    private final QuizService quizService;
    private final LevelupService levelupService;
    @GetMapping("/")
    public String root(Model model) {
        List<Article> aritcleList = articleService.getList();
        model.addAttribute("articleList", aritcleList);

        List<Quiz> quizList = quizService.getList();
        model.addAttribute("quizList", quizList);

        List<Levelup> levelupList = levelupService.getList();
        model.addAttribute("levelupList", levelupList);
        return "main";
    }
}

