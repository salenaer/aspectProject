package ssel.banking.dao.jpa;

import org.springframework.test.jpa.AbstractJpaTests;

import ssel.banking.TestUtils;
import ssel.banking.domain.User;

public abstract class AbstractJpaTest extends AbstractJpaTests {
	
	private TestUtils testUtils;
	
	
	// TODO: we have to hack the aspects to disabled, otherwise they apply in the tests, which we do not want for a dao test
	public AbstractJpaTest() {
		
		
	}
	
	public void setTestUtils(TestUtils testUtils) {
		this.testUtils = testUtils;
	}
	
	public TestUtils getTestUtils() {
		
		return testUtils;
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String[] {"ssel/banking/dao/jpa/banking.dao.test.xml"};
	}
	
	
	
	protected User dummyUser() {
		
		return testUtils.dummyUser();
	}
}
