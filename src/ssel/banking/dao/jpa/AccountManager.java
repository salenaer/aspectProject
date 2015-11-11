package ssel.banking.dao.jpa;

import ssel.banking.domain.Account;
import ssel.banking.domain.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository //to translate errors
public class AccountManager implements ssel.banking.dao.IAccountManager{

	@PersistenceContext
	EntityManager em;

	public List<Account> getAccounts4User(User user) {
		Query query = em.createNamedQuery("Account.account4User").setParameter("user", user);
		@SuppressWarnings("unchecked")
		List<Account> accounts = query.getResultList();
		return accounts;
	}

	public Account getAccount4Name(String name) {
		Query query = em.createNamedQuery("Account.account4Name").setParameter("name", name);
		@SuppressWarnings("unchecked")
		List<Account> accounts = query.getResultList();
		return accounts.get(0);
	}

	public List<Account> getAllAccounts() {
		Query query = em.createNamedQuery("Account.accounts");
		@SuppressWarnings("unchecked")
		List<Account> accounts = query.getResultList();
		return accounts;
	}

	public Account storeAccount(Account ac) {
		em.persist(ac);
		return ac;
	}

	public Account getMostRecentAccount() {
		Query query = em.createQuery(
				"SELECT a FROM account a ORDER BY a.date desc");
		query.setMaxResults(1);
		@SuppressWarnings("unchecked")
		List<Account> accounts = query.getResultList();
		return accounts.get(0);
	}

	public void removeAccount(Account ac) {
		em.remove(ac);
	}
}
