package com.market.apple.domain.levelup.controller;

import com.market.apple.domain.article.entity.Article;
import com.market.apple.domain.levelup.entity.Levelup;
import com.market.apple.domain.levelup.service.LevelupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class LevelupController {
    private final LevelupService levelupService ;
    @GetMapping("/levelup/list")
    public String list(Model model) {
        List<Levelup> levelupList = this.levelupService.getList();
        model.addAttribute("levelupList", levelupList);
        return "levelup/list";
    }

    @GetMapping("levelup/detail/{id}")
    public String getLevelup (Model model, @PathVariable("id") Long id) {
        Levelup levelup = this.levelupService.getLevelup(id);
        model.addAttribute("levelup", levelup);
        return "levelup/detail";
    }
    @GetMapping("levelup/create")
    public String create() {
        return "levelup/create";
    }
}
