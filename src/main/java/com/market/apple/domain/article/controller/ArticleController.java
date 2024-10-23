package com.market.apple.domain.article.controller;


import com.market.apple.domain.article.form.ArticleForm;
import com.market.apple.domain.article.entity.Article;
import com.market.apple.domain.article.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {
    private final ArticleService articleService;
    @GetMapping("/article/list")
    public String list(Model model) {
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("articleList", articleList);
        return "article/list";

    }

    @GetMapping("article/detail/{id}")
    public String getArticle (Model model, @PathVariable("id") Long id) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article/detail";
    }
    @GetMapping("article/create")
    public String create(@Valid ArticleForm articleForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "article_form";
        }
        this.articleService.create(articleForm.getTitle(), articleForm.getContent());
        return "redirect:/article/list";

    }
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Article article = articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article/editForm";
    }

    // 게시글 수정 처리
    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id, @ModelAttribute Article article, RedirectAttributes redirectAttributes) {
        articleService.updateArticle(article);
        redirectAttributes.addAttribute("id", id);
        redirectAttributes.addFlashAttribute("message", "게시글이 수정되었습니다.");
        return "redirect:/article/{id}";
    }
}

