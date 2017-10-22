package com.nasa.mars.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.nasa.mars.test");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestOnBoardCamera.class);
		suite.addTestSuite(TestPlateau.class);
		suite.addTestSuite(TestRoverRobot.class);
		suite.addTestSuite(TestProcessorContext.class);
		suite.addTestSuite(TestNasaExpedition.class);
		//$JUnit-END$
		return suite;
	}

}
