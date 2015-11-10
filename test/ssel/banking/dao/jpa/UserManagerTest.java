package ssel.banking.dao.jpa;


import org.springframework.dao.DataAccessException;

import ssel.banking.dao.IUserManager;
import ssel.banking.domain.User;


public class UserManagerTest extends AbstractJpaTest {

	private IUserManager userManager;
	
	public void testEditManagedUser() {
		
		User user = dummyUser();
		user=userManager.storeUser(user);
		
		final String newname = "BliepBliep";
		user.setName(newname);
		
		
		User user2 = userManager.findUser4Email(user.getEmail());
		assertEquals(user2.getName(),newname); 
	}
	
	public void testAddNewUser() {
		
		User user = dummyUser();
		
		userManager.storeUser(user);
		
		User user2 = userManager.findUser4Email(user.getEmail());
		assertNotNull(user2);
		assertEquals(user.getName(),user2.getName());
	}
	
	public void testAddExistingUser() { 
		
		User user = dummyUser();
		
		userManager.storeUser(user);
		
		user = dummyUser();
		
		userManager.storeUser(user);
	}
	
	public void testUserExists() {
		 
		User user = dummyUser();
		userManager.storeUser(user);
		
		boolean res = userManager.userExists(user.getEmail());
		assertTrue(res);
		
		res = userManager.userExists("this is not a valid email");
		assertFalse(res);
	}
	
	public void testExceptionTranslation() {
		try {
		userManager.storeUser(null);
		}catch(DataAccessException ex) {}
	}
	
	public void setUserManager(IUserManager userManager) {
		this.userManager = userManager;
	}

}
