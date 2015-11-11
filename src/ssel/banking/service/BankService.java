package ssel.banking.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import ssel.banking.dao.jpa.AccountManager;
import ssel.banking.domain.Account;
import ssel.banking.domain.AccountActivity;
import ssel.banking.domain.User;

public class BankService implements IBankService{
	
	AccountManager manager;
	AccountNameGenerator namer;
	
	public AccountManager getManager() {
		return manager;
	}
	public void setManager(AccountManager manager) {
		this.manager = manager;
	}

	public AccountNameGenerator getNamer() {
		return namer;
	}
	public void setNamer(AccountNameGenerator namer) {
		this.namer = namer;
	}

	private AccountActivity createNewAccountActivity(double amount, Account source, Account target, String message){
		AccountActivity activity = new AccountActivity();
		activity.setName(message);
		activity.setAccount(source);
		activity.setOtherAccount(target);
		activity.setValue(amount);
		activity.setDate(new Date());
		source.addAccountActivity(activity);
		source.setValue(source.getValue()+amount);
		return activity;
	}
	
	public Account createNewAccount(User user) {
		Account account = new Account();
		account.setUser(user);
		account.setAccountActivity(new ArrayList<AccountActivity>());
		account.setValue(0);
		account.setName(namer.generateName());
		account.setDate(new Date()); //date with not arguments create now
		manager.storeAccount(account);
		return account;
	}

	public void removeAccount(Account account) {
		manager.removeAccount(account);		
	}

	public List<Account> listAccounts(User user) {
		return manager.getAccounts4User(user);
	}

	public List<Account> allAccounts() {
		return manager.getAllAccounts();
	}

	public List<AccountActivity> listAccountHistory(String accname) {
		Account account = manager.getAccount4Name(accname);
		return account.getAccountActivity();
	}

	//transfer with strings
	public void transfer(double amount, String sourceAccount, String targetAccount, String message) {
		Account source = manager.getAccount4Name(sourceAccount);
		Account target = manager.getAccount4Name(targetAccount);
		transfer(amount, source,target,message);		
	}
	
	//transfer with accounts
	public void transfer(double amount, Account source, Account target, String message) {
		createNewAccountActivity(-amount, source, target, message);
		createNewAccountActivity(amount, target, source, message);
	}
}
