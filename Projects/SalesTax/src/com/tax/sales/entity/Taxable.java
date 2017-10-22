package com.tax.sales.entity;

import com.tax.sales.exception.TaxException;

/**
 * Interface to calculate tax
 * @author 
 *
 */
public interface Taxable {

	public double computeTax() throws TaxException;
}
