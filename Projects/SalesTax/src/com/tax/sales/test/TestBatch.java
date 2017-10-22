package com.tax.sales.test;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tax.sales.entity.Batch;
import com.tax.sales.entity.Product;

public class TestBatch  extends TestCase{

	Batch batch;
	Product[] product;
	@Before
	public void setUp() throws Exception {
		
		batch = new Batch();
		
		product = new Product[4];
		
	}

	@Test
	public void testGetGrandItemTotal() {
		System.out.println("---testGetGrandItemTotal---");
		
		batch.setItemTotal(24.59, 0);
		
		Assert.assertEquals(batch.getGrandItemTotal(),24.59);
		System.out.println(batch.getGrandItemTotal());
		
		batch.setItemTotal(0, 0);
		
		Assert.assertEquals(batch.getGrandItemTotal(),0.0);
		
		System.out.println(batch.getGrandItemTotal());

	}

	@Test
	public void testGetGrandTaxTotal() {
		System.out.println("---testGetGrandTaxTotal---");
		
		batch.setSalesTaxTotal(23.45,0);
		
		Assert.assertEquals(batch.getGrandTaxTotal(),23.45);
		
		System.out.println(batch.getGrandTaxTotal());
		
		batch.setSalesTaxTotal(0,0);
		
		Assert.assertEquals(batch.getGrandTaxTotal(),0.0);
		
		System.out.println(batch.getGrandTaxTotal());
	}

	@Test
	public void testGetGrandTotal() {
		System.out.println("---testGetGrandTotal---");
		
		System.out.println(batch.getGrandTotal());
		
		batch.setSalesTaxTotal(23.45,0);
		batch.setItemTotal(24.59, 0);
		
		Assert.assertEquals(batch.getGrandTotal(),48.04);
		System.out.println(batch.getGrandTotal());
		
	}

	@Test
	public void testGetProduct() {
		System.out.println("---testGetProduct---");
		
		product[0] = new Product(1,"book",112.49);
		
		batch.setProducts(product);
		
		System.out.println(batch.getProducts(0));
		
	}

	@Test
	public void testSetProduct() {
		System.out.println("---testSetProduct---");
		
		product[0] = new Product(1,"book",112.49);
		
		batch.setProducts(product);
		
		System.out.println(batch.getProducts(0));
	}

	@Test
	public void testGetSize() {
		System.out.println("---testGetSize---");
		
		batch.setSize(1);
		
		Assert.assertEquals(batch.getSize(),1);
		System.out.println(batch.getSize());
	}

	@Test
	public void testSetSize() {
		System.out.println("---testSetSize---");
		
		Assert.assertEquals(batch.getSize(),0);
		System.out.println(batch.getSize());
	}

	@Test
	public void testGetItemTotal() {
		System.out.println("---testGetItemTotal---");
		
		Assert.assertEquals(batch.getItemTotal(0),0.0);
		System.out.println(batch.getItemTotal(0));
	}

	@Test
	public void testSetItemTotal() {
		System.out.println("---testSetItemTotal---");
		
		batch.setItemTotal(23.45, 0);
		
		Assert.assertEquals(batch.getItemTotal(0),23.45);
		System.out.println(batch.getItemTotal(0));
		
		
	}

	@Test
	public void testGetSalesTaxTotal() {
		System.out.println("---testGetSalesTaxTotal---");
		
		Assert.assertEquals(batch.getSalesTaxTotal(0),0.0);
		System.out.println(batch.getSalesTaxTotal(0));
		
	}

	@Test
	public void testSetSalesTaxTotal() {
		System.out.println("---testSetSalesTaxTotal---");
		
		batch.setSalesTaxTotal(12.34,0);
		
		Assert.assertEquals(batch.getSalesTaxTotal(0),12.34);
		System.out.println(batch.getSalesTaxTotal(0));
		
	}

	@Test
	public void testGetTotal() {
		System.out.println("---testGetTotal---");
		
		batch.setSalesTaxTotal(23.45,0);
		batch.setItemTotal(24.59, 0);
		
		Assert.assertEquals(batch.getTotal(0),48.04);
		System.out.println(batch.getTotal(0));
	}

}
