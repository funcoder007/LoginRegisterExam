package com.finalexam.finalexamserver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalexam.finalexamserver.Entities.User;

public interface UserRepository extends JpaRepository<User ,Long>{

	
	
	public User findByUsername(String username);
}
