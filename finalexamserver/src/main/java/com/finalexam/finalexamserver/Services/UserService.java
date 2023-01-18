package com.finalexam.finalexamserver.Services;

import java.util.Set;

import com.finalexam.finalexamserver.Entities.User;
import com.finalexam.finalexamserver.Entities.UserRole;

public interface UserService {




    //creating a user 
	public User createUser(User user , Set<UserRole> userRoles) throws Exception;

	
	//get user by username
	public User getUser(String username);


	//delete user by id
	public void  deleteUser(Long userId);
	


}


