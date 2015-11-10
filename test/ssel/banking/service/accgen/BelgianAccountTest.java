package ssel.banking.service.accgen;

import junit.framework.TestCase;

public class BelgianAccountTest extends TestCase {

	public void testCreateAccount() {
		
		new BelgianAccountName(734,736353);
		new BelgianAccountName(734,0);
		new BelgianAccountName(27,1097645);
	}
	
	public void testCreateFaultyAccount1() throws IllegalArgumentException{
		try {
		new BelgianAccountName(7345,0);
		fail("this should have thrown an exception");
		}catch(IllegalArgumentException ex) {}
	}
	
	public void testCreateFaultyAccount2() throws IllegalArgumentException{
		try {
		new BelgianAccountName(734,987353353);
		fail("this should have thrown an exception");
		}catch(IllegalArgumentException ex) {}
	}
	
	public void testCreateFaultyAccount3() throws IllegalArgumentException{
		try {
		new BelgianAccountName(-1,0);
		fail("this should have thrown an exception");
		}catch(IllegalArgumentException ex) {}
	}
	
	public void testCreateFaultyAccount4() throws IllegalArgumentException{
		try {
		new BelgianAccountName(0,-1);
		fail("this should have thrown an exception");
		}catch(IllegalArgumentException ex) {}
	}
	
	public void testCreateFaultyAccount5() throws IllegalArgumentException{
		try {
		new BelgianAccountName(888888888,999999999999l);
		fail("this should have thrown an exception");
		}catch(IllegalArgumentException ex) {}
	}
	
	public void testBuildAccountFromString() {
		String accname = "734-6354433-69";
		BelgianAccountName acc = BelgianAccountName.buildFromString(accname);
		assertEquals(acc.toString(),accname);
	}
}
