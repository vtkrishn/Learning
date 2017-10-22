package com.tax.sales.test;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import com.tax.sales.logging.TaxLogger;

public class TestTaxLogger  extends TestCase{

	@Test
	public void testGetLogger() {
		
		System.out.println("---testGetLogger---");
		
		Assert.assertNotNull(TaxLogger.getLogger());
		
		System.out.println(TaxLogger.getLogger());
		
	}

}
