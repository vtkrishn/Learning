package com.tax.sales.entity;

import com.tax.sales.util.TaxConstants;
import com.tax.sales.util.TaxUtility;
/**
 * The Batch for the purchase
 * @author 
 *
 */
public class Batch {
			
	private double[] itemTotal = new double[TaxConstants.MAX_ARRAY_SIZE]; 
	private double[] salesTaxTotal = new double[TaxConstants.MAX_ARRAY_SIZE];
	
	private Product[] products;
	private int size;
	
	/**
	 * Calculates the sum of all products
	 * @return
	 */
	public double getGrandItemTotal() {
		return (TaxUtility.calculateTotal(itemTotal));
	}
	
	/**
	 * Calculates the sum of all sales tax applicable to each of the products
	 * @return
	 */
	public double getGrandTaxTotal() {
		return (TaxUtility.calculateTotal(salesTaxTotal));
	}
	
	/**
	 * Calculates the sum of all products with sales tax
	 * @return
	 */
	public double getGrandTotal() {
		return (getGrandItemTotal() + getGrandTaxTotal());
	}

	/**
	 * Get specific product
	 * @param index
	 * @return
	 */
	public Product getProducts(int index) {
		return products[index];
	}

	/**
	 * Set the product
	 * @param item
	 */
	public void setProducts(Product[] products) {
		this.products = products;
	}

	/**
	 * Get batch size
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Set the batch size
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Get the total of specific item
	 * @param index
	 * @return
	 */
	public double getItemTotal(int index) {
		return itemTotal[index];
	}

	/**
	 * Set the product total
	 * @param itemTotal
	 * @param index
	 */
	public void setItemTotal(double itemTotal,int index) {
		this.itemTotal[index] = itemTotal;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public double getSalesTaxTotal(int index) {
		return salesTaxTotal[index];
	}

	/**
	 * Set the sales tax total
	 * @param salesTaxTotal
	 * @param index
	 */
	public void setSalesTaxTotal(double salesTaxTotal,int index) {
		this.salesTaxTotal[index] = salesTaxTotal;
	}

	/**
	 * Get the total for specific product
	 * @param index
	 * @return
	 */
	public double getTotal(int index) {
		return getItemTotal(index) + getSalesTaxTotal(index);
	}

	
}
