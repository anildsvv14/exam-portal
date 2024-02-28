package com.examportal.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examportal.model.User;
import com.examportal.repo.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = this.userRepository.findByUsername(username);
		//User user = this.userRepository.findByEmail(username);
		if(user==null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("No User Found");
		}
		
		return user;
	}

}
