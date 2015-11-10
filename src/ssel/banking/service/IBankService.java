package ssel.banking.service;

import java.util.List;

import ssel.banking.domain.Account;
import ssel.banking.domain.AccountActivity;
import ssel.banking.domain.User;

public interface IBankService {
	
	public void transfer(double amount, Account source, Account target, String message);
	
	public Account createNewAccount(User user);
	
	public void removeAccount(Account account);
	
	public List<Account> listAccounts(User user);
	
	public List<Account> allAccounts();

	public List<AccountActivity> listAccountHistory(String accname);

	public void transfer(double amount, String sourceAccount, String targetAccount,
			String message);
	
}
 