package ssel.banking.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="ACCOUNT_ACTIVITY")
@Entity
public class AccountActivity extends AbstractDomain{
	String name;
	
	@Temporal(TemporalType.DATE)
	Date date;
	double value;
	
	@ManyToOne
	Account account;
	
	@ManyToOne
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
