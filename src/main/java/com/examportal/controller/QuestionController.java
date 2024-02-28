package com.examportal.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.model.exam.Question;
import com.examportal.model.exam.Quiz;
import com.examportal.service.QuestionService;
import com.examportal.service.QuizService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	//add a question
	@PostMapping("/")
	public ResponseEntity<?> addQuestion(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	@PutMapping("/")
	public ResponseEntity<?> updateQuestion(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}

	//get all question of any quiz
	@GetMapping("/quiz/{quizid}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("quizid") Long quizid){
		/*Quiz quiz=new Quiz();
		quiz.setqId(quizid);
		Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
		return ResponseEntity.ok(questionsOfQuiz);*/
		Quiz quiz = this.quizService.getQuiz(quizid);
		Set<Question> question = quiz.getQuestion();
		List<Question> list=new ArrayList<>(question);
		if(list.size()> Integer.parseInt(quiz.getNumberOfQuestions())) {
			list=list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions())+1);
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
		
		
	}
	//get single question
	@GetMapping("/{queId}/")
	public ResponseEntity<?> getQuestion(@PathVariable("queId") Long queId){
		return ResponseEntity.ok(this.questionService.getQuestion(queId));
	}
	@DeleteMapping("/{queId}")
	public void delete(@PathVariable("queId") Long queId){
		this.questionService.deleteQuestion(queId);
	}
}
