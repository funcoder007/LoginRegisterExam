package com.finalexam.finalexamserver.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.finalexam.finalexamserver.Entities.User;
import com.finalexam.finalexamserver.Repository.UserRepository;


@Service
public class UserDetailsServiceImpl  implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
			User user =this.userRepository.findByUsername(username);
		     if(user==null)
		     {
		    	 System.out.println("User Not Found");
		    	 throw new UsernameNotFoundException("No User Found");
		     }
		     else
				{
					return user;
				}
				
	}

}
