package ssel.banking.dao.jpa;

import java.util.Date;

import org.springframework.dao.DataAccessException;

import ssel.banking.dao.IAccountManager;
import ssel.banking.dao.IUserManager;
import ssel.banking.domain.Account;
import ssel.banking.domain.AccountActivity;
import ssel.banking.domain.User;


public class AccountManagerTest extends AbstractJpaTest {

	private IUserManager userManager;
	private IAccountManager accountManager;
	
	public User dummyPersistedUser() {
		
		return userManager.storeUser(dummyUser());
	}
	
	public void testAddAccount() {
		
		User user = dummyPersistedUser();
		Account account = getTestUtils().dummyEmptyAccount(user);
		accountManager.storeAccount(account);
		
		assertNotNull(accountManager.getAccount4Name(account.getName()));
	}
	
	public void testDeleteAccount() {
		
		User user = dummyPersistedUser();
		Account account = getTestUtils().dummyEmptyAccount(user);
		account=accountManager.storeAccount(account);
		
		assertEquals(1,accountManager.getAccounts4User(user).size());
		
		accountManager.removeAccount(account);
		
		assertEquals(0,accountManager.getAccounts4User(user).size());
	}
	
	public void testAddAccountActivities() {
		
		User user = dummyPersistedUser();
		User user2 = dummyPersistedUser();
		
		Account account = getTestUtils().dummyEmptyAccount(user);
		Account account2 = getTestUtils().dummyEmptyAccount(user2);
		
		account=accountManager.storeAccount(account);
		account2=accountManager.storeAccount(account2);
		
		getTestUtils().fillAccounts(account, account2);
		
		accountManager.storeAccount(account);
		accountManager.storeAccount(account2);
		
		assertEquals(2,accountManager.getAccount4Name(account.getName()).getAccountActivity().size());
		assertEquals(2,accountManager.getAccount4Name(account2.getName()).getAccountActivity().size());
		
	}
	
	public void testFindAccounts() {
		
		User user = dummyPersistedUser();
		User user2 = dummyPersistedUser();
		
		Account account = getTestUtils().dummyEmptyAccount(user);
		Account account2 = getTestUtils().dummyEmptyAccount(user2);
		Account account3 = getTestUtils().dummyEmptyAccount(user2);
		
		int prevsize = accountManager.getAllAccounts().size();
		
		account=accountManager.storeAccount(account);
		account2=accountManager.storeAccount(account2);
		account3=accountManager.storeAccount(account3);
		
		assertEquals(1,accountManager.getAccounts4User(user).size());
		assertEquals(2,accountManager.getAccounts4User(user2).size());
		assertEquals(3+prevsize,accountManager.getAllAccounts().size());
		
		assertEquals(account3,accountManager.getMostRecentAccount());
	}
	
	public void testAccountActivitiesOrder() {
		
		User user = dummyPersistedUser();
		User user2 = dummyPersistedUser();
		
		Account account = getTestUtils().dummyEmptyAccount(user);
		Account account2 = getTestUtils().dummyEmptyAccount(user2);
		
		account=accountManager.storeAccount(account);
		account2=accountManager.storeAccount(account2);
		
		getTestUtils().fillAccounts(account, account2);
		
		AccountActivity aa = getTestUtils().dummyAccountActivity(9,account,account2);
		aa.setDate(new Date(100)); //very old date
		account.addAccountActivity(aa);
		
		AccountActivity aa2 = getTestUtils().dummyAccountActivity(9,account,account2);
		aa2.setDate(new Date()); //new date
		account.addAccountActivity(aa2);

		account=accountManager.storeAccount(account);
		
		Date temp = new Date(Long.MAX_VALUE-1);
		for(AccountActivity x: account.getAccountActivity()) {
			/*
			System.out.println("timecheck");
			System.out.println(x.getId());
			System.out.println(x.getDate());
			System.out.println(temp);
			System.out.println(x.getDate().compareTo(temp));
			System.out.println();*/
			assertTrue(x.getDate().compareTo(temp)<=0);
			temp=x.getDate();
		}
	}
	
	public void testExceptionTranslation() {
		try {
		accountManager.getAccount4Name(null);
		}catch(DataAccessException ex) {}
	}
	
	
	public void setUserManager(IUserManager userManager) {
		this.userManager = userManager;
	}
	
	public void setAccountManager(IAccountManager accountManager) {
		this.accountManager = accountManager;
	}

}
