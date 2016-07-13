package org.alcardian.simcity.resources;

/**
 * Class to store information about Commodities/Resources like coal.
 * 
 * @author Alcardian
 * 
 */
public class Commodity {
	private int price;
	private int units;
	private String name;

	/**
	 * Constructs an instance of the commodity object
	 * 
	 * @param price
	 *            The price for the number of units.
	 * @param units
	 *            The number of units that are sold together for the price.
	 * @param name
	 *            The name of the commodity.
	 */
	public Commodity(int price, int units, String name) {
		/*
		 * this.price = price; this.units = units; this.name = name;
		 */
		setPrice(price);
		setUnits(units);
		setName(name);
	}

	/**
	 * Gets the price of the commodity. Note that this price is for each set of
	 * units.
	 * 
	 * @return The price for this commodity.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price of the commodity. Note that this price is for each set of
	 * units.
	 * 
	 * @param price
	 *            The price for this commodity.
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Gets the number of units of this commodity that are sold for the set
	 * price.
	 * 
	 * @return
	 */
	public int getUnits() {
		return units;
	}

	/**
	 * Sets the number of units of this commodity that are sold for the set
	 * price.
	 * 
	 * @param units
	 */
	public void setUnits(int units) {
		this.units = units;
	}

	/**
	 * Gets the name of the commodity.
	 * 
	 * @return Commodity name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the commodity.
	 * 
	 * @param name
	 *            Commodity name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * function to print out all data stored in class.
	 */
	public void printAll() {
		System.out.println(name);
		System.out.println(price);
		System.out.println(units);
	}
}
