package com.tax.sales.test;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.tax.sales.entity.Product;
import com.tax.sales.exception.TaxException;
import com.tax.sales.util.TaxConstants;
import com.tax.sales.util.TaxUtility;

public class TestTaxUtility  extends TestCase{

	File file;
	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testLoadFromFile() {
		System.out.println("---testLoadFromFile---");
		
		try {
			TaxUtility.loadFromFile(TaxConstants.TAX_WAIVER_FILE, true);
		} catch (TaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveToFile() {
		System.out.println("---testSaveToFile---");
		
		try {
			TaxUtility.saveToFile(new File("C:\\123_fromTest.txt"), true);
		} catch (TaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testProcessInformation() {
		System.out.println("---testProcessInformation---");
		
		try {
			TaxUtility.processInformation("1,book,23.45", new Product[4], 0);
		} catch (TaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testProcessFileInformation() {
		System.out.println("---testProcessFileInformation---");
		
		try {
			TaxUtility.processFileInformation(new File("C:\\123_fromTest.txt"), new Product[4], 0);
		} catch (TaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testCalculateTotal() {
		System.out.println("---testCalculateTotal---");
		
		TaxUtility.calculateTotal(new double[4]);
	}

	@Test
	public void testRoundValues() {
		System.out.println("---testRoundValues---");
		System.out.println(TaxUtility.round(12.49956788898));
		System.out.println(TaxUtility.round(1.49999));
		System.out.println(TaxUtility.round(11));
		System.out.println(TaxUtility.round(0.123411));
		System.out.println(TaxUtility.round(0.000011));
		System.out.println(TaxUtility.round(0.249811));
		System.out.println(TaxUtility.round(0.299811));
		System.out.println(TaxUtility.round(0.2829800000002));
		
	}

}
