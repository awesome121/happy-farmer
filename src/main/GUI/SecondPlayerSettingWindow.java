package main.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

import farms.AnimalFarm;
import farms.CropsFarm;
import farms.FishFarm;
import farms.StandardFarm;
import main.App;
import main.Farm;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
/*
 * ***********Second Player Settings***********
 *  FirstPlayerPlayerSettingWindow.java --> *SecondPlayerPlayerSettingWindow.java* -->  ActionsWindow.java
 *  Hello the farmer name you input will be the first thing you see.
 *  then input your farm name there and also choose the type of farm you want that have different variety bonuses and specialties
 *  By clicking let's play will confirm your farm name and your farm type change to ActionWindow.java
 *  SecondPlayerSettingWindow.java --> ActionWindow.java
 */ 
public class SecondPlayerSettingWindow {

	private App app;
	private JFrame mainFrame;
	
	private JLabel playerSettingLabel;
	private JButton standardFarmButton;
	private JButton cropsFarmButton;
	private JButton animalFarmButton;
	private JButton fishFarmButton;
	private JButton playButton;
	private JTextArea standardFarmTextfield;
	private JTextArea cropsFarmTextfield;
	private JTextArea animalFarmTextfield;
	private JTextArea fishFarmTextfield;
	private String farmType;
	private Farm farm;
	private JLabel farmNameLabel;
	private JTextField farmNameTextfield;
	private JLabel farmNamePromptLabel;
	private JLabel backgroundLabel;
	private JButton soundButton;
	private JLabel chooseFarmTypeLabel;
	
	
	

	public SecondPlayerSettingWindow(App inputApp) {
		app = inputApp;
		mainFrame = app.getFrame();
		initialize();
		mainFrame.setVisible(true);
	}
	
	
	public void setTextFieldVisibility(String farmType) {
		standardFarmTextfield.setVisible(false);
		cropsFarmTextfield.setVisible(false);
		animalFarmTextfield.setVisible(false);
		fishFarmTextfield.setVisible(false);
		switch (farmType) {
		case "Standard":
			standardFarmTextfield.setVisible(true);
			break;
		case "Crops":
			cropsFarmTextfield.setVisible(true);
			break;
		case "Animal":
			animalFarmTextfield.setVisible(true);
			break;
		case "Fish":
			fishFarmTextfield.setVisible(true);
			break;
		}
	}
	
	
	
	public Farm createFarm(String farmName) {
		switch (farmType) {
		case "Standard":
			farm = new StandardFarm(farmName);
			break;
		case "Crops":
			farm = new CropsFarm(farmName);
			break;
		case "Animal":
			farm = new AnimalFarm(farmName);
			break;
		case "Fish":
			farm = new FishFarm(farmName);
			break;
		}
		return farm;
	}

	
	
	
	private void initialize() {
		
		
////	============app mode below============
		mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(FirstPlayerSettingWindow.class.getResource("/main/IMG/startWindowBackground.png")));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.repaint();
////	============app mode above============
		
		playerSettingLabel = new JLabel("Player Settings");
		playerSettingLabel.setForeground(Color.BLACK);
		playerSettingLabel.setFont(new Font("Impact", Font.PLAIN, 50));
		playerSettingLabel.setBounds(246, 34, 395, 53);
		mainFrame.getContentPane().add(playerSettingLabel);
		
		
		
		//=============Farm Button=============
		standardFarmButton = new JButton();
		standardFarmButton.setToolTipText("Click to choose standard farm");
		standardFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmType = "Standard";
				setTextFieldVisibility(farmType);
			}
		});
		standardFarmButton.setBounds(19, 249, 214, 161);
		ImageIcon img = new ImageIcon(new ImageIcon(FirstPlayerSettingWindow.class.getResource("/main/IMG/standardFarm.png")).getImage().getScaledInstance(standardFarmButton.getWidth(), standardFarmButton.getHeight(), 0));
		standardFarmButton.setIcon(img);
		mainFrame.getContentPane().add(standardFarmButton);
		
		
		
		
		cropsFarmButton = new JButton();
		cropsFarmButton.setToolTipText("Click to choose crops farm");
		cropsFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmType = "Crops";
				setTextFieldVisibility(farmType);
			}
		});
		
		cropsFarmButton.setBounds(237, 249, 206, 161);
		img = new ImageIcon(new ImageIcon(FirstPlayerSettingWindow.class.getResource("/main/IMG/cropsFarm.png")).getImage().getScaledInstance(cropsFarmButton.getWidth(), cropsFarmButton.getHeight(), 0));
		cropsFarmButton.setIcon(img);
		mainFrame.getContentPane().add(cropsFarmButton);
		
		
		
		animalFarmButton = new JButton();
		animalFarmButton.setToolTipText("Click to choose animal farm");
		animalFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmType = "Animal";
				setTextFieldVisibility(farmType);
			}
		});
		animalFarmButton.setBounds(446, 249, 206, 161);
		img = new ImageIcon(new ImageIcon(FirstPlayerSettingWindow.class.getResource("/main/IMG/animalFarm.png")).getImage().getScaledInstance(animalFarmButton.getWidth(), animalFarmButton.getHeight(), 0));
		animalFarmButton.setIcon(img);
		mainFrame.getContentPane().add(animalFarmButton);
		
		
		
		
		fishFarmButton = new JButton();
		fishFarmButton.setToolTipText("Click to choose fish farm");
		fishFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmType = "Fish";
				setTextFieldVisibility(farmType);
			}
		});
		fishFarmButton.setBounds(653, 249, 206, 161);
		img = new ImageIcon(new ImageIcon(FirstPlayerSettingWindow.class.getResource("/main/IMG/fishFarm.png")).getImage().getScaledInstance(fishFarmButton.getWidth(), fishFarmButton.getHeight(), 0));
		fishFarmButton.setIcon(img);
		mainFrame.getContentPane().add(fishFarmButton);
		
		
		//=========================================
		
		playButton = new JButton("Let's play");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		playButton.setBounds(691, 544, 110, 39);
		mainFrame.getContentPane().add(playButton);
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (farmNameTextfield.getText().equals("")){
					farmNamePromptLabel.setText("Please input your farm name");
				}
				
				else if (farmType == null) {
					farmNamePromptLabel.setText("Please choose a Farm type");
				}
				
				else if (farmType != null) {
					String farmName = farmNameTextfield.getText();
					farm = createFarm(farmName);
					app.secondPlayerSettingWindowToActionsWindow(farm);
				}
		
			}
		});
		
		
		
		standardFarmTextfield = new JTextArea();
		standardFarmTextfield.append("Standard Farm\n");
		standardFarmTextfield.append("Crops capacity: 20\n");
		standardFarmTextfield.append("Animals capacity: 3\n");
		standardFarmTextfield.append("Balanced capacity compared to \nother farms\n\nExtra bonus $50");
		standardFarmTextfield.setForeground(Color.white);
		standardFarmTextfield.setOpaque(false);
		standardFarmTextfield.setEditable(false);
		standardFarmTextfield.setBounds(29, 422, 204, 129);
		mainFrame.getContentPane().add(standardFarmTextfield);
		standardFarmTextfield.setVisible(false);
		
		
		cropsFarmTextfield = new JTextArea();
		cropsFarmTextfield.append("Crops Farm\n");
		cropsFarmTextfield.append("Crops capacity: 30\n");
		cropsFarmTextfield.append("Animals capacity: 2\nMore spaces for growing crops\n\n10 more spaces compared\nto standard farm\n\n");
		cropsFarmTextfield.append("20 more spaces compared\nto animal farm");
		cropsFarmTextfield.setForeground(Color.white);
		cropsFarmTextfield.setOpaque(false);
		cropsFarmTextfield.setEditable(false);
		cropsFarmTextfield.setBounds(237, 422, 206, 181);
		mainFrame.getContentPane().add(cropsFarmTextfield);
		cropsFarmTextfield.setVisible(false);
		
		
		animalFarmTextfield = new JTextArea();
		animalFarmTextfield.append("Animal Farm\n");
		animalFarmTextfield.append("Crops capacity: 10\n");
		animalFarmTextfield.append("Animals capacity: 7\n");
		animalFarmTextfield.append("Larger animal capacity\n\nNote: More capacity for animals\nNo farm is able to increase\nanimal capacity in game\n\n");
		animalFarmTextfield.append("Tend farm land will give you 3\nmore spaces for crops");
		animalFarmTextfield.setForeground(Color.white);
		animalFarmTextfield.setOpaque(false);
		animalFarmTextfield.setEditable(false);
		animalFarmTextfield.setBounds(446, 422, 214, 181);
		mainFrame.getContentPane().add(animalFarmTextfield);
		animalFarmTextfield.setVisible(false);
		
		
		fishFarmTextfield = new JTextArea();
		fishFarmTextfield.append("Fish Farm\n");
		fishFarmTextfield.append("Crops capacity: 10\n");
		fishFarmTextfield.append("Animals capacity: 2\n");
		fishFarmTextfield.append("The only farm where you can\ndo fishing\n\nNote: You can also grow crops\nand feed animals");
		fishFarmTextfield.setForeground(Color.white);
		fishFarmTextfield.setOpaque(false);
		fishFarmTextfield.setEditable(false);
		fishFarmTextfield.setBounds(663, 422, 196, 129);
		mainFrame.getContentPane().add(fishFarmTextfield);
		fishFarmTextfield.setVisible(false);
		
		
		farmNameLabel = new JLabel("What is your farm name?");
		farmNameLabel.setFont(new Font("Arial", Font.BOLD, 22));
		farmNameLabel.setBounds(19, 150, 343, 45);
		mainFrame.getContentPane().add(farmNameLabel);
		
		
		farmNameTextfield = new JTextField();
		farmNameTextfield.setOpaque(false);
		farmNameTextfield.setBounds(368, 151, 143, 49);
		mainFrame.getContentPane().add(farmNameTextfield);
		farmNameTextfield.setColumns(10);
		
		
		farmNamePromptLabel = new JLabel("");
		farmNamePromptLabel.setBounds(514, 150, 181, 49);
		mainFrame.getContentPane().add(farmNamePromptLabel);
		
		JLabel greetingLabel = new JLabel("Hello "+app.getFarmerName()+"!");
		greetingLabel.setFont(new Font("Arial", Font.BOLD, 22));
		greetingLabel.setMinimumSize(new Dimension(154, 16));
		greetingLabel.setMaximumSize(new Dimension(154, 16));
		greetingLabel.setPreferredSize(new Dimension(154, 16));
		greetingLabel.setBounds(19, 99, 232, 45);
		mainFrame.getContentPane().add(greetingLabel);
		
		
		soundButton = new JButton("sound");
		soundButton.setBounds(757, 0, 109, 67);
		soundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (app.getIsMuted()) {
					soundButton.setIcon(new ImageIcon(StartWindow.class.getResource("/main/IMG/unmute.png")));
					app.unmute();
				}
				else {
					soundButton.setIcon(new ImageIcon(StartWindow.class.getResource("/main/IMG/mute.png")));
					app.mute();
				}
			}
		});
		if(app.getIsMuted()) {
			soundButton.setIcon(new ImageIcon(StartWindow.class.getResource("/main/IMG/mute.png")));
		}
		else {
			soundButton.setIcon(new ImageIcon(StartWindow.class.getResource("/main/IMG/unmute.png")));
		}
		mainFrame.getContentPane().add(soundButton);
		
	
		chooseFarmTypeLabel = new JLabel("Please choose your farm type:");
		chooseFarmTypeLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		chooseFarmTypeLabel.setBounds(19, 208, 405, 45);
		mainFrame.getContentPane().add(chooseFarmTypeLabel);
		
		
		
		
		backgroundLabel = new JLabel();
		backgroundLabel.setFont(new Font("Arial", Font.BOLD, 22));
		backgroundLabel.setFocusTraversalPolicyProvider(true);
		backgroundLabel.setDisplayedMnemonic('8');
		backgroundLabel.setIcon(new ImageIcon(SecondPlayerSettingWindow.class.getResource("/main/IMG/SecondPlayerWindowBackground.jpg")));
		backgroundLabel.setIcon(new ImageIcon(new ImageIcon(FirstPlayerSettingWindow.class.getResource("/main/IMG/SecondPlayerWindowBackground.jpg")).getImage().getScaledInstance(865, 640, 0)));
		backgroundLabel.setBounds(0, 0, 865, 682);
		backgroundLabel.setLocation(0, 0);
		mainFrame.getContentPane().add(backgroundLabel);
		
		
	}
	
	public void closeWindow() {
		mainFrame.getContentPane().removeAll();
	}
}
