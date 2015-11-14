package ssel.banking.service.accgen;

public class BelgianAccountNameGenerator implements IAccountNameGenerator {

	private int prefix;
	
	public String getNextName(String lastname) {
		BelgianAccountName lastnameObject = BelgianAccountName.buildFromString(lastname);
		BelgianAccountName res=  new BelgianAccountName(lastnameObject.getPrefix(),lastnameObject.getMain()+1);
		return res.toString();
	}
	
	public String getFirstName() {
		return new BelgianAccountName(getPrefix(),0).toString();
	}

	public int getPrefix() {
		return prefix;
	}

	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}

}
