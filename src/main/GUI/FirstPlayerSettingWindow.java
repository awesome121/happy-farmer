package main.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;

import main.App;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
/*
 * ***********Player Settings Starts Here!***********
 *  StartWindow.java  -->  *FirstPlayerPlayerSettingWindow.java* --> SecondPlayerPlayerSettingWindow.java 
 *  
 *  First off choose how many days would you like to play by choosing the available 5 to 10 days which have different variety of starting money
 *  Then input your farmer name here that can only contain alphabets with the length of 3 to 15 words
 *  After that you can choose your farmer age by choosing from the range of 6 to 100
 *  Click the next page to go to the SecondPlayerSettingWindow.java
 *  
 *  FirstPlayerSettingWindow.java  -->  SecondPlayerSettingWindow.java
 */ 
public class FirstPlayerSettingWindow {

	private JFrame mainFrame;
	private JLabel nameLabel;
	private JTextField nameTextfield;
	private JLabel ageLabel;
	private JLabel daysLabel;
	private App app;
	@SuppressWarnings("rawtypes")
	private JComboBox ageComboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox daysComboBox;
	private JLabel playerSettingLabel;
	private JLabel backgroundLabel;
	private JLabel namePromptLabel;
	private JButton nextWindowButton;
	private JButton soundButton;
	private JLabel agePromptLabel;
	private JLabel goalPromptLabel;
	
	
    
    
    
	public FirstPlayerSettingWindow(App inputApp) {
		app = inputApp;
		mainFrame = app.getFrame();
		initialize();
		mainFrame.setVisible(true);
	}


	
	
	private void initialize() {

		
//	============app mode below============
		mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(FirstPlayerSettingWindow.class.getResource("/main/IMG/startWindowBackground.png")));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.repaint();
//	============app mode above============
		
		
		namePromptLabel = new JLabel("");
		namePromptLabel.setForeground(Color.RED);
		namePromptLabel.setBounds(447, 211, 359, 50);
		mainFrame.getContentPane().add(namePromptLabel);
		
				
		agePromptLabel = new JLabel("Starting money: $100");
		agePromptLabel.setForeground(Color.GRAY);
		agePromptLabel.setBounds(288, 143, 220, 50);
		mainFrame.getContentPane().add(agePromptLabel);
		
				
		nextWindowButton = new JButton("");
		nextWindowButton
				.setIcon(new ImageIcon(FirstPlayerSettingWindow.class.getResource("/main/IMG/nextWindowButton.png")));
		nextWindowButton.setBounds(591, 558, 253, 59);
		mainFrame.getContentPane().add(nextWindowButton);

		nextWindowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String farmerName = nameTextfield.getText();
				if (farmerName.length() >= 3 && farmerName.length() <= 15 && farmerName.matches("[a-zA-Z]+")) {
					int days = (int) daysComboBox.getSelectedItem();
					int age = (int) ageComboBox.getSelectedItem();
					app.firstPlayerSettingWindowToSecondPlayerSettingWindow(days, age, farmerName);
				} else {
					namePromptLabel.setText("Farmer name should be 3-15 pure alphabets!");
				}
			}
		});
		
		ageComboBox = new JComboBox();
		ageComboBox.setAutoscrolls(true);
		ageComboBox.setMaximumRowCount(10);
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=6; i<=100; i++) {
			nums.add(i);
		}
		ageComboBox.setModel(new DefaultComboBoxModel(nums.toArray()));
		ageComboBox.setBounds(199, 273, 74, 54);
		mainFrame.getContentPane().add(ageComboBox);
		
		
		
		
		
		daysComboBox = new JComboBox();
		daysComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int startingMoney = 100 - (((int) daysComboBox.getSelectedItem()) - 5)*10;
				agePromptLabel.setText("Starting money: $"+startingMoney);
			}
		});
		daysComboBox.setBackground(new Color(255, 255, 255));
		daysComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		daysComboBox.setModel(new DefaultComboBoxModel(new Integer[] {5, 6, 7, 8, 9, 10}));
		daysComboBox.setBounds(199, 140, 77, 53);
		mainFrame.getContentPane().add(daysComboBox);
		
		
		daysLabel = new JLabel();
		daysLabel.setText("Days to play:");
		daysLabel.setFont(new Font("Arial", Font.BOLD, 22));
		daysLabel.setBorder(null);
		daysLabel.setBackground(Color.WHITE);
		daysLabel.setBounds(23, 139, 183, 53);
		mainFrame.getContentPane().add(daysLabel);
		
		ageLabel = new JLabel();
		ageLabel.setText("Farmer age :");
		ageLabel.setFont(new Font("Arial", Font.BOLD, 22));
		ageLabel.setBorder(null);
		ageLabel.setBackground(Color.WHITE);
		ageLabel.setBounds(23, 271, 173, 53);
		mainFrame.getContentPane().add(ageLabel);
		
		nameTextfield = new JTextField();
		nameTextfield.setBackground(new Color(255, 255, 255));
		nameTextfield.setOpaque(false);
		nameTextfield.setBorder(null);
		nameTextfield.setDisabledTextColor(new Color(255, 255, 255));
		nameTextfield.setFont(new Font("Arial", Font.BOLD, 22));
		nameTextfield.setBounds(219, 208, 214, 53);
		mainFrame.getContentPane().add(nameTextfield);
		nameTextfield.setColumns(10);
		
		nameLabel = new JLabel();
		nameLabel.setBackground(new Color(255, 255, 255));
		nameLabel.setBorder(null);
		nameLabel.setFont(new Font("Arial", Font.BOLD, 22));
		nameLabel.setText("Farmer name :");
		nameLabel.setBounds(23, 204, 199, 53);
		mainFrame.getContentPane().add(nameLabel);
		
		playerSettingLabel = new JLabel("Player Settings");
		playerSettingLabel.setForeground(new Color(255, 255, 255));
		playerSettingLabel.setFont(new Font("Impact", Font.PLAIN, 50));
		playerSettingLabel.setBounds(235, 23, 395, 53);
		mainFrame.getContentPane().add(playerSettingLabel);
		
		
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
		
		
		goalPromptLabel = new JLabel();
		goalPromptLabel.setForeground(Color.BLACK);
		goalPromptLabel.setText("Earn as much money as possible!");
		goalPromptLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		goalPromptLabel.setBorder(null);
		goalPromptLabel.setBackground(Color.WHITE);
		goalPromptLabel.setBounds(23, 78, 534, 53);
		mainFrame.getContentPane().add(goalPromptLabel);
		
		backgroundLabel = new JLabel();
		backgroundLabel.setFocusTraversalPolicyProvider(true);
		backgroundLabel.setDisplayedMnemonic('8');
		backgroundLabel.setIcon(new ImageIcon(FirstPlayerSettingWindow.class.getResource("/main/IMG/startWindowBackground.png")));
		backgroundLabel.setBounds(0, 0, 865, 640);
		mainFrame.getContentPane().add(backgroundLabel);
		
		
		
		
		
	}

	public void closeWindow() {
		mainFrame.getContentPane().removeAll();;
	}
}
