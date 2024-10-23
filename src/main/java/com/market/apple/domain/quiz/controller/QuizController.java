package com.market.apple.domain.quiz.controller;

import com.market.apple.domain.article.entity.Article;
import com.market.apple.domain.quiz.entity.Quiz;
import com.market.apple.domain.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuizController {
    private final QuizService  quizService;
    @GetMapping("/quiz/list")
    public String list(Model model) {
        List<Quiz> quizList = this.quizService.getList();
        model.addAttribute("quizList", quizList);
        return "quiz/list";
    }
    @GetMapping("quiz/detail/{id}")
    public String getQuiz (Model model, @PathVariable("id") Long id) {
        Quiz quiz = this.quizService.getQuiz(id);
        model.addAttribute("quiz", quiz);
        return "quiz/detail";
    }
    @GetMapping("quiz/create")
    public String create() {
        return "quiz/create";
    }
}
