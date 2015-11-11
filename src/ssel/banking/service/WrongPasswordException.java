package ssel.banking.service;

public class WrongPasswordException extends RuntimeException{
	String message;
	
	public WrongPasswordException() {
		message = "wrong password";
	}
}
