package com.finalexam.finalexamserver;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.finalexam.finalexamserver.Entities.Role;
import com.finalexam.finalexamserver.Entities.User;
import com.finalexam.finalexamserver.Entities.UserRole;
import com.finalexam.finalexamserver.Services.UserService;



@SpringBootApplication
public class FinalexamserverApplication  implements CommandLineRunner{

	
	
	@Autowired
	private UserService userService;

	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public static void main(String[] args) {
		SpringApplication.run(FinalexamserverApplication.class, args);
	}

	
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 System.out.println("Stating Code");
//		
//		User user = new User();
//		user.setFirstName("Ram");
//		user.setLastName("Ram");
//	    user.setUsername("Ram8899");
//	    user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
//		user.setEmail("abc@gmail.com");
//		user.setProfile("default.png");
//		
//		
//		Role role1= new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//		
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		
//		userRoleSet.add(userRole);		
//
//		
//	     User user1 = this.userService.createUser(user, userRoleSet);
//	     System.out.println(user1.getUsername());
//		
		
	}
}







