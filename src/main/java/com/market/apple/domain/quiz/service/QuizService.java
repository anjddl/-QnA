package com.market.apple.domain.quiz.service;

import com.market.apple.domain.quiz.entity.Quiz;
import com.market.apple.domain.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuizService {
    private final QuizRepository quizRepository;

    public Quiz create() {
        Quiz quiz = new Quiz();
//        quiz.setTitle();

        return this.quizRepository.save(quiz);
    }

}
