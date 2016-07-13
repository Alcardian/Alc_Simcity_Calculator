package org.alcardian.simcity.resources;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Power {

	public static ArrayList<String> getPowerList(int windLevel, int oilPrice,
			int oilUnitsPerPrice, int coalPrice, int coalUnitsPerPrice) {
		ArrayList<String> powerList = new ArrayList<String>();

		for (int a = 1; a < 4; a++) {
			powerList.add("Wind Tier" + a + ": "
					+ getWindPower(windLevel, a).toString());
		}

		return powerList;
	}

	/**
	 * Will return the price per MW from wind power at specified wind level.
	 * 
	 * @param windLevel
	 * @param tier
	 * @return
	 */
	public static BigDecimal getWindPower(int windLevel, int tier) {
		tier--;

		BigDecimal[] wind_Power = new BigDecimal[3];
		wind_Power[0] = new BigDecimal("3");
		wind_Power[1] = new BigDecimal("5.1");
		wind_Power[2] = new BigDecimal("15");
		BigDecimal[] wind_Cost = new BigDecimal[3];
		wind_Cost[0] = new BigDecimal("40");
		wind_Cost[1] = new BigDecimal("60");
		wind_Cost[2] = new BigDecimal("170");

		BigDecimal wind_Standard_Level = new BigDecimal("10");
		BigDecimal power = new BigDecimal("0");
		BigDecimal pricePerMW = new BigDecimal("0");

		if (tier >= 0 && tier < wind_Power.length + 1) {
			pricePerMW = pricePerMW.add(wind_Cost[tier]);
			power = power.add(wind_Power[tier]);
			power = power.divide(wind_Standard_Level);
			power = power.multiply(new BigDecimal(windLevel));
			pricePerMW = pricePerMW.divide(power, 2, BigDecimal.ROUND_CEILING); // Divide price with power. Allow 2 decimals. Round up stuff that is lower.
		} else {
			System.out.println("[POWER:Wind]ERROR: TIER NOT WITHIN RANGE");
			System.out.println("Tier range is: 1-" + (wind_Power.length+1) + ". Input was: " + tier + ".");
		}
		return pricePerMW;
	}

	public static BigDecimal getSolarPower(int tier) {
		tier--;

		BigDecimal[] solar_Power = new BigDecimal[2];
		solar_Power[0] = new BigDecimal("12.1");
		solar_Power[1] = new BigDecimal("30");	//Should be 37.5 but game went potato.
		BigDecimal[] solar_Cost = new BigDecimal[2];
		solar_Cost[0] = new BigDecimal("105");
		solar_Cost[1] = new BigDecimal("370");

		BigDecimal power = new BigDecimal("0");
		BigDecimal pricePerMW = new BigDecimal("0");

		if (tier >= 0 && tier < solar_Power.length + 1) {
			pricePerMW = pricePerMW.add(solar_Cost[tier]);
			power = power.add(solar_Power[tier]);
			pricePerMW = pricePerMW.divide(power, 2, BigDecimal.ROUND_CEILING); // Divide price with power. Allow 2 decimals. Round up stuff that is lower.

		} else {
			System.out.println("[POWER:Solar]ERROR: TIER NOT WITHIN RANGE");
			System.out.println("Tier range is: 1-" + (solar_Power.length+1) + ". Input was: " + (tier+1) + ".");
		}

		return pricePerMW;
	}

	public static BigDecimal getCoalPower(int tier, int coalPrice, int unitsForPrice) {
		tier--;

		BigDecimal[] coal_Power = new BigDecimal[3];
		coal_Power[0] = new BigDecimal("75");
		coal_Power[1] = new BigDecimal("75");
		coal_Power[2] = new BigDecimal("75");
		BigDecimal[] coal_Cost = new BigDecimal[3];
		coal_Cost[0] = new BigDecimal("425");
		coal_Cost[1] = new BigDecimal("375");
		coal_Cost[2] = new BigDecimal("600");
		BigDecimal[] coal_Consumption = new BigDecimal[3];
		coal_Consumption[0] = new BigDecimal("4.3");
		coal_Consumption[1] = new BigDecimal("8.6");
		coal_Consumption[2] = new BigDecimal("5.8");
		
		BigDecimal consumptionPrice = new BigDecimal("0");	// Commodity consumption price per day.
		BigDecimal power = new BigDecimal("0");
		BigDecimal pricePerMW = new BigDecimal("0");
		
		if (tier >= 0 && tier < coal_Power.length + 1) {
			pricePerMW = pricePerMW.add(coal_Cost[tier]);
			consumptionPrice = consumptionPrice.add(new BigDecimal(coalPrice).divide(new BigDecimal(unitsForPrice), 10, BigDecimal.ROUND_CEILING));
			consumptionPrice = consumptionPrice.multiply(coal_Consumption[tier]);
			consumptionPrice = consumptionPrice.divide(new BigDecimal("24"), 10, BigDecimal.ROUND_CEILING);
			pricePerMW = pricePerMW.add(consumptionPrice);
			power = power.add(coal_Power[tier]);
			pricePerMW = pricePerMW.divide(power, 2, BigDecimal.ROUND_CEILING); // Divide price with power. Allow 2 decimals. Round up stuff that is lower.
		} else {
			System.out.println("[POWER:Coal]ERROR: TIER NOT WITHIN RANGE");
			System.out.println("Tier range is: 1-" + (coal_Power.length+1) + ". Input was: " + tier + ".");
		}
		return pricePerMW;
	}

	public static BigDecimal getOilPower(int tier, int oilPrice, int unitsForPrice) {
		tier--;

		BigDecimal[] oil_Power = new BigDecimal[3];
		oil_Power[0] = new BigDecimal("150");
		oil_Power[1] = new BigDecimal("150");
		oil_Power[2] = new BigDecimal("150");
		BigDecimal[] oil_Cost = new BigDecimal[3];
		oil_Cost[0] = new BigDecimal("756");
		oil_Cost[1] = new BigDecimal("1185");
		oil_Cost[2] = new BigDecimal("1295");
		BigDecimal[] oil_Consumption = new BigDecimal[3];
		oil_Consumption[0] = new BigDecimal("8640");	//says: 36000 in tool-tip..
		oil_Consumption[1] = new BigDecimal("2880");	//says: 12000 in tool-tip..
		oil_Consumption[2] = new BigDecimal("5760");	//says: 24000 in tool-tip..
		
		BigDecimal consumptionPrice = new BigDecimal("0");	// Commodity consumption price per day.
		BigDecimal power = new BigDecimal("0");
		BigDecimal pricePerMW = new BigDecimal("0");
		
		if (tier >= 0 && tier < oil_Power.length + 1) {
			pricePerMW = pricePerMW.add(oil_Cost[tier]);
			consumptionPrice = consumptionPrice.add(new BigDecimal(oilPrice).divide(new BigDecimal(unitsForPrice), 10, BigDecimal.ROUND_CEILING));
			consumptionPrice = consumptionPrice.multiply(oil_Consumption[tier]);
			consumptionPrice = consumptionPrice.divide(new BigDecimal("24"), 10, BigDecimal.ROUND_CEILING);
			pricePerMW = pricePerMW.add(consumptionPrice);
			power = power.add(oil_Power[tier]);
			pricePerMW = pricePerMW.divide(power, 2, BigDecimal.ROUND_CEILING); // Divide price with power. Allow 2 decimals. Round up stuff that is lower.
		} else {
			System.out.println("[POWER:Oil]ERROR: TIER NOT WITHIN RANGE");
			System.out.println("Tier range is: 1-" + (oil_Power.length+1) + ". Input was: " + tier + ".");
		}
		return pricePerMW;
	}

	public static BigDecimal getNuclearPower(int tier) {
		tier--;

		BigDecimal[] n_Power = new BigDecimal[3];
		n_Power[0] = new BigDecimal("200");
		n_Power[1] = new BigDecimal("400");
		n_Power[2] = new BigDecimal("600");
		BigDecimal[] n_Cost = new BigDecimal[3];
		n_Cost[0] = new BigDecimal("1200");
		n_Cost[1] = new BigDecimal("2300");
		n_Cost[2] = new BigDecimal("3200");

		BigDecimal power = new BigDecimal("0");
		BigDecimal pricePerMW = new BigDecimal("0");

		if (tier >= 0 && tier < n_Power.length + 1) {
			pricePerMW = pricePerMW.add(n_Cost[tier]);
			power = power.add(n_Power[tier]);
			pricePerMW = pricePerMW.divide(power, 2, BigDecimal.ROUND_CEILING);

		} else {
			System.out.println("[POWER:Nuclear]ERROR: TIER NOT WITHIN RANGE");
			System.out.println("Tier range is: 1-" + (n_Power.length+1) + ". Input was: " + tier + ".");
		}
		return pricePerMW;
	}

	public static void printAllWindPowers() {
		for (int a = 1; a < 21; a++) {
			System.out.println("Wind Tier 3, wind level: " + a
					+ ", price per MW: " + getWindPower(a, 3).toString());
		}
	}
}
