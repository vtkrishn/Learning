package com.nasa.mars.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExplorationUtil {
	
	/**
	 * Utility method to get the User Inputs
	 * @return
	 */
	public static String getUserCoOrdinates(){
		
		String inputValue = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			inputValue = br.readLine();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return inputValue;
	}
	
}
