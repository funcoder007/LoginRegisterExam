package com.finalexam.finalexamserver.helper;

public class UserFoundException extends Exception{

	public UserFoundException()
	{
		super("User with this name already exists");
	}
	public UserFoundException(String msg) {
		super(msg);
	}
}
