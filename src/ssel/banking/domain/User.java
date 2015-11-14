package ssel.banking.domain;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQuery(name = "User.user4Email", query = "SELECT c FROM User c WHERE c.email = :email")

@Table(name="XUSER")
@Entity
public class User extends AbstractNamedDomain{
	String email;
	String password;
	
	@OneToMany
	List<Account> accounts;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	public void addAccount(Account account) {
		accounts.add(account);
	}
	public void removeAccount(Account account) {
		accounts.remove(account);
	}
}
