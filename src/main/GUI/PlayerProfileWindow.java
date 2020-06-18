package main.GUI;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.AchiveObject;
import main.App;
import main.Farm;
import main.Farmer;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;


public class PlayerProfileWindow {

	private JFrame mainFrame;
	private App app;
	private Farmer farmer;
	private Farm farm;
	
	private JTextField ageTextField;
	private JTextField nameTextField;
	private JTextField farmNameTextField;
	private JTextField farmTypeTextField;
	private JTextField totalMoneyTextField;

	private JLabel ageLabel;
	private JLabel totalMoneyLabel;
	private JLabel farmerNameLabel;
	private JLabel farmName;
	private JLabel farmTypeLabel;
	private JLabel farmPictureLabel;
	private JLabel farmerPicture;
	private JLabel dateOfGameStartedLabel;
	private JLabel backgroundLabel;
	
	private JButton actionMenuButton;
	private JButton achiveButton;
	private JButton soundButton;
	private JButton actionsMenuButton;
	
	
	
	public PlayerProfileWindow(App inputApp) {
		
		
		
		app = inputApp;
		mainFrame = app.getFrame();
		mainFrame.repaint();
		initialize();
		
		mainFrame.setVisible(true);
	}




	private void initialize() {
		farmer = app.getFarmer();
		farm = farmer.getFarm();
		

		
		
////		============App mode================
		mainFrame = new JFrame();
		mainFrame.setSize(new Dimension(865, 640));
		mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(FirstPlayerSettingWindow.class.getResource("/main/IMG/startWindowBackground.png")));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.repaint();
////		============App mode================
		
		
		
		actionsMenuButton = new JButton("Actions Menu");
		actionsMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.playerProfileWindowToActionsWindow();
			}
		});
		
		totalMoneyTextField = new JTextField();
		totalMoneyTextField.setText("$" + Integer.toString(farmer.getCurrentMoney()));
		totalMoneyTextField.setFont(new Font("Dialog", Font.BOLD, 18));
		totalMoneyTextField.setEditable(false);
		totalMoneyTextField.setColumns(10);
		totalMoneyTextField.setBounds(168, 221, 163, 29);
		mainFrame.getContentPane().add(totalMoneyTextField);
		
		totalMoneyLabel = new JLabel("Total Money :");
		totalMoneyLabel.setForeground(Color.WHITE);
		totalMoneyLabel.setFont(new Font("LM Roman Slanted 8", Font.BOLD, 21));
		totalMoneyLabel.setBounds(12, 219, 153, 31);
		mainFrame.getContentPane().add(totalMoneyLabel);
		actionsMenuButton.setBounds(691, 544, 153, 48);
		mainFrame.getContentPane().add(actionsMenuButton);
		
		farmerNameLabel = new JLabel("Name :");
		farmerNameLabel.setFont(new Font("LM Roman Slanted 8", Font.BOLD, 21));
		farmerNameLabel.setBounds(12, 29, 83, 19);
		mainFrame.getContentPane().add(farmerNameLabel);
		
		ageLabel = new JLabel("Age :");
		ageLabel.setFont(new Font("LM Roman Slanted 8", Font.BOLD, 21));
		ageLabel.setBounds(12, 67, 83, 31);
		mainFrame.getContentPane().add(ageLabel);
		
		ageTextField = new JTextField();
		ageTextField.setEditable(false);
		ageTextField.setFont(new Font("Dialog", Font.BOLD, 18));
		ageTextField.setColumns(10);
		ageTextField.setBounds(102, 69, 71, 27);
		ageTextField.setText(Integer.toString(farmer.getAge()));
		mainFrame.getContentPane().add(ageTextField);
		
		nameTextField = new JTextField();
		nameTextField.setEditable(false);
		nameTextField.setFont(new Font("Dialog", Font.BOLD, 18));
		nameTextField.setColumns(10);
		nameTextField.setBounds(92, 27, 184, 25);
		nameTextField.setText(app.getFarmerName());
		mainFrame.getContentPane().add(nameTextField);
		
		farmName = new JLabel("Farm Name :");
		farmName.setFont(new Font("LM Roman Slanted 8", Font.BOLD, 21));
		farmName.setBounds(12, 120, 153, 31);
		mainFrame.getContentPane().add(farmName);
		
		farmNameTextField = new JTextField();
		farmNameTextField.setEditable(false);
		farmNameTextField.setFont(new Font("Dialog", Font.BOLD, 18));
		farmNameTextField.setColumns(10);
		farmNameTextField.setText(farm.getFarmName());
		farmNameTextField.setBounds(157, 120, 203, 29);
		mainFrame.getContentPane().add(farmNameTextField);
		
		farmTypeLabel = new JLabel("Farm Type :");
		farmTypeLabel.setForeground(Color.WHITE);
		farmTypeLabel.setFont(new Font("LM Roman Slanted 8", Font.BOLD, 21));
		farmTypeLabel.setBounds(12, 163, 153, 31);
		mainFrame.getContentPane().add(farmTypeLabel);
		
		farmTypeTextField = new JTextField();
		farmTypeTextField.setEditable(false);
		farmTypeTextField.setFont(new Font("Dialog", Font.BOLD, 18));
		farmTypeTextField.setColumns(10);
		farmTypeTextField.setBounds(157, 167, 163, 25);
		switch (farm.getfarmType()) {
		case "CropsFarm":
			farmTypeTextField.setText("Crops Farm");
			break;
		case "AnimalFarm":
			farmTypeTextField.setText("Animal Farm");
			break;
		case "StandardFarm":
			farmTypeTextField.setText("Standard Farm");
			break;
		case "FishFarm":
			farmTypeTextField.setText("Fish Farm");
			break;
		};
		mainFrame.getContentPane().add(farmTypeTextField);
		
		
		farmPictureLabel = new JLabel("");
		farmPictureLabel.setBounds(22, 289, 285, 200);
		switch (farm.getfarmType()) {
		case "CropsFarm":
			farmPictureLabel.setIcon(new ImageIcon(new ImageIcon(PlayerProfileWindow.class.getResource("/main/IMG/vintageCropsFarm.jpg")).getImage().getScaledInstance(285, 200, 0)));
			break;
		case "AnimalFarm":
			farmPictureLabel.setIcon(new ImageIcon(new ImageIcon(PlayerProfileWindow.class.getResource("/main/IMG/vintageAnimalFarm.jpg")).getImage().getScaledInstance(285, 200, 0)));
			break;
		case "StandardFarm":
			farmPictureLabel.setIcon(new ImageIcon(new ImageIcon(PlayerProfileWindow.class.getResource("/main/IMG/vintageStandardFarm.jpg")).getImage().getScaledInstance(285, 200, 0)));
			break;
		case "FishFarm":
			farmPictureLabel.setIcon(new ImageIcon(new ImageIcon(PlayerProfileWindow.class.getResource("/main/IMG/vintageFishFarm.jpg")).getImage().getScaledInstance(285, 200, 0)));
			break;
		}
		mainFrame.getContentPane().add(farmPictureLabel);
		
		
		
		DateFormat startDateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
		dateOfGameStartedLabel = new JLabel("Date of Game Started: "+startDateFormat.format(farmer.getStartDate()));
		dateOfGameStartedLabel.setForeground(Color.BLACK);
		dateOfGameStartedLabel.setFont(new Font("Garuda", Font.BOLD, 18));
		dateOfGameStartedLabel.setBounds(12, 564, 422, 39);
		mainFrame.getContentPane().add(dateOfGameStartedLabel);
		
		
		farmerPicture = new JLabel("");
		farmerPicture.setIcon(new ImageIcon(new ImageIcon(PlayerProfileWindow.class.getResource("/main/IMG/vintageFarmer.jpg")).getImage().getScaledInstance(222, 276, 0)));
		farmerPicture.setBounds(568, 107, 222, 276);
		mainFrame.getContentPane().add(farmerPicture);
		
		
		actionMenuButton = new JButton("Action Menu");
		actionMenuButton.setFont(new Font("Dialog", Font.BOLD, 22));
		actionMenuButton.setBounds(621, 556, 216, 41);
		actionMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.generalStoreToActionsWindow();
			}
		});
		
		achiveButton = new JButton("Achive");
		achiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.playerProfileWindowToAchiveWindow();
				
				
			}
		});
		achiveButton.setBounds(612, 430, 140, 57);
		mainFrame.getContentPane().add(achiveButton);

		
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
		
		
		
		backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(new ImageIcon(PlayerProfileWindow.class.getResource("/main/IMG/vintage.jpg")).getImage().getScaledInstance(865, 603, 0)));
		backgroundLabel.setBounds(0, 0, 865, 603);
		mainFrame.getContentPane().add(backgroundLabel);
		
		
		
	}
	
	
	public void closeWindow() {
		mainFrame.getContentPane().removeAll();
	}
}
