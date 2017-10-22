package com.tax.sales.entity;

import com.tax.sales.exception.TaxException;
import com.tax.sales.util.TaxCalculator;

/**
 * Item class defines the Item available for purchasing
 * 
 * @author 
 *
 */
public class Product implements Taxable{

	private int quantity;
	private String name;
	
	private double price;
	private double taxAmount;
		
	private String itemType;
	
	private TaxCalculator taxCalculator;

	public double getNetTotal() {
		return (getTotal() + getTaxAmount());
	}

	/**
	 * Get the Quantity
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Set the Quantity
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get the Name
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the Name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the Price
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Set the Name
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Get the Item type
	 * @return
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * Set the Item type
	 * @param itemType
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	/**
	 * Product Constructor
	 * @param quantity
	 * @param name
	 * @param price
	 */
	public Product(int quantity, String name, double price){
		
		this.quantity = quantity;
		this.name = name;
		this.price = price;
		
		taxCalculator = new TaxCalculator(this);
		
	}
	
	/**
	 * Returns the total items
	 * @return
	 */
	public double getTotal() {
		
		return (this.getQuantity() * this.getPrice());
	}

	/**
	 * Returns the tax amount
	 * @return
	 */
	public double getTaxAmount() {
		return taxAmount;
	}
	
	/**
	 * Set the tax amount
	 * @param tax
	 */
	public void setTaxAmount(double taxAmount) {
		this.taxAmount =  taxAmount;
	}

	@Override
	/**
	 * Computes the tax for the product
	 */
	public double computeTax() throws TaxException {
		// TODO Auto-generated method stub
		return (taxCalculator.calculateBasicTax() + taxCalculator.calculateImportDutyTax());
	}
	
}
