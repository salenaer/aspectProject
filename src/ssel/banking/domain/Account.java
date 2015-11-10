package ssel.banking.domain;

import java.util.Date;
import java.util.List;
//rekeningnummer
@javax.persistence.Embeddable

public class Account extends AbstractDomain{
	String name;
	Date date;
	double value;
	List<User> users;
	List<AccountActivity> activities;
	
	@javax.persistence.ManyToOne
	User user;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	public void addAccountActivity(AccountActivity activity) {
		activities.add(activity);		
	}
	
	public void setUser(User user) {
		users.add(user);		
	}
	
	public List<AccountActivity> getAccountActivity() {
		return activities;
	}
}
