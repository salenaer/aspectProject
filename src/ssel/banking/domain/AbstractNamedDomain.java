package ssel.banking.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass public abstract class AbstractNamedDomain extends AbstractDomain {
	
	private String name;

	public AbstractNamedDomain() {
		
	}
	
	public AbstractNamedDomain(String name) {
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
