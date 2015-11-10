package ssel.banking.service.accgen;

public interface IAccountNameGenerator {
	
	public String getNextName(String lastname);
	
	public String getFirstName();
}
