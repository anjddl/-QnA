package com.market.apple;

import com.market.apple.domain.article.service.ArticleService;
import com.market.apple.domain.levelup.service.LevelupService;
import com.market.apple.domain.member.entity.Member;
import com.market.apple.domain.member.service.MemberService;
import com.market.apple.domain.quiz.service.QuizService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AppleApplicationTests {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private QuizService quizService;

	@Autowired
	private LevelupService levelupService;

	@Test
	public void testServiceNotNull() {
		assertNotNull(levelupService);
	}

	@Test
	void contextLoads() {
		Member member = memberService.create("test","1234", "test123@test.com");
		for (int i = 0; i <= 30; i++) {
			articleService.create("제목" + i, "내용" + i, false, member);
		}


	}

}
