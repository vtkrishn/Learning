package com.tax.sales.client;

import java.io.File;

import com.tax.sales.entity.Batch;
import com.tax.sales.entity.Product;
import com.tax.sales.entity.Receipt;
import com.tax.sales.exception.TaxException;
import com.tax.sales.logging.TaxLogger;
import com.tax.sales.util.TaxConstants;
import com.tax.sales.util.TaxUtility;

/**
 * Client class for the Sales Tax application
 * @author 
 *
 */
public class TaxClient {
	
	public static void main(String[] args) {
		
		TaxLogger.getLogger().entering("com.tax.sales.TaxClient", "main method");
		
		String numberOfEntries="";
		String itemType = "";
		String value = "";
		
		Batch salesBatch = new Batch();
		
		System.out.println("Do you want to enter items manually or from a file (M|F)");
		String inputOption = TaxUtility.getValues();
		
		TaxLogger.getLogger().entering("com.tax.sales.TaxClient", "main method - input option", inputOption);
		
		if(inputOption.equalsIgnoreCase(TaxConstants.MANUAL_ENTRY)){
			
			try {
				manualEntry(numberOfEntries,itemType,value,salesBatch);
			} catch (TaxException e) {
				
				TaxLogger.getLogger().entering("com.tax.sales.TaxClient", "main method - TaxException", e.getMessage());
			}
			
		}
		else if(inputOption.equalsIgnoreCase(TaxConstants.FILE_ENTRY)){
			try {
			fileEntry(itemType,salesBatch);
			} catch (TaxException e) {
			
				TaxLogger.getLogger().entering("com.tax.sales.TaxClient", "main method - TaxException", e.getMessage());
			}
		}
		else{
			System.out.println("You have not entered the option given: defaulting to manual entry");
			
			try {
				manualEntry(numberOfEntries,itemType,value,salesBatch);
			} catch (TaxException e) {
			
				
				TaxLogger.getLogger().entering("com.tax.sales.TaxClient", "main method - TaxException", e.getMessage());
				
			}
			
		}
				
	}
	
	/*
	 * method to compute manual entry
	 * @param numberOfEntries
	 * @param itemType
	 * @param value
	 * @param salesBatch
	 * @throws SalesTaxException
	 */
	private static void manualEntry(String numberOfEntries,String itemType,String value,Batch salesBatch) throws TaxException{
		
		TaxLogger.getLogger().entering("com.tax.sales.TaxClient", "manualEntry - input option");
		
		System.out.println("How many Items do you want to compute : Enter the number");
		
		try{
		numberOfEntries = TaxUtility.getValues();
		
		//set the batch size
		salesBatch.setSize(Integer.valueOf(numberOfEntries));
		
		}
		catch(NumberFormatException e){
			
			TaxLogger.getLogger().entering("com.tax.sales.TaxClient", "manualEntry - NumberFormatException",e.getMessage());
			
			throw new TaxException("The number format is wrong");
				
		}
		
		
		
		//Stores the item in an array
		Product[] products = new Product[salesBatch.getSize()];
		
		salesBatch.setProducts(products);
		
		for(int i = 0;i<salesBatch.getSize();i++){
			
		//format of input Quantity Item Price
		System.out.println("Enter the particulars in comma separated format : Quantity,Item,Price");
		value = TaxUtility.getValues();
		
		products = TaxUtility.processInformation(value,products,i);
		
		System.out.println("Enter the ItemType : Imported or Not : Y/N");
		itemType = TaxUtility.getValues();
		
		//Set the item type
		products[i].setItemType(itemType.equalsIgnoreCase("Y") ? TaxConstants.IMPORTED_TYPE : TaxConstants.LOCAL_TYPE);
		
		TaxLogger.getLogger().entering("com.tax.sales.TaxClient", "manualEntry - itemType",products[i].getItemType());
		
			//calculate sales tax for particular item
			products[i].setTaxAmount(products[i].computeTax());
							
			//grand item Total
			salesBatch.setItemTotal(products[i].getTotal(),i);
			salesBatch.setSalesTaxTotal(products[i].getTaxAmount(),i);
			
			System.out.println("Item Price:"+salesBatch.getItemTotal(i)+" || Sales Tax:"+salesBatch.getSalesTaxTotal(i)+" || (Item + Sales Tax):"+salesBatch.getTotal(i));
		
			
		}
		

		Receipt.generateReceipt(products,salesBatch);
	}

	
	 /* Method to compute file entry
	 * @param numberOfEntries
	 * @param itemType
	 */
	private static void fileEntry(String itemType,Batch salesBatch) throws TaxException{
		
		System.out.println("Specify the location of the file :(C:\\123.txt) :\n inputs in the file should be comma separated");
		String fileOption = TaxUtility.getValues();
		
		System.out.println("Enter the Item Type : Imported? : Y/N");
		itemType = TaxUtility.getValues();
		
		salesBatch.setSize(TaxConstants.MAX_FILE_SIZE);
		
		//Stores the item in an array
		Product[] fileItem = new Product[salesBatch.getSize()];
		
		salesBatch.setProducts(fileItem);
		
		for(int i = 0;i<salesBatch.getSize();i++){
		
		System.out.println("reading from the file ......");
			
		fileItem = TaxUtility.processFileInformation(new File(fileOption),fileItem,i);
		
		//Set the item type
		fileItem[i].setItemType(itemType.equalsIgnoreCase("Y") ? TaxConstants.IMPORTED_TYPE : TaxConstants.LOCAL_TYPE);
			
		TaxLogger.getLogger().entering("com.tax.sales.TaxClient", "manualEntry - fileEntry",fileItem[i].getItemType());
		
		
			//calculate sales tax for particular item
			fileItem[i].setTaxAmount(fileItem[i].computeTax());
							
			//grand item Total
			salesBatch.setItemTotal(fileItem[i].getTotal(),i);
			salesBatch.setSalesTaxTotal(fileItem[i].getTaxAmount(),i);
			
			System.out.println("Item Price:"+salesBatch.getItemTotal(i)+" || Sales Tax:"+salesBatch.getSalesTaxTotal(i)+" || (Item + Sales Tax):"+salesBatch.getTotal(i));
		
		}
		
		Receipt.generateReceipt(fileItem,salesBatch);
	}
}
