package ssel.banking;

import java.util.Date;

import ssel.banking.domain.Account;
import ssel.banking.domain.AccountActivity;
import ssel.banking.domain.User;

public class TestUtils {
	
	private long idgen;
	
	public long getNextID() {
		
		return idgen++;
	}
	
	public User dummyUser() {
		
		User user = new User();
		user.setName("junit test user");
		user.setEmail("test@junit.com");
		user.setPassword("simple");
		
		return user;
	}
	
	public Account dummyEmptyAccount(User user) {
		
		Account acc = new Account();
		acc.setValue(100);
		acc.setName("test account"+getNextID());
		acc.setUser(user);
		acc.setDate(new Date());
		
		return acc;
	}
	
	public void fillAccounts(Account a1, Account a2) {
		
		a1.addAccountActivity(dummyAccountActivity(10,a1,a2));
		a1.addAccountActivity(dummyAccountActivity(-10,a1,a2));
		
		a2.addAccountActivity(dummyAccountActivity(-10,a2,a1));
		a2.addAccountActivity(dummyAccountActivity(10,a2,a1));
	}
	
	public AccountActivity dummyAccountActivity(double value, Account a1, Account a2) {
		
		AccountActivity aa = new AccountActivity();
		aa.setDate(new Date());
		aa.setName("test activity");
		aa.setAccount(a1);
		aa.setValue(value);
		aa.setOtherAccount(a2);
		
		return aa;
	}
	
	public static void main(String[] args) {
		
		System.out.println(7346354433l%97);
	}
}
