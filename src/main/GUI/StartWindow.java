package main.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import main.App;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Dimension;
/*
 * ***********Application Frame starts here!***********
 *  All the windows use this shared frame
 *  StartWindow.java  -->  FirstPlayerPlayerSettingWindow.java
 *  New Game button is to start the game by switching to FirstPlayerPlayerSettingWindow.java
 *  
 *  StartWindow.java  -->  AchieveWindow.java
 *  Read Achieve are implemented for saving and loading the game file and by clicking Read Achieve to go to  AchieveWindow.java
 */ 

public class StartWindow {
	private App app;
	private JFrame mainFrame;
	private JLabel backgroundLabel;
	private JLabel title;
	private JButton startButton;
    private JButton soundButton;
    private JButton achiveButton;
    
    
	public StartWindow(App InputApp) {
		app = InputApp;
		initialize();
		mainFrame.setVisible(true);
		app.unmute();
		
	}
	

	
	private void initialize() {

		
		mainFrame = new JFrame();
		mainFrame.setResizable(false);
		mainFrame.setSize(new Dimension(865, 640));
		mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(StartWindow.class.getResource("/main/IMG/startWindowBackground.png")));
		mainFrame.setTitle("Happy Farmer");
		mainFrame.setBounds(100, 100, 865, 640);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setLocation(0, 0);
		
		startButton = new JButton("New Game");
		startButton.setForeground(Color.WHITE);
		startButton.setBorderPainted(false);
		startButton.setOpaque(false);
		startButton.setBackground(new Color(255, 255, 255));
		startButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 53));
		startButton.setBounds(255, 331, 339, 67);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.startWindowToFirstPlayerSettingWindow();
			}
		});
		mainFrame.getContentPane().add(startButton);
		
		
		
		
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
		
		soundButton.setIcon(new ImageIcon(StartWindow.class.getResource("/main/IMG/unmute.png")));
		mainFrame.getContentPane().add(soundButton);
		
		title = new JLabel("Happy Farmer");
		title.setBounds(0, 106, 850, 82);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(102, 0, 102));
		title.setFont(new Font("Forte", Font.ITALIC, 80));
		mainFrame.getContentPane().add(title);
		
		achiveButton = new JButton("Read Achive");
		achiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(1);
				app.startWindowToAchiveWindow();
			}
		});
		achiveButton.setOpaque(false);
		achiveButton.setForeground(Color.WHITE);
		achiveButton.setFont(new Font("Dialog", Font.PLAIN, 32));
		achiveButton.setBorderPainted(false);
		achiveButton.setBackground(Color.WHITE);
		achiveButton.setBounds(261, 410, 317, 50);
		mainFrame.getContentPane().add(achiveButton);
		
		backgroundLabel = new JLabel();
		backgroundLabel.setFocusTraversalKeysEnabled(false);
		backgroundLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		backgroundLabel.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundLabel.setBounds(0, 0, 865, 640);
		backgroundLabel.setLocation(0, 0);
		backgroundLabel.setIcon(new ImageIcon(StartWindow.class.getResource("/main/IMG/startWindowBackground.png")));
		mainFrame.getContentPane().add(backgroundLabel);
		backgroundLabel.setVisible(true);
	}
	
	
	
	
	public JFrame closeWindow() {
		mainFrame.getContentPane().removeAll();
		return mainFrame;
	}
}
