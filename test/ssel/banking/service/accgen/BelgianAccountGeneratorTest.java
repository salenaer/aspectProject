package ssel.banking.service.accgen;

import java.util.Set;
import java.util.TreeSet;

import junit.framework.TestCase;

public class BelgianAccountGeneratorTest extends TestCase {
	
	private IAccountNameGenerator accgen = new BelgianAccountNameGenerator();
	
	public void testAccountGenerator1() {
		
		Set<String> names = new TreeSet<String>();
		String fname = accgen.getFirstName();
		names.add(fname);
		for(int i=0;i<100;++i) {
			fname=accgen.getNextName(fname);
			assertTrue(names.add(fname));
		}
	}
	
	public void testOverflow() {
		
		try {
			BelgianAccountName accname = new BelgianAccountName(734,9999999l);
			accgen.getNextName(accname.toString());
			fail("exception expected");
			
		}
		catch(IllegalArgumentException ex) {}
	}
}
