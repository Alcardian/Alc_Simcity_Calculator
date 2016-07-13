package org.alcardian.simcity.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.alcardian.simcity.main.Main;
import org.alcardian.simcity.resources.Power;

@SuppressWarnings("serial")
public class PowerPanel extends JPanel{
	private PowerListener powerL = new PowerListener();
	private JScrollPane scroll;
	private JPanel settingPanel;
	private JTable table;
	private JCheckBox tier1Box = new JCheckBox("Tier1");
	private JCheckBox tier2Box = new JCheckBox("Tier2");
	private JCheckBox tier3Box = new JCheckBox("Tier3");
	private JLabel windLabel = new JLabel("Wind Level");
	private JComboBox<String> windBox = new JComboBox<String>(new String[]{"1", "2", "3", "4", "5", "6",
																			"7", "8", "9", "10", "11", "12",
																			"13", "14", "15", "16", "17",
																			"18", "19", "20"});
	private String[] columns = {"Power Type","Tier","Price per MW"};
	private String[][] testData = {{"Wind", "Tier 1", "15"},{"Wind", "Tier 2", "12"}};
	
	public PowerPanel(){
		setLayout(new GridBagLayout()); // Layout manager.
		GridBagConstraints c = new GridBagConstraints();
		
		settingPanel = new JPanel();
		settingPanel.setLayout(new GridBagLayout());
		
		table = new JTable(testData, columns);
		table.setPreferredScrollableViewportSize(new Dimension(250, 150));
		table.setFillsViewportHeight(true);
		
		tier1Box.setSelected(true);
		tier2Box.setSelected(true);
		tier3Box.setSelected(true);
		windBox.setSelectedIndex(9);
		
		c.gridx = 0;
		c.gridy = 0;
		settingPanel.add(tier1Box, c);
		c.gridx = 0;
		c.gridy = 1;
		settingPanel.add(tier2Box, c);
		c.gridx = 0;
		c.gridy = 2;
		settingPanel.add(tier3Box, c);
		c.gridx = 1;
		c.gridy = 3;
		settingPanel.add(windLabel, c);
		c.gridx = 0;
		c.gridy = 3;
		settingPanel.add(windBox, c);
		
		c.gridx = 0;
		c.gridy = 0;
		scroll = new JScrollPane(table);
		add(scroll, c);
		c.gridx = 0;
		c.gridy = 1;
		add(settingPanel,c);
		
		updateTable(getPowerSettings());
		
		tier1Box.addActionListener(powerL);
		tier2Box.addActionListener(powerL);
		tier3Box.addActionListener(powerL);
		windBox.addActionListener(powerL);
		
		validate();
	}
	
	public void updateTable(PowerSettings ps){
		int coalPrice = 0;
		int coalUnits = 0;
		int oilPrice = 0;
		int oilUnits = 0;
		boolean foundCoal = false;
		boolean foundOil = false;
		boolean foundDuplicas = false;
		
		for(int a=0;a<Main.commodity.size();a++){
			if(Main.commodity.get(a).getName().equals("Coal")){	//if Coal are the commodity.
				if(!foundCoal){
					coalPrice = Main.commodity.get(a).getPrice();
					coalUnits = Main.commodity.get(a).getUnits();
					foundCoal = true;
				}
				//else means more than one Coal commodity in list
				else{
					foundDuplicas = true;
				}
			}else if(Main.commodity.get(a).getName().equals("Crude Oil")){	//if Crude Oil are the commodity.
				if(!foundOil){
					oilPrice = Main.commodity.get(a).getPrice();
					oilUnits = Main.commodity.get(a).getUnits();
					foundOil = true;
				}
				//else means more than one Crude Oil commodity in list
				else{
					foundDuplicas = true;
				}
			}
		}
		
		//TODO ADD MESSAGE AND EXIT FOR IF DUPLICAS
		if(foundDuplicas){
			System.out.println("ERROR DUPLICATE COMMODITIES!");
			System.exit(1);
		}
		
		//Variables
		ArrayList<String[]> dataStrings = new ArrayList<String[]>();
		String[][] newData = null;
		//dataStrings.add(new String[]{});
		//Create tier list
		if(ps.isTier1()){
			//add tier1
			dataStrings.add(new String[]{"Coal", "Tier 1", Power.getCoalPower(1, coalPrice, coalUnits).toString()});
			dataStrings.add(new String[]{"Nuclear", "Tier 1",Power.getNuclearPower(1).toString()});
			dataStrings.add(new String[]{"Oil", "Tier 1", Power.getOilPower(1, oilPrice, oilUnits).toString()});
			dataStrings.add(new String[]{"Solar", "Tier 1", Power.getSolarPower(1).toString()});
			dataStrings.add(new String[]{"Wind", "Tier 1", Power.getWindPower(ps.getWindLevel()+1, 1).toString()});
		}
		if(ps.isTier2()){
			//add tier2
			dataStrings.add(new String[]{"Coal", "Tier 2", Power.getCoalPower(2, coalPrice, coalUnits).toString()});
			dataStrings.add(new String[]{"Nuclear", "Tier 2",Power.getNuclearPower(2).toString()});
			dataStrings.add(new String[]{"Oil", "Tier 2", Power.getOilPower(2, oilPrice, oilUnits).toString()});
			dataStrings.add(new String[]{"Solar", "Tier 2", Power.getSolarPower(2).toString()});
			dataStrings.add(new String[]{"Wind", "Tier 2", Power.getWindPower(ps.getWindLevel()+1, 2).toString()});
		}
		if(ps.isTier3()){
			//add tier3
			dataStrings.add(new String[]{"Coal", "Tier 3", Power.getCoalPower(3, coalPrice, coalUnits).toString()});
			dataStrings.add(new String[]{"Nuclear", "Tier 3",Power.getNuclearPower(3).toString()});
			dataStrings.add(new String[]{"Oil", "Tier 3", Power.getOilPower(3, oilPrice, oilUnits).toString()});
			dataStrings.add(new String[]{"Wind", "Tier 3", Power.getWindPower(ps.getWindLevel()+1, 3).toString()});
		}
		
		//ADD ALL STRING[] FROM ARRAYLIST<STRING[]> TO STRING[][] newData
		newData = new String[dataStrings.size()][3];
		for(int a=0;a<dataStrings.size();a++){
			newData[a] = dataStrings.get(a);
		}
		
		//Sort before sending on ahead
		Arrays.sort(newData, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[0];
                final String time2 = entry2[0];
                return time1.compareTo(time2);
            }
        });
		
		remove(scroll);
		table = new JTable(newData, columns);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		scroll = new JScrollPane(table);
		scroll.setMaximumSize(new Dimension(260,200));
		scroll.setMinimumSize(scroll.getMaximumSize());
		scroll.setPreferredSize(scroll.getMaximumSize());
		add(scroll, c);
		validate();
	}
	
	public PowerSettings getPowerSettings(){
		int wind = windBox.getSelectedIndex()+1;
		return new PowerSettings(wind, tier1Box.isSelected(), tier2Box.isSelected(), tier3Box.isSelected());
	}
	
	private class PowerSettings{
		private int windLevel;
		private boolean tier1 = false;
		private boolean tier2 = false;
		private boolean tier3 = false;
		
		public PowerSettings(int windLevel, boolean tier1, boolean tier2, boolean tier3){
			this.setWindLevel(windLevel);
			this.setTier1(tier1);
			this.setTier2(tier2);
			this.setTier3(tier3);
		}

		public int getWindLevel() {
			return windLevel;
		}

		public void setWindLevel(int windLevel) {
			this.windLevel = windLevel;
		}

		public boolean isTier1() {
			return tier1;
		}

		public void setTier1(boolean tier1) {
			this.tier1 = tier1;
		}

		public boolean isTier2() {
			return tier2;
		}

		public void setTier2(boolean tier2) {
			this.tier2 = tier2;
		}

		public boolean isTier3() {
			return tier3;
		}

		public void setTier3(boolean tier3) {
			this.tier3 = tier3;
		}
	}
	
	private class PowerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			updateTable(getPowerSettings());
			
		}
	}
}
