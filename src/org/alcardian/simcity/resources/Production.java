package org.alcardian.simcity.resources;

import java.math.BigDecimal;

public class Production {
	public static int truckHourCost = 50;	//The Cost per hour for one truck.
	//TODO Add hour costs, create method to calculate out value
	
	public static int METAL = 1;
	public static int ALLOY = 2;
	public static int FUEL = 3;
	public static int PLASTIC = 4;
	public static int PROCESSOR = 5;
	public static int TV = 6;
	public static int Computer = 7;
	
	/**
	 * 
	 * @param product What commodity that are being produced.
	 * @param modules Number of modules on building for producing commodity.
	 * @param trucks Number of trucks that are on the building.
	 * @return The profit of producing chosen commodity.
	 */
	public static BigDecimal getProductionProfit(int product, int modules, int trucks){
		
		return null;
	}
}
