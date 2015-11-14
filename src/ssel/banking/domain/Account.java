package ssel.banking.domain;

import java.util.Date;
import java.util.List;
//this is a bank account

import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;

@NamedQueries({
	@NamedQuery(name = "Account.accounts4User", query = "SELECT a FROM account a WHERE a.user = :user"),
	@NamedQuery(name = "Account.accounts4Name", query = "SELECT a FROM account a WHERE c.name = :name"),
	@NamedQuery(name = "Account.accounts", query = "SELECT a FROM account a")
})

@Table(name="ACCOUNT")
@Entity
public class Account extends AbstractDomain{
	String name;
	@Temporal(TemporalType.DATE)
	Date date;
	double value;
	
	@OneToMany(cascade={CascadeType.ALL})
	List<AccountActivity> activities;
	
	@ManyToOne
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
	
	public List<AccountActivity> getAccountActivity() {
		return activities;
	}
	public void setAccountActivity(List<AccountActivity> activities) {
		this.activities = activities;
	}
	public void addAccountActivity(AccountActivity activity) {
		activities.add(activity);		
	}
	
	public User getUser(){
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;		
	}
	

}
