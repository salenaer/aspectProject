package ssel.banking.dao;

import java.util.List;

import ssel.banking.domain.Account;
import ssel.banking.domain.User;

public interface IAccountManager {
	
	public List<Account> getAccounts4User(User user);
	
	public Account getAccount4Name(String name);
	
	public List<Account> getAllAccounts();
	
	public Account storeAccount(Account ac);
	
	public Account getMostRecentAccount();
	
	public void deleteAccount(Account ac);
}
 