package org.alcardian.simcity.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import org.alcardian.simcity.resources.Commodity;
import static org.alcardian.simcity.main.AlcardianToolBox.*;
import org.alcardian.simcity.main.DefaultLoader;
import org.alcardian.simcity.main.Main;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	private JPanel commodityPanel, productionPanel;
	private JButton updateButton = new JButton("Update");
	private ButtonListener buttonL = new ButtonListener();
	private ArrayList<CommodityPanel> cPanel = new ArrayList<CommodityPanel>();
	private WindPowerPanel windPowerPanel = new WindPowerPanel();
	private PowerPanel powerPanel;

	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Simcity 5 Calc");
		setSize(300, 400); // x, y
		setLocation(100, 100);
		setVisible(true);
		setResizable(false);

		createCPanels();
		
		commodityPanel = new JPanel();
		productionPanel = new JPanel();
		powerPanel = new PowerPanel();
		
		commodityPanel.setLayout(new GridBagLayout()); // Layout manager.
		GridBagConstraints c = new GridBagConstraints(); // Needed to place components within the panel properly.
		
		for (int a = 0; a < cPanel.size(); a++) {
			c.gridx = 0;
			c.gridy = a;
			commodityPanel.add(cPanel.get(a), c);
		}
		
		c.gridx = 0;
		c.gridy = cPanel.size();
		commodityPanel.add(updateButton, c);
		
		

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Commodity", new JScrollPane(commodityPanel));
		tabbedPane.addTab("Production", new JScrollPane(productionPanel));
		//tabbedPane.addTab("Power", new JScrollPane(powerPanel));
		tabbedPane.addTab("Power", powerPanel);
		tabbedPane.addTab("Wind", new JScrollPane(windPowerPanel));
		add(tabbedPane);

		updateButton.addActionListener(buttonL);
		validate();
	}

	public boolean isCommodity(String commodity) {
		String[] sParts = commodity.split("#", -1);
		if (sParts.length == 4) {
			if (sParts[0].equals("commodity")) {
				if (isNumber(sParts[2], false)) {
					if (isNumber(sParts[3], false)) {
						return true;
					} else {
						System.out.println("ERROR: Units is not a number!");
					}
				} else {
					System.out.println("ERROR: Price is not a number!");
				}
			} else {
				System.out.println("ERROR: Object is not a commodity!");
			}
		} else {
			System.out.println("ERROR: Commodity lenght to short!");
		}
		return false;
	}

	public Commodity stringToCommodity(String commodity_String) {
		String[] stringParts = commodity_String.split("#", -1);
		return new Commodity(Integer.parseInt(stringParts[2]),
				Integer.parseInt(stringParts[3]), stringParts[1]);
	}

	public void createCPanels() {
		ArrayList<String> buffer = DefaultLoader.getCommodities();

		for (int a = 0; a < buffer.size(); a++) {
			if (isCommodity(buffer.get(a))) {
				cPanel.add(new CommodityPanel(stringToCommodity(buffer.get(a))));
				Main.commodity.add(stringToCommodity(buffer.get(a)));
			} else {
				System.out.println("ERROR: The String is not a commodity!");
			}
		}
		/*for(int a=0;a<Main.commodity.size();a++){
			System.out.println(Main.commodity.get(a).getName());
		}*/
	}
	
	public class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int a=0;a<cPanel.size();a++){
				int index = Main.findCommodity(cPanel.get(a).getCommodityName());
				//TODO FINISH THIS
				//index -> commodity(index) price = cPanel.getPrice
				cPanel.get(a).updateCommodity();
				System.out.println("Setting " + Main.commodity.get(index).getName() + " price to " 
									+ cPanel.get(a).getCommodityPrice() + " from " + Main.commodity.get(index).getPrice());
				Main.commodity.get(index).setPrice(cPanel.get(a).getCommodityPrice());
				powerPanel.updateTable(powerPanel.getPowerSettings());
			}
		}
		
	}
}
