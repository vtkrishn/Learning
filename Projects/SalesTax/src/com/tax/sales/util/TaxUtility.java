package com.tax.sales.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.tax.sales.entity.Product;
import com.tax.sales.exception.TaxException;
import com.tax.sales.logging.TaxLogger;

/**
 * Utility class to compute tax
 * @author 
 *
 */
public class TaxUtility {

	/**
	 * Utility method to get the User Inputs
	 * @return
	 */
	public static String getValues(){
		
		String inputValue = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			inputValue = br.readLine();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return inputValue;
	}
	
	/**
	 * Utility method to load from a file
	 * @param file
	 * @param isForInput
	 * @return
	 */
	public static ArrayList<String> loadFromFile(File file, boolean isForInput) throws TaxException{
		
		FileInputStream fileInputStream;
		ArrayList<String> arr = new ArrayList<String> ();
		int i = 0;
		
		try {
			
			if(!file.exists()){
				
				TaxLogger.getLogger().entering("com.tax.sales.util.TaxUtility", "loadFromFile","File does not exist - Creating one");
				
				saveToFile((isForInput == true ? file : TaxConstants.TAX_WAIVER_FILE),isForInput);
			}
			
				fileInputStream =  new FileInputStream(isForInput == true ? file : TaxConstants.TAX_WAIVER_FILE);
				
				BufferedInputStream bf = new BufferedInputStream(fileInputStream);
				
				BufferedReader bfr
				= new BufferedReader(new InputStreamReader(bf)); 
				
				String line = null;
				
				while((line = bfr.readLine()) != null){
					arr.add(line);
				i++;
				}
				fileInputStream.close();

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			TaxLogger.getLogger().entering("com.tax.sales.util.TaxUtility", "loadFromFile - FileNotFoundException",e.getMessage());
			
			throw new TaxException("The File does not exit");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			TaxLogger.getLogger().entering("com.tax.sales.util.TaxUtility", "loadFromFile - IOException",e.getMessage());
			
			throw new TaxException("I/O error occured");
		}
		
		return arr;
	}
	
	/**
	 * Utility method to store information to a file
	 * @param fileName
	 * @param isForInput
	 */
	public static void saveToFile(File fileName,boolean isForInput) throws TaxException{
		
		FileOutputStream fileOutputStream;
		
		try {
			fileOutputStream =  new FileOutputStream(fileName);
			
			if(isForInput){
				fileOutputStream.write("1,book,12.49\n".getBytes());
				fileOutputStream.write("1,chocolate,11.99\n".getBytes());
				fileOutputStream.write("1,pills,111.99\n".getBytes());
				fileOutputStream.write("1,perfume,10.0\n".getBytes());
			}
			else{
				fileOutputStream.write("BOOK\n".getBytes());
				fileOutputStream.write("PILLS\n".getBytes());
				fileOutputStream.write("MEDICINE\n".getBytes());
				fileOutputStream.write("CHOCOLATE\n".getBytes());
			}
			fileOutputStream.flush();
			fileOutputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			TaxLogger.getLogger().entering("com.tax.sales.util.TaxUtility", "saveToFile - FileNotFoundException",e.getMessage());
			
			throw new TaxException("The File does not exit");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			TaxLogger.getLogger().entering("com.tax.sales.util.TaxUtility", "saveToFile - IOException",e.getMessage());
			
			throw new TaxException("I/O error occured");
		}
		
	}
	
	/**
	 * Process information for manual entry
	 * @param value
	 * @param item
	 * @param index
	 * @return
	 */
	public static Product[] processInformation(String value,Product[] item, int index) throws TaxException{
		
		try{
			String itemQuatity = value.substring(0, value.indexOf(TaxConstants.COMMA));
			
			System.out.print(itemQuatity.trim());
			
			String itemName = value.substring(value.indexOf(TaxConstants.COMMA)+1, value.lastIndexOf(TaxConstants.COMMA));
			
			System.out.print(" " + itemName.trim());
			
			String itemPrice = value.substring(value.lastIndexOf(TaxConstants.COMMA)+1, value.length());
			
			System.out.print(" " + itemPrice.trim() + "\n");
			
			item[index] = new Product(Integer.valueOf(itemQuatity),itemName,Double.valueOf(itemPrice));
		}
		catch (StringIndexOutOfBoundsException e) {
			
			TaxLogger.getLogger().entering("com.tax.sales.util.TaxUtility", "saveToFile - StringIndexOutOfBoundsException",e.getMessage());
			
			throw new TaxException("String index exceeds the limit");
		}
		return item;
	}
	
	/**
	 * Process information from a file
	 * @param file
	 * @param item
	 * @return
	 */
	public static Product[] processFileInformation(File file,Product[] item, int index) throws TaxException{
		try{
			ArrayList<String> fileValues = loadFromFile(file, true);
			
			String itemQuatity = fileValues.get(index).substring(0, fileValues.get(index).indexOf(TaxConstants.COMMA));
			
			System.out.print(itemQuatity.trim());
			
			String itemName = fileValues.get(index).substring(fileValues.get(index).indexOf(TaxConstants.COMMA)+1, fileValues.get(index).lastIndexOf(TaxConstants.COMMA));
			
			System.out.print(" " + itemName.trim());
			
			String itemPrice = fileValues.get(index).substring(fileValues.get(index).lastIndexOf(TaxConstants.COMMA)+1, fileValues.get(index).length());
			
			System.out.print(" " + itemPrice.trim() + "\n");
			
			item[index] = new Product(Integer.valueOf(itemQuatity),itemName,Double.valueOf(itemPrice));
		}
		catch (StringIndexOutOfBoundsException e) {
			
			TaxLogger.getLogger().entering("com.tax.sales.util.TaxUtility", "processFileInformation - StringIndexOutOfBoundsException",e.getMessage());
			
			throw new TaxException("String index exceeds the limit");
		}
		return item;
	}
	
	/**
	 * Calculates the sum of values of each element in an array
	 * @param total
	 * @return
	 */
	public static double calculateTotal(double[] total){
		
		double temp = 0.0;
		for (int i = 0; i < total.length; i++) {
			temp =  temp + total[i];
		}
		
		return temp;
	}
	

	/**
	 * Rounds the value to two decimal points
	 * @param value
	 * @return
	 */
	public static double round(double value){
		
		DecimalFormat decimal = new DecimalFormat();

		double temp =  Double.valueOf(decimal.format(value));
		
		return temp;
	}
	
	
}
