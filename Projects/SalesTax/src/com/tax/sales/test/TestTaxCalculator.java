package com.tax.sales.test;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.tax.sales.entity.Product;
import com.tax.sales.exception.TaxException;
import com.tax.sales.util.TaxCalculator;
import com.tax.sales.util.TaxConstants;

public class TestTaxCalculator  extends TestCase{

	Product product;
	TaxCalculator taxCalculator;
	@Before
	public void setUp() throws Exception {
	
		product = new Product(1,"book",12.49);
		
		taxCalculator = new TaxCalculator(product);
	}
	
	@Test
	public void testTaxCalculator() {
		System.out.println("---testTaxCalculator---");
		
		Assert.assertNotNull(taxCalculator);
		System.out.println(taxCalculator);
		
	}

	@Test
	public void testCalculateBasicTax() {
		System.out.println("---testCalculateBasicTax--- item type - LOCAL , Item - Perfume");
		double value;
		
		product.setItemType(TaxConstants.LOCAL_TYPE);
		product.setName("perfume");
		try {
			value = taxCalculator.calculateBasicTax();
			Assert.assertEquals(value,1.249);	
			System.out.println(" for Item :"+taxCalculator.getProduct().getName()+" : " +value);
		} catch (TaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Test
	public void testCalculateImportDutyTax() {
		System.out.println("---testCalculateImportDutyTax---item type - IMPORTED , Item - book");
		product.setItemType(TaxConstants.IMPORTED_TYPE);
		double value = taxCalculator.calculateImportDutyTax();
		Assert.assertEquals(value,0.6245);
		System.out.println(" for Item :"+taxCalculator.getProduct().getName()+" : " +value);
	}

}
