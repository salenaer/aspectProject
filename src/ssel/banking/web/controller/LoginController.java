package ssel.banking.web.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import ssel.banking.domain.User;
import ssel.banking.service.IUserService;

public class LoginController extends AbstractWebFormController {
	
	private IUserService userService;
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		return new User();
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response,
            Object command, BindException errors) throws Exception {
		
		ModelAndView mv = super.onSubmit(request,response,command,errors);
		
		User user= getUserService().authenticate((User)command);
		
		getUserStorageService().storeCurrentUserInSession(request.getSession(), user);
		
	    return mv;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	} 
}
