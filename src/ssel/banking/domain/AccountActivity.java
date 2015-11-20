package ssel.banking.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ACCOUNT_ACTIVITY")
public class AccountActivity extends AbstractNamedDomain{
	
	@Temporal(TemporalType.DATE) @Column(name = "XDATE")
	private Date date;
	private double value;
	
	@ManyToOne 
	@JoinColumn(name="ACCOUNTID")
	Account account;
	
	@ManyToOne 
	@JoinColumn(name="OTHERACCOUNTID")
	Account otherAccount;
	
	public String toString(){
		String object = "AccountActivity " + getName() + " " + date + " " + account.getName();
		object += " " + otherAccount.getName() + " " + value;
		return object;
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
		return otherAccount;
	}
	public void setOtherAccount(Account otherAccount) {
		otherAccount = otherAccount;
	}
	
}
