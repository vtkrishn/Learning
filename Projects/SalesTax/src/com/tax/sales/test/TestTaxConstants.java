package com.tax.sales.test;

import junit.framework.TestCase;

import org.junit.Test;

import com.tax.sales.util.TaxConstants;

public class TestTaxConstants extends TestCase {

	@Test
	public void testConstants() {
		System.out.println("---testConstants---");
		
		assertNotNull(TaxConstants.fileHandler);
		assertNotNull(TaxConstants.MAX_FILE_SIZE);
		assertNotNull(TaxConstants.MAX_ARRAY_SIZE);
		assertNotNull(TaxConstants.IMPORTED_TYPE);
		assertNotNull(TaxConstants.LOCAL_TYPE);
		assertNotNull(TaxConstants.COMMA);
		assertNotNull(TaxConstants.SPACE);
		assertNotNull(TaxConstants.MANUAL_ENTRY);
		assertNotNull(TaxConstants.FILE_ENTRY);
		assertNotNull(TaxConstants.TAX_WAIVER_FILE);
		assertNotNull(TaxConstants.SALES_TAX_PERCENTAGE);
		assertNotNull(TaxConstants.IMPORT_DUTY_PERCENTAGE);
		assertNotNull(TaxConstants.ROUNDUP_FACTOR);
		
		System.out.println("fileHandler = "+TaxConstants.fileHandler);
		System.out.println("MAX_FILE_SIZE = "+TaxConstants.MAX_FILE_SIZE);
		System.out.println("MAX_ARRAY_SIZE = "+TaxConstants.MAX_ARRAY_SIZE);
		System.out.println("IMPORTED_TYPE = "+TaxConstants.IMPORTED_TYPE);
		System.out.println("LOCAL_TYPE = "+TaxConstants.LOCAL_TYPE);
		System.out.println("COMMA = "+TaxConstants.COMMA);
		System.out.println("SPACE = "+TaxConstants.SPACE);
		System.out.println("MANUAL_ENTRY = "+TaxConstants.MANUAL_ENTRY);
		System.out.println("FILE_ENTRY = "+TaxConstants.FILE_ENTRY);
		System.out.println("TAX_WAIVER_FILE = "+TaxConstants.TAX_WAIVER_FILE);
		System.out.println("SALES_TAX_PERCENTAGE = "+TaxConstants.SALES_TAX_PERCENTAGE);
		System.out.println("IMPORT_DUTY_PERCENTAGE = "+TaxConstants.IMPORT_DUTY_PERCENTAGE);
		System.out.println("ROUNDUP_FACTOR = "+TaxConstants.ROUNDUP_FACTOR);
		
		
	}

}
