package ssel.banking.dao;

import ssel.banking.domain.User;

public interface IUserManager {
	
	public User findUser4Email(String email);
	
	public User storeUser(User user);

	public boolean userExists(String email);
}
