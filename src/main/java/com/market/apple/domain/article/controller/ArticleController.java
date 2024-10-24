package com.market.apple.domain.article.controller;


import com.market.apple.domain.article.entity.Article;
import com.market.apple.domain.article.form.ArticleForm;
import com.market.apple.domain.article.service.ArticleService;
import com.market.apple.domain.member.entity.Member;
import com.market.apple.domain.member.service.MemberService;
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
public class ArticleController {
    private final ArticleService articleService;
    private final MemberService memberService;

    @GetMapping("/article/list")
    public String list(Model model) {
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("articleList", articleList);
        return "article/list";

    }

    @GetMapping("article/detail/{id}")
    public String getArticle(Model model, @PathVariable("id") Long id) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article/detail";
    }

    @GetMapping("article/create")
    public String create(ArticleForm articleForm) {
        return "article/form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("article/create")
    public String create(@Valid ArticleForm articleForm, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "article/form";
        }

        Member member = this.memberService.getMember(principal.getName());

        this.articleService.create(articleForm.getTitle(), articleForm.getContent(), false, member);
        return "redirect:/article/list";
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/article/modify/{id}")
    public String modify(ArticleForm articleForm, @PathVariable("id") Long id) {
        Article article = this.articleService.getArticle(id);
        articleForm.setTitle(article.getTitle());
        articleForm.setContent(article.getContent());

        return "article/modifyForm";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/article/modify/{id}")
    public String modify(@Valid ArticleForm articleForm, BindingResult bindingResult, @PathVariable("id") Long id, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "article/form";
        }

        Article article = this.articleService.getArticle(id);
        if (!article.getMember().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.articleService.modify(article, articleForm.getTitle(), articleForm.getContent());
        return String.format("redirect:/article/detail/%s", id);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/article/delete/{id}")
    public String delete(@PathVariable("id") Long id, Principal principal) {
        Article article = this.articleService.getArticle(id);

        if (!article.getMember().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }

        this.articleService.delete(id);

        return "redirect:/article/list";
    }
}

