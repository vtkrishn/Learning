package com.tax.sales.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TaxTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.tax.sales.test");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestProduct.class);
		suite.addTestSuite(TestBatch.class);
		suite.addTestSuite(TestTaxCalculator.class);
		suite.addTestSuite(TestTaxException.class);
		suite.addTestSuite(TestTaxUtility.class);
		suite.addTestSuite(TestTaxClient.class);
		suite.addTestSuite(TestTaxConstants.class);
		suite.addTestSuite(TestTaxLogger.class);
		//$JUnit-END$
		return suite;
	}

}
