package com.tax.sales.test;

import org.junit.Before;
import org.junit.Test;

import com.tax.sales.entity.Batch;
import com.tax.sales.entity.Product;
import com.tax.sales.entity.Receipt;

public class TestReceipt {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testGenerateReceipt() {
		Receipt.generateReceipt(new Product[0],new Batch() );
	}

}
