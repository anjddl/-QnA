package com.market.apple.domain.quiz.service;

import com.market.apple.domain.article.entity.Article;
import com.market.apple.domain.member.entity.Member;
import com.market.apple.domain.quiz.entity.Quiz;
import com.market.apple.domain.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Quiz getQuiz(Long id) {
        Optional<Quiz> oq = this.quizRepository.findById(id);
        if (oq.isEmpty()) {
            return null;
        }
        return oq.get();
    }


}