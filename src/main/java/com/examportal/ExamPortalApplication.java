package com.examportal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.examportal.model.Role;
import com.examportal.model.User;
import com.examportal.model.UserRole;
import com.examportal.service.UserService;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {

	
	//private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*User user=new User();
		user.setFirstName("anil");
		user.setLastName("sahu");
		user.setUsername("anildsvv14");
		user.setPassword("dsvv");
		user.setEmail("anildvv14@gmail.com");
		user.setEnable(true);
		user.setProfile("default.png");
		
		
		Role role=new Role();
		role.setRoleId(44L);
		role.setRoleName("ADMIN");
	
		Set<UserRole> userRolesSet=new HashSet<>();
		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		userRolesSet.add(userRole);
		User user2 = this.userService.createUser(user, userRolesSet);
		System.out.println(user2);*/
		
		
		
	}

}
