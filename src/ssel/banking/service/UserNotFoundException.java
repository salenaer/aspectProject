package ssel.banking.service;

public class UserNotFoundException extends SecurityException{
	String message;
	
	public UserNotFoundException(String email) {
		message = "No user found for email: " + email;
	}
}
