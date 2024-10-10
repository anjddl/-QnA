package com.market.apple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/qna_dev")
    public String index() {
        return "index";
    }
    @GetMapping("/")
    public String root() {
        return "";
    }
}
