package com.examportal.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.examportal.model.User;
import com.examportal.model.UserRole;
import com.examportal.repo.RoleRepository;
import com.examportal.repo.UserRepository;
import com.examportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {

		User local=this.userRepository.findByUsername(user.getUsername());
		if(local!=null) {
			throw new Exception("User already present");
		}else {
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			user.setPassword(this.passwordEncoder.encode(user.getPassword()));
			local = this.userRepository.save(user);
		}
		return local;
	}

//get user by username
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long userid) {
		
		this.userRepository.deleteById(userid);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUsers() {
		
		return this.userRepository.findAll();
	}

}
