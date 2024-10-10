package com.market.apple.domain.article.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ArticleController {
    @GetMapping("/article")
    @ResponseBody
    public String article() {
        return "article";
    }
}

