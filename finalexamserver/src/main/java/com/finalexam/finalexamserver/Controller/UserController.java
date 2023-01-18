package com.finalexam.finalexamserver.Controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalexam.finalexamserver.Entities.Role;
import com.finalexam.finalexamserver.Entities.User;
import com.finalexam.finalexamserver.Entities.UserRole;
import com.finalexam.finalexamserver.Services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	//create user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception
	{
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		user.setProfile("default.png");
		Set<UserRole> roles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		
		return this.userService.createUser(user, roles);
		
	}
	
	   //getting a user
		@GetMapping("/{username}")
		public User getUser(@PathVariable("username") String username)
		{
			return this.userService.getUser(username);
		}
		
		
		
		
		
		//delete user by id
		@DeleteMapping("/{userId}")
		public void deleteUser(@PathVariable("userId") Long userId)
		{
			this.userService.deleteUser(userId);
		}
	
}
