package ssel.banking.web.controller;

import org.springframework.web.servlet.mvc.SimpleFormController;

import ssel.banking.domain.User;
import ssel.banking.service.IBankService;
import ssel.banking.service.login.IUserStorageService;

public abstract class AbstractWebFormController extends SimpleFormController {
	
	private IBankService bankService;
	private IUserStorageService userStorageService;
	
	public IBankService getBankService() {
		return bankService;
	}

	public void setBankService(IBankService bankService) {
		this.bankService = bankService;
	}

	public IUserStorageService getUserStorageService() {
		return userStorageService;
	}

	public void setUserStorageService(IUserStorageService userStorageService) {
		this.userStorageService = userStorageService;
	}
	
	public User getCurrentUser() {
		return userStorageService.getCurrentUser();
	}

}
