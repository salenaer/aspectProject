package ssel.banking.service;

public class AccountNameGenerator {
	int current = 1;
	//TODO make this better
	
	String generateName(){
		return "Account" + current++;
	}
}
