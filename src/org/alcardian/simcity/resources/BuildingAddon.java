package org.alcardian.simcity.resources;

/**
 * An Addon for a building.
 * 
 * @author Alcardian
 * 
 */
public class BuildingAddon {
	private int addonID;
	private int addonSlots;
	private int activeAddonSlots;
	private int addonPrice;
	private int buildingID;

	private String producesName;
	private int producesUnits;
	private String consumesName1;
	private int consumesUnits1;
	private String consumesName2;
	private int consumesUnits2;

	public BuildingAddon(int addonID, int addonSlots, int activeAddonSlots,
			int addonPrice, int buildingID, String producesName,
			int producesUnits, String consumesName1, int consumesUnits1,
			String consumesName2, int consumesUnits2) {
		// Contructor parameter line 1.
		this.addonID = addonID;
		this.addonSlots = addonSlots;
		this.activeAddonSlots = activeAddonSlots;
		this.addonPrice = addonPrice;
		this.buildingID = buildingID;
		// Contructor parameter line 2.
		this.producesName = producesName;
		this.producesUnits = producesUnits;
		this.consumesName1 = consumesName1;
		this.consumesUnits1 = consumesUnits1;
		// Contructor parameter line 3.
		this.consumesName2 = consumesName2;
		this.consumesUnits2 = consumesUnits2;
		// End of contructor parameter lines.
	}

	/**
	 * Gets Addon slots. This number indicates the maximum number of addons of
	 * this Addon-ID that a building can have.
	 * 
	 * @return
	 */
	public int getAddonSlots() {
		return addonSlots;
	}

	/**
	 * Sets Addon slots. This number indicates the maximum number of addons of
	 * this Addon-ID that a building can have.
	 * 
	 * @param addonSlots
	 */
	public void setAddonSlots(int addonSlots) {
		this.addonSlots = addonSlots;
	}

	/**
	 * Gets the number of active Addons of this kind.
	 * 
	 * @return
	 */
	public int getActiveAddonSlots() {
		return activeAddonSlots;
	}

	/**
	 * Sets the number of active Addons of this kind.
	 * 
	 * @param activeAddonSlots
	 */
	public void setActiveAddonSlots(int activeAddonSlots) {
		this.activeAddonSlots = activeAddonSlots;
	}

	/**
	 * Gets the Addon price, the price are for one addon. Take this number times
	 * ActiveAddonSlots to get the total cost for all addons in total.
	 * 
	 * @return
	 */
	public int getAddonPrice() {
		return addonPrice;
	}

	/**
	 * Sets the Addon price, the price are for one addon. Take this number times
	 * ActiveAddonSlots to get the total cost for all addons in total.
	 * 
	 * @param addonPrice
	 */
	public void setAddonPrice(int addonPrice) {
		this.addonPrice = addonPrice;
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
	 * Gets the name of the commodity this addon produces.
	 * 
	 * @return
	 */
	public String getProducesName() {
		return producesName;
	}

	/**
	 * Sets the name of the commodity this addon produces.
	 * 
	 * @param producesName
	 */
	public void setProducesName(String producesName) {
		this.producesName = producesName;
	}

	/**
	 * Gets the number of units this addon produces per day.
	 * 
	 * @return
	 */
	public int getProducesUnits() {
		return producesUnits;
	}

	/**
	 * Sets the number of units this addon produces per day.
	 * 
	 * @param producesUnits
	 */
	public void setProducesUnits(int producesUnits) {
		this.producesUnits = producesUnits;
	}

	public String getConsumesName1() {
		return consumesName1;
	}

	public void setConsumesName1(String consumesName1) {
		this.consumesName1 = consumesName1;
	}

	public int getConsumesUnits1() {
		return consumesUnits1;
	}

	public void setConsumesUnits1(int consumesUnits1) {
		this.consumesUnits1 = consumesUnits1;
	}

	public String getConsumesName2() {
		return consumesName2;
	}

	public void setConsumesName2(String consumesName2) {
		this.consumesName2 = consumesName2;
	}

	public int getConsumesUnits2() {
		return consumesUnits2;
	}

	public void setConsumesUnits2(int consumesUnits2) {
		this.consumesUnits2 = consumesUnits2;
	}

	/**
	 * AddonID is a unique ID for each addon.
	 * 
	 * @return
	 */
	public int getAddonID() {
		return addonID;
	}

	/**
	 * AddonID is a unique ID for each addon.
	 * 
	 * @param addonID
	 */
	public void setAddonID(int addonID) {
		this.addonID = addonID;
	}
}
