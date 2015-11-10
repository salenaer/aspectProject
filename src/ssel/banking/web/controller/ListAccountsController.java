package ssel.banking.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import ssel.banking.domain.Account;

public class ListAccountsController extends AbstractWebController{
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		ModelAndView mv = new ModelAndView(getViewName());
		
		List<Account> myAccounts = getBankService().listAccounts(getCurrentUser());
		
		mv.addObject("accounts",myAccounts);
		
		return mv;
	}
	
	
	
}
