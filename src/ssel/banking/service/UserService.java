package ssel.banking.service;

import ssel.banking.dao.jpa.UserManager;
import ssel.banking.domain.User;

public class UserService implements IUserService{
	
	UserManager manager;
	
	public UserManager getManager() {
		return manager;
	}

	public void setManager(UserManager manager) {
		this.manager = manager;
	}

	//TODO runtimeException or not
	public User authenticate(User user) {
		User foundUser = manager.findUser4Email(user.getEmail());
		if (foundUser != null){
			if (foundUser.getPassword().equals(user.getPassword())){
				return foundUser;
			}
			else {
				throw new WrongPasswordException();
			}
		} else {
			throw new UserNotFoundException(user.getEmail());
		}
	}
}
