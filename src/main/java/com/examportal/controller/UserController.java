package com.examportal.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.model.Role;
import com.examportal.model.User;
import com.examportal.model.UserRole;
import com.examportal.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:4200/**")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
	
	
	//for creating user
	/*@PostMapping("/create")
	private User createUser(@RequestBody User user) throws Exception {
		Set<UserRole> roles=new HashSet<>();
		
		Role role=new Role(45L,"NORMAL");
		UserRole usereRole=new UserRole(user,role);
		roles.add(usereRole);
		
		return this.userService.createUser(user, roles);
	}*/
	
	//get the user by username
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	
	//delete user by userid
	@DeleteMapping("/{userid}")
	public void deleteUser(@PathVariable("userid") Long userid) {
		this.userService.deleteUser(userid);
	}
	
	//get all user
	@GetMapping("/")
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}
	
	/*@PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) throws Exception {
        // Here, you can call your service layer to add the user to the database
        // For now, we just return the user as a response
		
		Set<UserRole> roles=new HashSet<>();
		
		Role role=new Role(45L,"NORMAL");
		UserRole usereRole=new UserRole(user,role);
		roles.add(usereRole);
		
		User user1= this.userService.createUser(user, roles);
        return ResponseEntity.ok(user1);
    }*/
	
	//get current User
	
}
