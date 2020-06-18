package main.GUI;

/*
 * ***********Final Window of the Game!***********
 * Ones days left is none ActionWindow triggers the FinishWindow.java
 * It will displayed your final score if your final score if 500 or above you will be awarded a trophy otherwise you will have to retry the game again to get the trophy
 * It will always display your farmer name, farm name total money left and the total duration of days your played
 * 
 * 
 * 
 */
import main.App;
import main.Farm;
import main.Farmer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class FinishWindow {

	private JFrame mainFrame;
	private App app;
	private Farmer farmer;
	private Farm farm;
	private JTextArea signiture;
	private JLabel finishTimeLabel;
	private JLabel thankYouLabel;
	private JLabel nameLabel;
	private JLabel startDateLabel;
	private JLabel farmNameLabel;
	private Container totalMoneyLabel;
	private JLabel gameEndingPicture;
	private JLabel finalScoreLabel;
	private JLabel durationLabel;
	
	

	public FinishWindow(App inputApp) {
		app = inputApp;
		mainFrame = app.getFrame();
		initialize();
		mainFrame.repaint();
		mainFrame.setVisible(true);
	}



	
	private void initialize() {
		farmer = app.getFarmer();
		farm = farmer.getFarm();
//============App mode================
		mainFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FirstPlayerSettingWindow.class.getResource("/main/IMG/startWindowBackground.png")));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.repaint();
//============App mode================
	
		
		
		totalMoneyLabel = new JLabel("Total Money: $"+farmer.getCurrentMoney());
		totalMoneyLabel.setFont(new Font("Dialog", Font.BOLD, 21));
		totalMoneyLabel.setBounds(30, 225, 413, 44);
		mainFrame.getContentPane().add(totalMoneyLabel);
		
		
		DateFormat startDateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
		startDateLabel = new JLabel("Date of Game Started: "+startDateFormat.format(farmer.getStartDate()));
		startDateLabel.setFont(new Font("Dialog", Font.BOLD, 21));
		startDateLabel.setBounds(30, 426, 538, 44);
		mainFrame.getContentPane().add(startDateLabel);
		
		nameLabel = new JLabel("Farmer Name : " + farmer.getName());
		nameLabel.setFont(new Font("Dialog", Font.BOLD, 21));
		nameLabel.setBounds(30, 113, 413, 44);
		mainFrame.getContentPane().add(nameLabel);
		
		thankYouLabel = new JLabel("Thank You");
		thankYouLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thankYouLabel.setFont(new Font("MS PGothic", Font.BOLD, 25));
		thankYouLabel.setBounds(312, 538, 233, 62);
		mainFrame.getContentPane().add(thankYouLabel);
		
		farmNameLabel = new JLabel("Farm name : " + farm.getFarmName());
		farmNameLabel.setFont(new Font("Dialog", Font.BOLD, 21));
		farmNameLabel.setBounds(30, 169, 413, 44);
		mainFrame.getContentPane().add(farmNameLabel);
		
		gameEndingPicture = new JLabel();
		gameEndingPicture.setBounds(455, 57, 380, 275);
		if (farmer.generateFinalScore() >= 500) {
			gameEndingPicture.setIcon(new ImageIcon(new ImageIcon(PlayerProfileWindow.class.getResource("/main/IMG/throphy.jpg")).getImage().getScaledInstance(gameEndingPicture.getWidth(), gameEndingPicture.getHeight(), 0)));

		}
		else {
			gameEndingPicture.setIcon(new ImageIcon(new ImageIcon(PlayerProfileWindow.class.getResource("/main/IMG/tryAgain.jpg")).getImage().getScaledInstance(gameEndingPicture.getWidth(), gameEndingPicture.getHeight(), 0)));
		}
		mainFrame.getContentPane().add(gameEndingPicture);
		
			
			
		
		Date finishDate = new Date();
		DateFormat finishdateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
		finishTimeLabel = new JLabel("Date of Game Ended: " + finishdateFormat.format(finishDate));
		finishTimeLabel.setFont(new Font("Dialog", Font.BOLD, 21));
		finishTimeLabel.setBounds(30, 482, 538, 44);
		mainFrame.getContentPane().add(finishTimeLabel);
		
		signiture = new JTextArea();
		signiture.setOpaque(false);
		signiture.setText("Developer Team:\nChangxing\nRayhan\n\nSENG201-Project\nUniversitry of Canterbury");
		signiture.setEditable(false);
		signiture.setBounds(665, 449, 170, 107);
		mainFrame.getContentPane().add(signiture);
		
		finalScoreLabel = new JLabel("Final score: "+ farmer.generateFinalScore());
		finalScoreLabel.setFont(new Font("Dialog", Font.BOLD, 21));
		finalScoreLabel.setBounds(30, 57, 413, 44);
		mainFrame.getContentPane().add(finalScoreLabel);
		
		durationLabel = new JLabel("Duration: "+app.getPlayingDuration()+" days");
		durationLabel.setFont(new Font("Dialog", Font.BOLD, 21));
		durationLabel.setBounds(30, 281, 251, 44);
		mainFrame.getContentPane().add(durationLabel);
	}
}
