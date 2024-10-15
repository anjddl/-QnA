package com.market.apple.domain.article.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
package com.market.apple.domain.article.controller;

@Controller
public class ArticleController {
    @GetMapping("/article/list")
    @ResponseBody
    public String list() {
        return "게시글 목록";
    }
}

