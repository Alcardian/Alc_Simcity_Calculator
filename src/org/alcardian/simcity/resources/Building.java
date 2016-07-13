package org.alcardian.simcity.resources;

/**
 * This abstract class is used as base for different building classes.
 * 
 * @author Alcardian
 * 
 */
public class Building {
	private int buildingID;
	private String buildingName;
	private int truckSlots;
	private int trucksActive;
	private int truckPrice; // truck price are price per truck per hour.

	/**
	 * 
	 * @param truckSlots
	 *            Number of trucks you can maximum have in the building.
	 * @param trucksActive
	 *            Number of trucks you have in the building.
	 * @param truckPrice
	 *            The price per hour for 1 truck.
	 */
	public Building(int truckSlots, int trucksActive, int truckPrice,
			int buildingID, String buildingName) {
		this.truckSlots = truckSlots;
		this.trucksActive = trucksActive;
		this.truckPrice = truckPrice;
		this.buildingID = buildingID;
		this.buildingName = buildingName;
	}

	/**
	 * 
	 * @return The maximum number of trucks this building can have.
	 */
	public int getTruckSlots() {
		return truckSlots;
	}

	/**
	 * Sets the maximum number of trucks this building can have.
	 * 
	 * @param truckSlots
	 */
	public void setTruckSlots(int truckSlots) {
		this.truckSlots = truckSlots;
	}

	/**
	 * Gets the number of trucks that are active in the building.
	 * 
	 * @return
	 */
	public int getTrucksActive() {
		return trucksActive;
	}

	/**
	 * Sets the number of trucks that are active in the building.
	 * 
	 * @param trucksActive
	 */
	public void setTrucksActive(int trucksActive) {
		this.trucksActive = trucksActive;
	}

	/**
	 * Gets the price per hour per truck.
	 * 
	 * @return
	 */
	public int getTruckPrice() {
		return truckPrice;
	}

	/**
	 * Sets the price per hour per truck.
	 * 
	 * @param truckPrice
	 */
	public void setTruckPrice(int truckPrice) {
		this.truckPrice = truckPrice;
	}

	/**
	 * Gets the buildingsID. If an addon have the same ID as a building, it can
	 * be attatched to it.
	 * 
	 * @return
	 */
	public int getBuildingID() {
		return buildingID;
	}

	/**
	 * Sets the buildingsID. If an addon have the same ID as a building, it can
	 * be attatched to it.
	 * 
	 * @param buildingID
	 */
	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}

	/**
	 * Gets the buildings name.
	 * 
	 * @return
	 */
	public String getBuildingName() {
		return buildingName;
	}

	/**
	 * Sets the buildings name.
	 * 
	 * @param buildingName
	 */
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
}
