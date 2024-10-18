package com.market.apple.domain.levelup.controller;

import com.market.apple.domain.levelup.entity.Levelup;
import com.market.apple.domain.levelup.service.LevelupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class LevelupController {
    private LevelupService levelupService;
    @GetMapping("/levelup/list")
    public String list(Model model) {
        List<Levelup> levelupList = this.levelupService.getList();
        model.addAttribute("levelupList", levelupList);
        return "levelup/list";
    }
}
