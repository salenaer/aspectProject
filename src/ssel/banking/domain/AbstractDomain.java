package ssel.banking.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass public abstract class AbstractDomain implements Serializable {
	 
	@Id @GeneratedValue
	private long id = NEW_ID;
	
	public static long NEW_ID = -1;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id; 
	}
	
	public boolean isNew() {
		
		return id==NEW_ID;
	}
}
