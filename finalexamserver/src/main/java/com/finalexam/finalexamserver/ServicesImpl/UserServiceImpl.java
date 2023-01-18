package com.finalexam.finalexamserver.ServicesImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalexam.finalexamserver.Entities.Role;
import com.finalexam.finalexamserver.Entities.User;
import com.finalexam.finalexamserver.Entities.UserRole;
import com.finalexam.finalexamserver.Repository.RoleRepository;
import com.finalexam.finalexamserver.Repository.UserRepository;
import com.finalexam.finalexamserver.Services.UserService;
import com.finalexam.finalexamserver.helper.UserFoundException;


@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	
	
	
	
	//1. Because we have cascadeType.ALL in the Role Entity so when we will save the Role the userRole will be saved automatically
    //2. Now when we take out role from UserRole using the RoleRepository through UserRoles because they are conected by OneToMany and ManyToOne
	//3. UserRole itself does not have any kind of Repository but the roles are taken out from it so that they can be stored in roleRepo
	//4. Now as the userRole and User class are connected by ManyToOne, so taking out roles from userRoles and setting it with user
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		 User local = this.userRepository.findByUsername(user.getUsername());
		 if(local!=null)
		 {
			 System.out.println("User is already there");
			 throw new UserFoundException();
		 }
		 else
		 {
			 for(UserRole ur : userRoles)
			 {
				 roleRepository.save(ur.getRole());
			 }
			 
			 user.getUserRoles().addAll(userRoles);
			 local = this.userRepository.save(user);
		 }
		
		return local;
	}





//Get user by username
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}




    //delete user by id
	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
		
		
	}

}
