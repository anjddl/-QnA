package com.market.apple.qna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QnaController {
    @GetMapping("/qna/list")
    @ResponseBody
    public String list() {
        return "hi";
    }
}
