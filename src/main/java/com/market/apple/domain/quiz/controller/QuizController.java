package com.market.apple.domain.quiz.controller;

import com.market.apple.domain.article.entity.Article;
import com.market.apple.domain.article.form.ArticleForm;
import com.market.apple.domain.levelup.entity.Levelup;
import com.market.apple.domain.levelup.form.LevelupForm;
import com.market.apple.domain.member.entity.Member;
import com.market.apple.domain.member.service.MemberService;
import com.market.apple.domain.quiz.entity.Quiz;
import com.market.apple.domain.quiz.form.QuizForm;
import com.market.apple.domain.quiz.service.QuizService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuizController {
    private final QuizService quizService;
    private final MemberService memberService;

    @GetMapping("/quiz/list")
    public String list(Model model) {
        List<Quiz> quizList = this.quizService.getList();
        model.addAttribute("quizList", quizList);
        return "quiz/list";
    }

    @GetMapping("quiz/detail/{id}")
    public String getQuiz(Model model, @PathVariable("id") Long id) {
        Quiz quiz = this.quizService.getQuiz(id);
        model.addAttribute("quiz", quiz);
        return "quiz/detail";
    }

    @GetMapping("quiz/create")
    public String create(QuizForm quizForm) {
        return "quiz/form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("quiz/create")
    public String create(@Valid QuizForm quizForm, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "quiz/form";
        }
        Member member = this.memberService.getMember(principal.getName());

        this.quizService.create(quizForm.getTitle(), quizForm.getContent(), false, member);
        return "redirect:/quiz/list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/quiz/modify/{id}")
    public String modify(QuizForm quizForm, @PathVariable("id") Long id) {
        Quiz quiz = this.quizService.getQuiz(id);
        quizForm.setTitle(quiz.getTitle());
        quizForm.setContent(quiz.getContent());

        return "quiz/modifyForm";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/quiz/modify/{id}")
    public String modify(@Valid QuizForm quizForm, BindingResult bindingResult, @PathVariable("id") Long id, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "quiz/form";
        }

        Quiz quiz = this.quizService.getQuiz(id);
        if (!quiz.getMember().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.quizService.modify(quiz, quizForm.getTitle(), quizForm.getContent());
        return String.format("redirect:/quiz/detail/%s", id);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/quiz/delete/{id}")
    public String delete(@PathVariable("id") Long id, Principal principal) {
        Quiz quiz = this.quizService.getQuiz(id);

        if (!quiz.getMember().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }

        this.quizService.delete(id);
        return "redirect:/quiz/list";
    }
}
