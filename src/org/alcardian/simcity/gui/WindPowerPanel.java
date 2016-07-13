package org.alcardian.simcity.gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.alcardian.simcity.resources.Power;

@SuppressWarnings("serial")
public class WindPowerPanel extends JPanel{
	private JSlider slider;
	private JLabel sliderLabel,tierLabel ,tier1Label, tier2Label, tier3Label;
	private SliderListener sListener = new SliderListener();
	
	public WindPowerPanel(){
		setLayout(new GridBagLayout()); // Layout manager.
		GridBagConstraints c = new GridBagConstraints();
		
		sliderLabel = new JLabel("Wind Level: 10", JLabel.CENTER);
		tier1Label = new JLabel();
		tier2Label = new JLabel();
		tier3Label = new JLabel();
		tierLabel = new JLabel("Cost per MW");
		slider = new JSlider(JSlider.HORIZONTAL, 0, 20, 10);
		updateDisplay();
		
		tierLabel.setFont(new Font(tierLabel.getFont().getName(),Font.BOLD,tierLabel.getFont().getSize()));
		
		sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		slider.setMajorTickSpacing(5);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		
		
		c.gridx = 0;
		c.gridy = 0;
		add(sliderLabel, c);
		
		c.gridx = 0;
		c.gridy = 1;
		add(slider, c);
		
		
		
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(20, 0, 0, 0);
		add(tierLabel, c);
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(0, 0, 0, 0);
		add(tier1Label, c);
		c.gridx = 0;
		c.gridy = 4;
		add(tier2Label, c);
		c.gridx = 0;
		c.gridy = 5;
		add(tier3Label, c);
		
		slider.addChangeListener(sListener);
	}
	
	public int getWindLevel(){
		return slider.getValue();
	}
	
	public void updateDisplay(){
		sliderLabel.setText("Wind Level: " + slider.getValue());
			if(slider.getValue() != 0){
				tier1Label.setText("Tier 1: " + Power.getWindPower(slider.getValue(), 1));
				tier2Label.setText("Tier 2: " + Power.getWindPower(slider.getValue(), 2));
				tier3Label.setText("Tier 3: " + Power.getWindPower(slider.getValue(), 3));
			}else{
				tier1Label.setText("Tier 1: ");
				tier2Label.setText("Tier 2: ");
				tier3Label.setText("Tier 3: ");
			}
	}
	
	private class SliderListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			updateDisplay();
			
		}
	}
}
