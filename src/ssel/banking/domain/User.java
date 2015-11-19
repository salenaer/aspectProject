package ssel.banking.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "User.user4Email", query = "SELECT U FROM User U WHERE U.email = :email")

@Entity
@Table(name="XUSER")
public class User extends AbstractNamedDomain{
	String email;
	String password;
	
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
}
