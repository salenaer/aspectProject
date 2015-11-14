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

	public User findUser4Email(String email) {
		Query query = em.createNamedQuery("User.user4Email").setParameter("email", email);
		return (User) query.getSingleResult();
	}

	public User storeUser(User user) {
		User user2 = em.merge(user);
		em.persist(user2);
		return user2;
	}

	public boolean userExists(String email) {
		Query query = em.createNamedQuery("User.user4Email").setParameter("email", email);
		List<User> user = (List<User>) query.getResultList();
		return !user.isEmpty();}
}
