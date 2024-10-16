package com.market.apple.domain.member.controller;

import com.market.apple.domain.member.form.MemberForm;
import com.market.apple.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/login")
    public String login() {
        return "member/loginForm";
    }
    @GetMapping("/member/join")
    public String join() {
        return "member/joinForm";
    }

    @PostMapping("/member/join")
    public String join(@Valid MemberForm memberForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/joinForm";
        }

        memberService.create(memberForm.getUsername(), memberForm.getPassword(), memberForm.getEmail());

        return "redirect:/";
    }

}
