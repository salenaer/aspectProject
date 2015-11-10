package ssel.banking.service.login;

import javax.servlet.http.HttpSession;

import ssel.banking.domain.User;

public interface IUserStorageService {
	/**
	 * Invoke this method when successfully authenticated a user.
	 * This will store the user and make it available through the
	 * getCurrentUser method during the complete session.
	 * 
	 * @param session
	 * @param user
	 */
	public void storeCurrentUserInSession(HttpSession session, User user);
	
	
	public User getCurrentUser();
	
	public void removeCurrentUserFromSession(HttpSession session, User user);
	
	public void storeCurrentUser(User user);
}
