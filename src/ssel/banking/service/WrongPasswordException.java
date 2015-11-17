package ssel.banking.service;

public class WrongPasswordException extends SecurityException{
	String message;
	
	public WrongPasswordException() {
		message = "wrong password";
	}
}
