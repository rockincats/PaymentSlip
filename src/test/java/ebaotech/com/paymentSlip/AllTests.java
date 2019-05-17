package ebaotech.com.paymentSlip;

import ebaotech.com.paymentSlip.integration.TestIntegrationDataBase;
import ebaotech.com.paymentSlip.unit.TestConversions;
import ebaotech.com.paymentSlip.unit.TestValidations;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TestConversions.class);
		suite.addTestSuite(TestValidations.class);
		suite.addTestSuite(TestIntegrationDataBase.class);		
		//$JUnit-END$
		return suite;
	}

}
