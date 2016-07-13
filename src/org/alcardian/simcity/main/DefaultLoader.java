package org.alcardian.simcity.main;

import java.util.ArrayList;

public class DefaultLoader {

	public static ArrayList<String> getCommodities() {
		ArrayList<String> buffer = new ArrayList<String>();

		buffer.add("commodity#Coal#6000#10");
		buffer.add("commodity#Crude Oil#9000#1000");
		buffer.add("commodity#Raw Ore#7500#10");
		buffer.add("commodity#Metal#31500#10");
		buffer.add("commodity#Alloy#42000#10");

		buffer.add("commodity#Plastic#21000#1000");
		buffer.add("commodity#Fuel#36750#1000");
		buffer.add("commodity#Processor#100500#1000");
		buffer.add("commodity#Computer#184375#1000");
		buffer.add("commodity#TV#158125#1000");
		return buffer;
	}
}
