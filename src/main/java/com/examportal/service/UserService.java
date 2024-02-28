package com.examportal.service;

import java.util.List;
import java.util.Set;

import com.examportal.model.User;
import com.examportal.model.UserRole;

public interface UserService {

	//for creating user
	
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	//get user by username
	public User getUser(String username);
	
	//delete user by userid
	public void deleteUser(Long userid);
	public List<User> getAllUsers();
}
