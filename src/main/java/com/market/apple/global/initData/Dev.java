package com.market.apple.global.initData;

import com.market.apple.domain.article.service.ArticleService;
import com.market.apple.domain.member.entity.Member;
import com.market.apple.domain.member.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class Dev {

    @Bean
    public CommandLineRunner init(MemberService memberService, ArticleService articleService) {
        return args -> {
            Member admin = memberService.create("admin", "1234", "admin@admin.com");
            Member member1 =  memberService.create("member1", "1234",  "member1@member1.com");
            Member member2 = memberService.create("member2", "1234", "member2@member2.com");

            // 게시글 등록
            articleService.create("제목1",  "내용1", true, admin);
            articleService.create("제목2",  "내용2", false, member1);
            articleService.create("제목3",  "내용3", false, member1);
            articleService.create("제목4",  "내용4", false, member2);
            articleService.create("제목5",  "내용5", false, member2);

//             퀴즈 등록

        };

    }

}
