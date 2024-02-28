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
import org.springframework.web.bind.annotation.RestController;

import com.examportal.model.exam.Category;
import com.examportal.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	//add a category

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Category category){
		Category category1 = this.categoryService.addCategory(category);
		return ResponseEntity.ok(category1);
	}
	
	@GetMapping("/{categoryid}")
	public ResponseEntity<Category> getCategory(@PathVariable("categoryid") Long categoryid) {
		return ResponseEntity.ok(this.categoryService.getCategory(categoryid));
	}
	
	//get all category
	@RequestMapping("/")
	public ResponseEntity<?> getCategories(){
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	@PutMapping("/")
	public ResponseEntity<?> updateCategory(@RequestBody Category category){
		return ResponseEntity.ok(this.categoryService.updateCategory(category));
	}
	@DeleteMapping("/{categoryid}")
	public void deleteCategory(@PathVariable("categoryid") Long categoryid) {
		this.categoryService.deleteCategory(categoryid);
	}
}
