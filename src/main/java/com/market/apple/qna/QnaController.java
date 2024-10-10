package com.market.apple.qna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QnaController {
    @GetMapping("/")
    @ResponseBody
    public String hi() {
        return "hi";
    }
}
