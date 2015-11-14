package ssel.banking.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="ACCOUNT_ACTIVITY")
@Entity
public class AccountActivity extends AbstractNamedDomain{
	@Temporal(TemporalType.DATE)
	Date date;
	double value;
	
	@ManyToOne @JoinColumn(name="ACCOUNTID")
	Account account;
	
	@ManyToOne @JoinColumn(name="OTHERACCOUNTID")
	Account OtherAccount;
	
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
