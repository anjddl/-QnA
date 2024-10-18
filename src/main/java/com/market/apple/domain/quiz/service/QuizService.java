package com.market.apple.domain.quiz.service;

import com.market.apple.domain.member.entity.Member;
import com.market.apple.domain.quiz.entity.Quiz;
import com.market.apple.domain.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuizService {
    private final QuizRepository quizRepository;

    // 인스턴스 메서드로 변경
    public Quiz create(String title, String content, boolean isNotice, Member member) {
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setContent(content);
        quiz.setMember(member);

        return this.quizRepository.save(quiz);
    }

    public List<Quiz> getList() {
        return this.quizRepository.findAll();
    }
}