package com.tax.sales.test;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.tax.sales.entity.Batch;
import com.tax.sales.entity.Product;
import com.tax.sales.entity.Receipt;
import com.tax.sales.exception.TaxException;
import com.tax.sales.util.TaxConstants;
import com.tax.sales.util.TaxUtility;

public class TestTaxClient extends TestCase{

	Batch salesBatch;
	//Stores the item in an array
	Product[] products;
	
	@Before
	public void setUp() throws Exception {
		
		salesBatch = new Batch();
		
	}

	public void testInputScenario1()throws TaxException{
		System.out.println("Input 1:");
		System.out.println("1 book at 12.49");
		System.out.println("1 music CD at 14.99");
		System.out.println("1 chocolate bar at 0.85");
		
		
		String[] value = {"1,book,12.49","1,music,14.99","1,chocolate,0.85"};
		
		String itemType =TaxConstants.LOCAL_TYPE;
		//set the batch size
		salesBatch.setSize(Integer.valueOf(3));
		
		products = new Product[salesBatch.getSize()];
		
		salesBatch.setProducts(products);
		
		for(int i = 0;i<salesBatch.getSize();i++){
			basicProcessing(value[i],itemType,i);
			
			System.out.println("Item Price:"+TaxUtility.round(salesBatch.getItemTotal(i))+" || Sales Tax:"+TaxUtility.round(salesBatch.getSalesTaxTotal(i))+" || (Item + Sales Tax):"+TaxUtility.round(salesBatch.getTotal(i)));
			
		}
		Receipt.generateReceipt(products, salesBatch);
		
	}
	
	public void testInputScenario2() throws TaxException{
		System.out.println("Input 2:");
		System.out.println("1 imported box of chocolates at 10.00");
		System.out.println("1 imported bottle of perfume at 47.50");
		
		String[] value = {"1,chocolate,10.00","1,perfume,47.50"};
		
		String itemType =TaxConstants.IMPORTED_TYPE;
		//set the batch size
		salesBatch.setSize(Integer.valueOf(2));
		
		products = new Product[salesBatch.getSize()];
		
		salesBatch.setProducts(products);
		
		for(int i = 0;i<salesBatch.getSize();i++){
			basicProcessing(value[i],itemType,i);
			
			System.out.println("Item Price:"+TaxUtility.round(salesBatch.getItemTotal(i))+" || Sales Tax:"+TaxUtility.round(salesBatch.getSalesTaxTotal(i))+" || (Item + Sales Tax):"+TaxUtility.round(salesBatch.getTotal(i)));
			
		}
		Receipt.generateReceipt(products, salesBatch);
		
	}

	public void testInputScenario3() throws TaxException{
		System.out.println("Input 3:");
		System.out.println("1 imported bottle of perfume at 27.99");
		System.out.println("1 bottle of perfume at 18.99");
		System.out.println("1 packet of headache pills at 9.75");
		System.out.println("1 box of imported chocolates at 11.25");
		
		String[] value = {"1,perfume,27.99","1,perfume,18.99","1,pills,9.75","1,chocolate,11.25"};
		
		String itemType =TaxConstants.IMPORTED_TYPE;
		//set the batch size
		salesBatch.setSize(Integer.valueOf(4));
		
		products = new Product[salesBatch.getSize()];
		
		salesBatch.setProducts(products);
		
		for(int i = 0;i<salesBatch.getSize();i++){
			
			basicProcessing(value[i],(i==0 || i ==3 ? itemType : TaxConstants.LOCAL_TYPE),i);
			
			System.out.println("Item Price:"+TaxUtility.round(salesBatch.getItemTotal(i))+" || Sales Tax:"+TaxUtility.round(salesBatch.getSalesTaxTotal(i))+" || (Item + Sales Tax):"+TaxUtility.round(salesBatch.getTotal(i)));
			
		}
		Receipt.generateReceipt(products, salesBatch);
		
	}
	@Test
	public void testManualEntry() throws TaxException {
		
		System.out.println("---testManualEntry - calculate import duty---");
		
		String value = "1,book,24.9";
		//set the batch size
		salesBatch.setSize(Integer.valueOf(1));
		
		products = new Product[salesBatch.getSize()];
		
		salesBatch.setProducts(products);
		
		basicProcessing(value,TaxConstants.IMPORTED_TYPE,0);
		
		System.out.println("Item Price:"+TaxUtility.round(salesBatch.getItemTotal(0))+" || Sales Tax:"+TaxUtility.round(salesBatch.getSalesTaxTotal(0))+" || (Item + Sales Tax):"+TaxUtility.round(salesBatch.getTotal(0)));
		
		Receipt.generateReceipt(products, salesBatch);
		
		System.out.println("---testManualEntry - calculate no tax---");
		
		basicProcessing(value,TaxConstants.LOCAL_TYPE,0);
		
		System.out.println("Item Price:"+TaxUtility.round(salesBatch.getItemTotal(0))+" || Sales Tax:"+TaxUtility.round(salesBatch.getSalesTaxTotal(0))+" || (Item + Sales Tax):"+TaxUtility.round(salesBatch.getTotal(0)));
		
		Receipt.generateReceipt(products, salesBatch);
		
		System.out.println("---testManualEntry - calculate basic tax---");
		
		value = "2,perfume,12.3";
		
		basicProcessing(value,TaxConstants.LOCAL_TYPE,0);
		
		System.out.println("Item Price:"+TaxUtility.round(salesBatch.getItemTotal(0))+" || Sales Tax:"+TaxUtility.round(salesBatch.getSalesTaxTotal(0))+" || (Item + Sales Tax):"+TaxUtility.round(salesBatch.getTotal(0)));
		
		Receipt.generateReceipt(products, salesBatch);
		
		System.out.println("---testManualEntry - calculate basic tax and import duty tax---");
		
		value = "2,perfume,12.3";
		
		basicProcessing(value,TaxConstants.IMPORTED_TYPE,0);
		
		System.out.println("Item Price:"+TaxUtility.round(salesBatch.getItemTotal(0))+" || Sales Tax:"+TaxUtility.round(salesBatch.getSalesTaxTotal(0))+" || (Item + Sales Tax):"+TaxUtility.round(salesBatch.getTotal(0)));
		
		Receipt.generateReceipt(products, salesBatch);
	}

	@Test
	public void testFileEntry() throws TaxException {
		
		System.out.println("---testFileEntry - calculate import duty---");
		
		File value = new File("C:\\testInput.txt");
		//set the batch size
		salesBatch.setSize(Integer.valueOf(1));
		
		products = new Product[salesBatch.getSize()];
		
		salesBatch.setProducts(products);
		
		basicProcessing(value,TaxConstants.IMPORTED_TYPE);
		
		System.out.println("Item Price:"+TaxUtility.round(salesBatch.getItemTotal(0))+" || Sales Tax:"+TaxUtility.round(salesBatch.getSalesTaxTotal(0))+" || (Item + Sales Tax):"+TaxUtility.round(salesBatch.getTotal(0)));
		
		Receipt.generateReceipt(products, salesBatch);
		
		System.out.println("---testFileEntry - calculate no tax---");
		
		basicProcessing(value,TaxConstants.LOCAL_TYPE);
		
		System.out.println("Item Price:"+TaxUtility.round(salesBatch.getItemTotal(0))+" || Sales Tax:"+TaxUtility.round(salesBatch.getSalesTaxTotal(0))+" || (Item + Sales Tax):"+TaxUtility.round(salesBatch.getTotal(0)));
		
		Receipt.generateReceipt(products, salesBatch);
		
		System.out.println("---testFileEntry - calculate basic tax---");
		
		basicProcessing(value,TaxConstants.LOCAL_TYPE);
		products[0].setName("perfume");
		
		products[0].setTaxAmount(products[0].computeTax());
		
		//grand item Total
		salesBatch.setItemTotal(products[0].getTotal(),0);
		salesBatch.setSalesTaxTotal(products[0].getTaxAmount(),0);
		
		System.out.println("Item Price:"+TaxUtility.round(salesBatch.getItemTotal(0))+" || Sales Tax:"+TaxUtility.round(salesBatch.getSalesTaxTotal(0))+" || (Item + Sales Tax):"+TaxUtility.round(salesBatch.getTotal(0)));
		
		Receipt.generateReceipt(products, salesBatch);
		
		System.out.println("---testFileEntry - calculate basic tax and import duty tax---");
				
		basicProcessing(value,TaxConstants.IMPORTED_TYPE);
		products[0].setName("perfume");
		
		products[0].setTaxAmount(products[0].computeTax());
		
		//grand item Total
		salesBatch.setItemTotal(products[0].getTotal(),0);
		salesBatch.setSalesTaxTotal(products[0].getTaxAmount(),0);
		System.out.println("Item Price:"+TaxUtility.round(salesBatch.getItemTotal(0))+" || Sales Tax:"+TaxUtility.round(salesBatch.getSalesTaxTotal(0))+" || (Item + Sales Tax):"+TaxUtility.round(salesBatch.getTotal(0)));
		
		Receipt.generateReceipt(products, salesBatch);
		
		value = new File("C;\\testInput.txt");
		
		System.out.println("---testFileEntry - file does not exist---");
		
		try{
		basicProcessing(value,TaxConstants.LOCAL_TYPE);
		}
		catch(TaxException e){
			
		}
	}
	
	private void basicProcessing(String value, String itemType, int index) throws TaxException{
		
		System.out.println("Quantity Item Price : "+ value);
		products = TaxUtility.processInformation(value,products,index);
				
		System.out.println("Import type : "+itemType);
		products[index].setItemType(itemType);
		
		products[index].setTaxAmount(products[index].computeTax());
		
		//grand item Total
		salesBatch.setItemTotal(products[index].getTotal(),index);
		salesBatch.setSalesTaxTotal(products[index].getTaxAmount(),index);
	}
	
	private void basicProcessing(File value, String itemType) throws TaxException{
	
		
		System.out.println("Quantity Item Price : "+ value);
		products = TaxUtility.processFileInformation(value,products,0);
				
		System.out.println("Import type : "+itemType);
		products[0].setItemType(itemType);
		
	}
}
