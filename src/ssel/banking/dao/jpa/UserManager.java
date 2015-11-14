package ssel.banking.dao.jpa;

import ssel.banking.domain.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository //to translate errors
public class UserManager implements ssel.banking.dao.IUserManager{

	@PersistenceContext
	EntityManager em;

	private List<User> getUserList4Email(String email){
		Query query = em.createNamedQuery("User.user4Email").setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		return users;
	}

	public User findUser4Email(String email) {
		List<User> users = getUserList4Email(email);
		return users.get(0);
	}

	public User storeUser(User user) {
		User user2 = em.merge(user);
		em.persist(user2);
		return user2;
	}

	public boolean userExists(String email) {
		List<User> user = getUserList4Email(email);
		return !user.isEmpty();}
}
