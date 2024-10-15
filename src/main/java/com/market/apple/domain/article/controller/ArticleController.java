package com.market.apple.domain.article.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ArticleController {
    @GetMapping("/article/list")
    public String list() {
        return "article/list";
    }
}

