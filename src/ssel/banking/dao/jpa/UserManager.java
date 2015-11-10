package ssel.banking.dao.jpa;

import ssel.banking.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserManager implements ssel.banking.dao.IUserManager{
	
	EntityManager em;

	public User findUser4Email(String email) {
		em.createNamedQuery("User.user4Email").setParameter("email", email);

		return null;
	}

	public User storeUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean userExists(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
