package main.GUI;

import main.AchiveObject;
import main.App;
import main.Farm;
import main.Farmer;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class AchiveWindow {

	private App app;
	private JFrame mainFrame;
	private Farmer farmer;
	
	private JLabel backgroundLabel;
	@SuppressWarnings("rawtypes")
	private JList fileList;
	private JScrollPane fileScrollPane;
	private JTextArea fileDescriptionTextArea;
	private JLabel promptLabel;
	private JButton loadAchiveButton;
	private JButton newGameButton;
	private JButton saveButton;
	private JButton soundButton;
	private JButton backButton;
	
//	private ArrayList<AchiveObject> achiveObjects = new ArrayList<AchiveObject>();
	private ArrayList<Farmer> achiveObjects = new ArrayList<Farmer>();
	
	
	private FileOutputStream fileOut;
	private ObjectOutputStream out;
	private FileInputStream fileIn;
	private ObjectInputStream in;

	/**
	 * Launch the application.
	 */
	public AchiveWindow(App inputApp) {
		app = inputApp;
		mainFrame = app.getFrame();
		farmer = app.getFarmer();
		initialize();
		if(app.isGameStarted())
			saveButton.setVisible(true);
		mainFrame.repaint();
		mainFrame.setVisible(true);
		
	}


	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		

//		============App mode================
//		mainFrame = new JFrame();
//		mainFrame.setResizable(false);
		mainFrame.setSize(new Dimension(865, 640));
		mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(FirstPlayerSettingWindow.class.getResource("/main/IMG/startWindowBackground.png")));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.repaint();
//		============App mode================
		

		fileDescriptionTextArea = new JTextArea();
		fileDescriptionTextArea.setEditable(false);
		fileDescriptionTextArea.setFont(new Font("Dialog", Font.PLAIN, 20));
		fileDescriptionTextArea.setBounds(384, 102, 302, 298);
		fileDescriptionTextArea.setVisible(false);
		mainFrame.getContentPane().add(fileDescriptionTextArea);
		
		
		promptLabel = new JLabel();
		promptLabel.setFont(new Font("Arial", Font.BOLD, 22));
		promptLabel.setBorder(null);
		promptLabel.setBackground(Color.WHITE);
		promptLabel.setBounds(175, 14, 500, 53);
		mainFrame.getContentPane().add(promptLabel);

		
		fileList = new JList();
		ArrayList<String> temp = new ArrayList<String>();
		readAchive();
		if (achiveObjects.size()==0)
			promptLabel.setText("No Available Achive");
		else {
			for(Farmer achive: achiveObjects) {
				temp.add(achive.getName() + "  " + achive.getLastActiveTime().toString());
			}
		}
		fileList.setModel(new AbstractListModel() {
			Object[] values = temp.toArray();
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		fileList.setFont(new Font("Dialog", Font.BOLD, 20));
		fileList.setBounds(100, 100, 199, 298);
		fileList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
			}
		});
		
		fileScrollPane = new JScrollPane(fileList);
		fileScrollPane.setBounds(100, 100, 230, 298);
		mainFrame.getContentPane().add(fileScrollPane);
		
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.achiveWindowToFirstPlayerSettingWindow();
			}
		});
		newGameButton.setBounds(78, 443, 138, 47);
		mainFrame.getContentPane().add(newGameButton);
		
		loadAchiveButton = new JButton("Load Game");
		loadAchiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = fileList.getSelectedIndex();
				if (index > -1)
					app.load_game(achiveObjects.get(index));
				else
					promptLabel.setText("Select an archive to load");
			}
		});
		loadAchiveButton.setBounds(630, 508, 155, 47);
		mainFrame.getContentPane().add(loadAchiveButton);
		
		
		
		
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmer.setLastActiveTime(new Date());
				achiveObjects.add(farmer);
				storeAchive();
				app.refreshAchiveWindow();
			}
		});
		saveButton.setBounds(630, 443, 155, 47);
		saveButton.setVisible(false);
		mainFrame.getContentPane().add(saveButton);
		
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (app.isGameStarted())
					app.achiveWindowToPlayerProfileWindow();
				else
					app.achiveWindowToStartWindow();
			}
		});
		backButton.setBounds(33, 508, 155, 47);
		backButton.setVisible(true);
		mainFrame.getContentPane().add(backButton);
		
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
		if(app.getIsMuted()) {
			soundButton.setIcon(new ImageIcon(StartWindow.class.getResource("/main/IMG/mute.png")));
		}
		else {
			soundButton.setIcon(new ImageIcon(StartWindow.class.getResource("/main/IMG/unmute.png")));
		}
		mainFrame.getContentPane().add(soundButton);
		
		
		backgroundLabel = new JLabel();
		backgroundLabel.setFocusTraversalKeysEnabled(false);
		backgroundLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		backgroundLabel.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundLabel.setBounds(24, 406, 865, 640);
		backgroundLabel.setLocation(0, 0);
		backgroundLabel.setIcon(new ImageIcon(StartWindow.class.getResource("/main/IMG/startWindowBackground.png")));
		mainFrame.getContentPane().add(backgroundLabel);
		
		
	}

	public void readAchive(){
		try {
			fileIn = new FileInputStream("Achive.ser");
			try {
				in = new ObjectInputStream(fileIn);
				int numFarmer = (int) in.readObject();
				for(int i=1; i <= numFarmer; i++) {
					Farmer achive = (Farmer) in.readObject();
					achiveObjects.add(achive);
				}
			} catch (java.io.EOFException e) {
				// File is empty
			} 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void storeAchive() {
		try {
			fileOut = new FileOutputStream("Achive.ser");
			out = new ObjectOutputStream(fileOut);
			out.reset();
			out.writeObject(achiveObjects.size());
			for(Farmer achive : achiveObjects) {
				
				out.writeObject(achive);
			}
			out.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void closeWindow() {
		mainFrame.getContentPane().removeAll();
		
	}
}
