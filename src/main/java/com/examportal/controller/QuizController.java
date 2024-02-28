package com.examportal.controller;

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

import com.examportal.model.exam.Quiz;
import com.examportal.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	//create a new quiz
	@PostMapping("/")
	public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	
	//update quiz
	@PutMapping("/")
	public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	//getting the quizs
	@RequestMapping("/")
	public ResponseEntity<?> getQuizees(){
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}
	//get a single quiz
	@GetMapping("/{qid}")
	public ResponseEntity<?> getQuiz(@PathVariable("qid") Long qid){
		return ResponseEntity.ok(this.quizService.getQuiz(qid));
	}
	
	@DeleteMapping("/{qid}")
	public void delete(@PathVariable("qid") Long qid) {
		this.quizService.deleteQuiz(qid);
	}
	
	
	
}
