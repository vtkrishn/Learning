package com.tax.sales.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.tax.sales.util.TaxConstants;

/**
 * Logger class for tax computation
 * @author
 *
 */
public class TaxLogger {
	
	private static Logger logger;
	
	static{
		
		try {
			logger = Logger.getLogger("TaxLogger");
			logger.addHandler(TaxConstants.fileHandler);
			logger.setLevel(Level.ALL);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			logger.entering("com.tax.sales.TaxLogger", "main method - TaxException", e.getMessage());
		}
		
	}
	
	/**
	 * Get the logger reference
	 * @return
	 */
	public static Logger getLogger(){
		return logger;
	}
}
