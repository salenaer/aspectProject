package ssel.banking.web.controller;

import org.springframework.web.servlet.mvc.AbstractController;

import ssel.banking.domain.User;
import ssel.banking.service.IBankService;
import ssel.banking.service.login.IUserStorageService;

public abstract class AbstractWebController extends AbstractController {

	private String viewName;
	private IBankService bankService;
	private IUserStorageService userService;

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public IBankService getBankService() {
		return bankService;
	}

	public void setBankService(IBankService bankService) {
		this.bankService = bankService;
	}

	public IUserStorageService getUserStorageService() {
		return userService;
	}
	
	public User getCurrentUser() {
		
		return userService.getCurrentUser();
	}

	public void setUserStorageService(IUserStorageService userService) {
		this.userService = userService;
	}
}
