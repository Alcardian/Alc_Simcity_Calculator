package org.alcardian.simcity.main;

import java.util.ArrayList;

import org.alcardian.simcity.gui.MainWindow;
import org.alcardian.simcity.resources.Commodity;

public class Main {
	public static ArrayList<Commodity> commodity = new ArrayList<Commodity>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MainWindow window = new MainWindow();
	}
	
	/**
	 * Will return the index of the commodity with the same name as commodityName.
	 * @param commodityName
	 * @return -1 = not found. Greater than -1 means found it at returned index.
	 */
	public static int findCommodity(String commodityName){
		int index = -1;
		
		for(int a=0;a<commodity.size();a++){
			if(commodity.get(a).getName().equals(commodityName)){	//if the name matches.
				index = a;
			}
		}
		return index;
	}
}
