package com.finalexam.finalexamserver.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finalexam.finalexamserver.Config.JwtUtils;
import com.finalexam.finalexamserver.Entities.JwtRequest;
import com.finalexam.finalexamserver.Entities.JwtResponse;
import com.finalexam.finalexamserver.Entities.User;
import com.finalexam.finalexamserver.ServicesImpl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	@Autowired
	private AuthenticationManager authenticationManager;


	 @Autowired 
	 private UserDetailsServiceImpl userDetailsService;
	
	 @Autowired
	 private JwtUtils jwtUtils;
	 
	 
	 
	 
	 //generate token
	 @PostMapping("/generate-token")
	 public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	 {
		 try
		 {
			 
			 authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
			 
		 }catch(Exception e)
		 {
			 e.printStackTrace();
			 throw new Exception("User Not Found");
		 }
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
	 
	 String token = this.jwtUtils.generateToken(userDetails);
	 return ResponseEntity.ok(new JwtResponse(token));
	 
	 
	 }
	 
	 
	 
	 
	 
	//AUTHENTICATTTTTTTEEEEEEEEEEEEE KAREGAAAAAAA
	
	 private void authenticate(String username , String password) throws Exception
     {
    	 try
    	 {
    		 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username , password));
    	 }
    	 catch(DisabledException e)
    	 {
    		 throw new Exception("USER DISABLED");
    	 }
     }
     
     //return the info of current user
     @GetMapping("/current-user")
     public User getCurrentUser(Principal principal)
     {
		return ((User)this.userDetailsService.loadUserByUsername(principal.getName()));
    	 
     }
	

}
