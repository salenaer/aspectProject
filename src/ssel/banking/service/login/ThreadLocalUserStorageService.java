package ssel.banking.service.login;

import javax.servlet.http.HttpSession;

import ssel.banking.domain.User;

public class ThreadLocalUserStorageService implements IUserStorageService {
	
	private ThreadLocal<User> tl;
	
	public User getCurrentUser() {
		if(tl==null)
			return null;
		
		else return tl.get();
	}
	
	public void storeCurrentUser(final User user) {
		tl=new ThreadLocal<User>() {
			@Override protected User initialValue() {
				return user;
			}
		};
	}

	public void storeCurrentUserInSession(HttpSession session, final User user) {
		storeCurrentUser(user);
		
		session.setAttribute(LoginInterceptor.USER_REF, user);
	}

	public void removeCurrentUserFromSession(HttpSession session, User user) {
		storeCurrentUser(null);
		
		session.setAttribute(LoginInterceptor.USER_REF, null);
	}
}
