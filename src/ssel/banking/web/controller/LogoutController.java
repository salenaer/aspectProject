package ssel.banking.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public class LogoutController extends AbstractWebController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mv = new ModelAndView(getViewName());
		
		this.getUserStorageService().storeCurrentUserInSession(arg0.getSession(), null);
		
		return mv;
	}

}
