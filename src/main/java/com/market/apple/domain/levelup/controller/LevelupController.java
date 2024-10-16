package com.market.apple.domain.levelup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LevelupController {
    @GetMapping("/levelup/list")
    public String list() {
        return "levelup/list";
    }
}
