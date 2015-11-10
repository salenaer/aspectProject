package ssel.banking.domain;

import java.util.Date;

@javax.persistence.Embeddable
public class AccountActivity extends AbstractDomain{
	String name;
	Date date;
	double value;
	
	@javax.persistence.ManyToOne
	Account account;
	
	@javax.persistence.ManyToOne
	Account OtherAccount;
	
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
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Account getOtherAccount() {
		return OtherAccount;
	}
	public void setOtherAccount(Account otherAccount) {
		OtherAccount = otherAccount;
	}
	
}
