package com.tax.sales.test;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import com.tax.sales.exception.TaxException;

public class TestTaxException  extends TestCase{
	
	@Test
	public void testSalesTaxException() {
		System.out.println("---testSalesTaxException---");
		
		Assert.assertNotNull(new TaxException());
		
	}

	@Test
	public void testSalesTaxExceptionString() {
		System.out.println("---testSalesTaxExceptionString---");
		
		Assert.assertNotNull(new TaxException("Testing"));
		
	}

}
