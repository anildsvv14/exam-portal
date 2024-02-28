package com.examportal.service;

import java.util.Set;

import com.examportal.model.exam.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Set<Category> getCategories();
	public Category getCategory(Long catId);
	public void deleteCategory(Long catId);

}
