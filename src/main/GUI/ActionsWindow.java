package main.GUI;
/*
 * ***********ActionsWindow.java***********
 * ActionWindow.java is the center of the game that let us to choose what action we are going to do that have a maximum of 2 actions per day
 * On the top left of the screen will be displayed the total number of days left we have left to complete the game
 * On the top right of the screen will be display a mute button press the mute button will mute the song played in the background and changing it to unmute button
 * Pressing the unmute button will allow the music to play again
 * Next to the mute button will be a profile button is to open PlayerProfileWindow.java
 * 		ActionWindow.java --> PlayerProfileWindow.java
 * There is 2 invisible buttons in the middle the one on the left(by pressing the empty land) is to open TendCropsWindow.java
 * 		ActionWindow.java -->  TendCropsWindow.java
 * on the right (by pressing the barn) is to open BarnWindow.java
 * 		ActionWindow.java --> BarnWindow.java
 * On the bottom left will be the General Store button will open GeneralStoreWindow.java
 * 		ActionWindow.java --> GeneralStoreWindow.java
 * On the bottom right will be the Go to Sleep button will decrease 1 day and resets the actions into 2 again
 * There are a few windows the player is able to switch back on:
 * 
 * 
 * 
 * 													    PlayerProfileWindow.java  ---->  AchiveWindow.java
 * 													      /
 * 												         /	
 * 													    /
 * 				TendCropsWindow.java -----  ActionsWindow.java  ----- BarnWindow.java
 * 												/	
 * 											   /     
 * 											  /        
 * 						 GeneralStoreWindow.java     
 * 
 * 
 * 
 * 
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.SwingConstants;

import main.App;
import main.Farm;
import main.Farmer;
import main.RandomEvent;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class ActionsWindow {

	private App app;
	private Farmer farmer;
	private Farm farm;
	
	private JLabel backgroundLabel;
	private JLabel pressLandPromptLabel;
	private JLabel pressBarnPromptLabel;
	private JLabel titleLabel;
	private JLabel daysLabel;
	private JLabel goToSleepPromptLabel;
	private JLabel cropsCapacityInfoLabel;
	private JLabel animalsCapacityInfoLabel;
	private JLabel dailyBonusLabel;
	private JLabel randomEventMessageLabel;
	
	private JButton goToBarnButton;
	private JButton goToSleepButton;
	private JButton generalStoreButton;
	private JButton tendCropsButton;
	private JButton playerProfileWindow;
	
	private JFrame mainFrame;
	private JButton soundButton;
	
	
	
	

	public ActionsWindow(App inputApp) {
		app = inputApp;  
		mainFrame = app.getFrame(); 
		initialize();
		mainFrame.setVisible(true);
	};
	
	public ActionsWindow(App inputApp, int dailyBonus, String message) { // Refresh by going to sleep
		app = inputApp;   
		mainFrame = app.getFrame();  
		initialize();
		dailyBonusLabel.setText("Daily Bonus from yesterday $"+dailyBonus);
		if(message == null) {
			// No random event
		}
		else if(message.contains("barn")) {
			pressBarnPromptLabel.setText(message);
			pressBarnPromptLabel.setForeground(Color.RED);
		}
		else if( message.contains("land")){
			pressLandPromptLabel.setText(message);
			pressLandPromptLabel.setForeground(Color.RED);
		}
		
		else if(message.contains("fair")) {
			randomEventMessageLabel.setText(message);
			randomEventMessageLabel.setVisible(true);
		}
		
		dailyBonusLabel.setVisible(true);
		mainFrame.setVisible(true);
	};


	
	
	
	
	
	private void initialize() {
		farmer = app.getFarmer();
		farm = farmer.getFarm();
		

//		============App mode================
		mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(FirstPlayerSettingWindow.class.getResource("/main/IMG/startWindowBackground.png")));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.repaint();
//		============App mode================

		dailyBonusLabel = new JLabel();
		dailyBonusLabel.setForeground(Color.BLACK);
		dailyBonusLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		dailyBonusLabel.setBounds(12, 71, 439, 36);
		dailyBonusLabel.setVisible(false);
		mainFrame.getContentPane().add(dailyBonusLabel);
		
		
		randomEventMessageLabel = new JLabel();
		randomEventMessageLabel.setForeground(Color.BLACK);
		randomEventMessageLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		randomEventMessageLabel.setBounds(12, 120, 496, 36);
		randomEventMessageLabel.setVisible(false);
		mainFrame.getContentPane().add(randomEventMessageLabel);
		
		
		pressLandPromptLabel = new JLabel("Press the land to manage the land and the crops");
		pressLandPromptLabel.setForeground(Color.BLACK);
		pressLandPromptLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		pressLandPromptLabel.setBounds(12, 168, 468, 50);
		mainFrame.getContentPane().add(pressLandPromptLabel);

		
		
		daysLabel = new JLabel();
		daysLabel.setToolTipText("Learn more about time machine in general store");
		daysLabel.setText("Days left: "+(farmer.getDaysLeft()-1));
		daysLabel.setForeground(Color.BLACK);
		daysLabel.setFont(new Font("MS PGothic", Font.BOLD, 24));
		daysLabel.setBounds(43, 23, 204, 36);
		mainFrame.getContentPane().add(daysLabel);
		
		
		titleLabel = new JLabel("Actions Available : "+farmer.getActionsLeft());
		titleLabel.setToolTipText("Maximum 2 actions per day");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 22));
		titleLabel.setBounds(288, 20, 291, 39);
		mainFrame.getContentPane().add(titleLabel);
		
		
		pressBarnPromptLabel = new JLabel("Press the barn to view animal status");
		pressBarnPromptLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		pressBarnPromptLabel.setBounds(587, 132, 299, 50);
		mainFrame.getContentPane().add(pressBarnPromptLabel);
		
		
		goToSleepPromptLabel = new JLabel("Go to sleep refresh the action to 2");
		goToSleepPromptLabel.setForeground(Color.BLACK);
		goToSleepPromptLabel.setFont(new Font("Chilanka", Font.BOLD, 15));
		goToSleepPromptLabel.setBounds(597, 576, 256, 39);
		mainFrame.getContentPane().add(goToSleepPromptLabel);
		
		
		goToBarnButton = new JButton();
		goToBarnButton.setToolTipText("Press to view your barn");
		goToBarnButton.setContentAreaFilled(false);
		goToBarnButton.setOpaque(false);
		goToBarnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.actionsWindowToBarnWindow();
			}
		});
		goToBarnButton.setBorder(null);
		goToBarnButton.setBounds(498, 182, 361, 261);
		mainFrame.getContentPane().add(goToBarnButton);
		
		
		tendCropsButton = new JButton();
		tendCropsButton.setToolTipText("Press to view your farm land");
		tendCropsButton.setContentAreaFilled(false);
		tendCropsButton.setBorder(null);
		tendCropsButton.setOpaque(false);
		tendCropsButton.setBounds(12, 230, 375, 224);
		tendCropsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.actionsWindowToTendCropsWindow();
			}
		});
		mainFrame.getContentPane().add(tendCropsButton);
		
		
		cropsCapacityInfoLabel = new JLabel();
		cropsCapacityInfoLabel.setToolTipText("Tending your land gives 3 more spaces");
		if(farm.getMaxCrops()==farm.getCropsList().size()) {
			cropsCapacityInfoLabel.setText("Land Pressure: "+farm.getCropsList().size()+"/"+farm.getMaxCrops()+" (Full)");
			cropsCapacityInfoLabel.setForeground(Color.RED);
		}
		else
		{
			cropsCapacityInfoLabel.setText("Land Pressure: "+farm.getCropsList().size()+"/"+farm.getMaxCrops());
			cropsCapacityInfoLabel.setForeground(Color.BLACK);
		}
		cropsCapacityInfoLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		cropsCapacityInfoLabel.setBounds(88, 466, 257, 39);
		mainFrame.getContentPane().add(cropsCapacityInfoLabel);
		
		animalsCapacityInfoLabel = new JLabel();
		if(farm.getMaxAnimals()==farm.getAnimalsList().size()) {
			animalsCapacityInfoLabel.setText("Barn Pressure: "+farm.getAnimalsList().size()+"/"+farm.getMaxAnimals()+ " (Full)");
			animalsCapacityInfoLabel.setForeground(Color.RED);
		}
		else {
			animalsCapacityInfoLabel.setText("Barn Pressure: "+farm.getAnimalsList().size()+"/"+farm.getMaxAnimals());
			animalsCapacityInfoLabel.setForeground(Color.BLACK);
		}
		
		animalsCapacityInfoLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		animalsCapacityInfoLabel.setBounds(566, 466, 216, 39);
		mainFrame.getContentPane().add(animalsCapacityInfoLabel);
		
		
		
		goToSleepButton = new JButton("Go to Sleep");
		goToSleepButton.setBounds(668, 544, 133, 39);
		goToSleepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (farmer.getDaysLeft()!=1) {
					int dailyBunus = farmer.nextDay(app);
					String message = farmer.getRandomEventMessage();
					app.refreshActionsWindow(dailyBunus, message);
				}
				else
				{
					farmer.increaseCurrentMoney(farmer.getDailyBonus());
					app.actionsWindowToFinishWindow();
				}
			}
		});
		mainFrame.getContentPane().add(goToSleepButton);
		
		
		generalStoreButton = new JButton("General Store");
		generalStoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.actionsWindowToGeneralStoreWindow();
			}
		});
		generalStoreButton.setBounds(43, 544, 133, 39);
		mainFrame.getContentPane().add(generalStoreButton);
		
		
		playerProfileWindow = new JButton("Profile");
		playerProfileWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.actionsWindowToPlayerProfileWindow();
			}
		});
		playerProfileWindow.setBounds(597, 8, 117, 50);
		mainFrame.getContentPane().add(playerProfileWindow);
		
		
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
		backgroundLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		backgroundLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		backgroundLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		backgroundLabel.setIcon(new ImageIcon(ActionsWindow.class.getResource("/main/IMG/actionsWindowBackground.jpg")));
		backgroundLabel.setBounds(-64, 0, 1173, 619);
		backgroundLabel.setLocation(0, 0);
		mainFrame.getContentPane().add(backgroundLabel);
		

	}
	
	
	public void closeWindow() {
		mainFrame.getContentPane().removeAll();
	}
}
