package ssel.banking.dao.jpa;

import ssel.banking.domain.Account;
import ssel.banking.domain.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository //to translate errors
@Transactional
public class AccountManager implements ssel.banking.dao.IAccountManager{

	@PersistenceContext
	private EntityManager em;

	public List<Account> getAccounts4User(User user) {
		Query query = em.createNamedQuery("Account.accounts4User").setParameter("user", user);
		List<Account> accounts = (List<Account>) query.getResultList();
		return accounts;
	}

	public Account getAccount4Name(String name) {
		Query query = em.createNamedQuery("Account.accounts4Name").setParameter("name", name);
		return (Account) query.getSingleResult();
	}

	public List<Account> getAllAccounts() {
		Query query = em.createNamedQuery("Account.accounts");
		List<Account> accounts = (List<Account>) query.getResultList();
		return accounts;
	}

	public Account storeAccount(Account acc) {
		Account persistedAccount = em.merge(acc);
		em.persist(persistedAccount);
		return persistedAccount;
	}

	//TODO create named query
	public Account getMostRecentAccount() {
		Query query = em.createQuery(
				"SELECT a FROM Account a ORDER BY a.date desc");
		query = query.setMaxResults(1); //to speed up search
		return (Account) query.getSingleResult();
	}

	public void removeAccount(Account ac) {
		em.remove(ac);
	}
}
