package com.examportal.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.model.exam.Quiz;
import com.examportal.repo.QuizRepository;
import com.examportal.service.QuizService;
@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		
		return new HashSet<>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long qid) {
		// TODO Auto-generated method stub
		return this.quizRepository.findById(qid).get();
	}

	@Override
	public void deleteQuiz(Long qid) {
		this.quizRepository.deleteById(qid);
		
	}

}
