package com.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

	User findByUsername(String username);
	User findByEmail(String email);


}
