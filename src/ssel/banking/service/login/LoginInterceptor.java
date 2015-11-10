package ssel.banking.service.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ssel.banking.domain.User;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	public static final String USER_REF="BankingWebUser";
	
	private IUserStorageService uStorageService;
	
	public void setUStorageService(IUserStorageService storageService) {
		uStorageService = storageService;
	}
	
	public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
    	
		User user = (User) request.getSession().getAttribute(USER_REF);
		if(user!=null)
			uStorageService.storeCurrentUser(user);
		
		return true;
    }
	
}
