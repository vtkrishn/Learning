package com.tax.sales.test;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import com.tax.sales.entity.Product;
import com.tax.sales.util.TaxCalculator;
import com.tax.sales.util.TaxConstants;

public class TestProduct extends TestCase{

	Product product;
	TaxCalculator taxCalculator;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		product = new Product(1,"book",12.49);
		product.setItemType("IMPORTED");
		
		taxCalculator = new TaxCalculator(product);
	}

	@Test
	public void testGetQuantity() {
		
		System.out.println("---testGetQuantity---");
		
		Assert.assertEquals(product.getQuantity(),1);
		
		System.out.println(product.getQuantity());
	}

	@Test
	public void testSetQuantity() {
		
		System.out.println("---testSetQuantity---| int value - 2");
		
		product.setQuantity(2);
		Assert.assertEquals(product.getQuantity(),2);
		
		System.out.println(product.getQuantity());
		
	}

	@Test
	public void testGetName() {
		
		System.out.println("---testGetName---");
		
		Assert.assertNotNull(product.getName());
		Assert.assertEquals(product.getName(),"book");
		System.out.println(product.getName());
	}

	@Test
	public void testSetName() {
		
		System.out.println("---testSetName---| value - milk");
		
		String value = "milk";
		product.setName(value);
		Assert.assertNotNull(product.getName());
		assertEquals(value,product.getName());
		
		System.out.println(product.getName());
		
		System.out.println("---testSetName---| value - ''");
		
		String strValue = "";
		product.setName(strValue);
		Assert.assertNotNull(product.getName());
		assertEquals(strValue,product.getName());
		
		System.out.println(product.getName());
		
		System.out.println("---testSetName---| value - null");
		
		String strNullValue = null;
		product.setName(strNullValue);
		Assert.assertNull(product.getName());
		assertEquals(strNullValue,product.getName());
		
		System.out.println(product.getName());
	}

	@Test
	public void testGetPrice() {
		
		System.out.println("---testGetPrice---");
		
		Assert.assertEquals(product.getPrice(),12.49);
		
		System.out.println(product.getPrice());
	}

	@Test
	public void testSetPrice() {
		
		System.out.println("---testSetPrice---");
		
		double value = 12.49;
		product.setPrice(value);
		Assert.assertNotNull(product.getPrice());
		assertEquals(value,product.getPrice());
		
		System.out.println(product.getPrice());
	}

	@Test
	public void testGetItemType() {
		
		System.out.println("---testGetItemType---");
		
		Assert.assertNotNull(product.getItemType());
		Assert.assertEquals(product.getItemType(),TaxConstants.IMPORTED_TYPE);
		System.out.println(product.getItemType());
	}

	@Test
	public void testSetItemType() {
		
		System.out.println("---testSetItemType---");
		
		String value = "LOCAL";
		product.setItemType(value);
		Assert.assertNotNull(product.getItemType());
		Assert.assertEquals(product.getItemType(),TaxConstants.LOCAL_TYPE);
		assertEquals(value,product.getItemType());
		
		System.out.println(product.getItemType());
	}

	@Test
	public void testItem() {
		
		System.out.println("---testItem---");
		
		Assert.assertNotNull(product);
		Assert.assertEquals(product.getQuantity(),1);
		Assert.assertNotNull(product.getName());
		Assert.assertEquals(product.getName(),"book");
		Assert.assertEquals(product.getPrice(),12.49);
		Assert.assertNotNull(product.getItemType());
		Assert.assertEquals(product.getItemType(),TaxConstants.IMPORTED_TYPE);
		
		System.out.println(product.getQuantity());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getItemType());
	}

	@Test
	public void testGetTotal() {
		
		System.out.println("---testGetTotal---");
		
		Assert.assertEquals(product.getTotal(),12.49);
		System.out.println(product.getTotal());
	}

	@Test
	public void testSetTotal() {
		
		System.out.println("---testSetTotal---");
		
		Assert.assertEquals(product.getTotal(),12.49);
		System.out.println(product.getTotal());
	}

	@Test
	public void testGetTaxAmount() {
		
		System.out.println("---testGetTaxAmount---");
		
		Assert.assertEquals(product.getTaxAmount(),0.0);
		System.out.println(product.getTaxAmount());
	}

	@Test
	public void testSetTaxAmount() {
		
		System.out.println("---testSetTaxAmount---");
		
		product.setTaxAmount(12.34);

		Assert.assertEquals(product.getTaxAmount(),12.34);
		System.out.println(product.getTaxAmount());
	}

}
