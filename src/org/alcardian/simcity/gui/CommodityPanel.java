package org.alcardian.simcity.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.alcardian.simcity.main.AlcardianToolBox;
import org.alcardian.simcity.resources.Commodity;


@SuppressWarnings("serial")
public class CommodityPanel extends JPanel{
	private JLabel nameLabel = new JLabel();
	private String commodityName;
	private int commodityPrice;
	protected JTextField numberField = new JTextField();

	public CommodityPanel(Commodity commodity) {
		this.commodityName = commodity.getName();
		this.commodityPrice = commodity.getPrice();
		
		setLayout(new GridBagLayout()); // Layout manager.
		GridBagConstraints c = new GridBagConstraints(); // Needed to place components within the panel properly.
		// this.commodity.printAll();

		numberField.setText("" + commodity.getPrice());
		nameLabel.setText(commodity.getName());
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		// + this.commodity.getPrice()
		setSize(numberField, 50, 30);
		setSize(nameLabel, 80, 30);

		c.gridx = 0;
		c.gridy = 0;
		add(nameLabel, c);

		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		add(numberField, c);
		
		//numberField.addActionListener(commodityL);
		//numberField.getDocument().addDocumentListener(docL);
	}

	/**
	 * function to set size of components
	 * 
	 * @param component
	 * @param x
	 * @param y
	 */
	private void setSize(Component component, int x, int y) {
		component.setMaximumSize(new Dimension(x, y));
		component.setMinimumSize(new Dimension(x, y));
		component.setPreferredSize(new Dimension(x, y));
	}
	
	public void updateCommodity(){
		
		if(AlcardianToolBox.isNumber(numberField.getText(), false)){
			commodityPrice = Integer.parseInt(numberField.getText());
			//System.out.println("Setting " + getCommodityName() + " price to: " + numberField.getText());
		}else{
			JOptionPane.showMessageDialog(null, "ERROR! Non numeric character in textfield for commodity: " + getCommodityName() + "!");
			numberField.setText("" + commodityPrice);
		}
	}
	
	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public int getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(int commodityPrice) {
		this.commodityPrice = commodityPrice;
	}
}
