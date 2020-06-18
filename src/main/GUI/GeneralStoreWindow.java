package main.GUI;

/*
 * GeneralStoreWindow
 * 
 * 3 panels in tabbed pane: animals, crops, supplies
 * Each crop/animal has three corresponding components: 
 * a price label 
 * a button 
 * another label to display the current amount the player owns.
 * 
 */



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import animals.Cow;
import animals.Pig;
import animals.Sheep;
import crops.Corn;
import crops.Oats;
import crops.Potato;
import crops.Rice;
import crops.Soybean;
import crops.Wheat;
import main.Animal;
import main.App;
import main.Crop;
import main.Farm;
import main.Farmer;
import main.GeneralStore;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;


public class GeneralStoreWindow {
	private App app;
	private Farmer farmer;
	private Farm farm;
	private GeneralStore store;
	
	private JFrame mainFrame;
	private JPanel cropProductPanel;
	private JPanel animalProductPanel;
	private JPanel farmSupplyPanel;
	private JTabbedPane generalStoreTabbedPane;
	

	private JLabel currentMoneyLabel;
	private JTextField generalStoreTitleLabel;
	private JButton actionMenuButton;
//============Crops=================
	private JLabel promptOnCropsLabel;
	private JLabel availableCropsLabel;
	private JLabel priceCornLabel;
	private JLabel priceOatsLabel;
	private JLabel pricePotatoLabel;
	private JLabel priceRiceLabel;
	private JLabel priceSoybeanLabel;
	private JLabel priceWheatLabel;
	private JLabel numOatsLabel;
	private JLabel numWheatLabel;
	private JLabel numPotatoLabel;
	private JLabel numRiceLabel;
	private JLabel numSoybeanLabel;
	private JLabel numCornLabel;
	private JButton cornButton;
	private JButton oatsButton;
	private JButton potatoButton;
	private JButton riceButton;
	private JButton soybeanButton;
	private JButton wheatButton;
	private JLabel backgroundLabel;
//===========Animals==============
	private JLabel promptOnAnimalsLabel;
	private JLabel availableAnimalsLabel;
	private JLabel priceCowLabel;
	private JLabel priceSheepLabel;
	private JLabel pricePigLabel;
	private JLabel numCowLabel;
	private JLabel numSheepLabel;
	private JLabel numPigLabel;
	private JButton cowButton;
	private JButton pigButton;
	private JButton sheepButton;
//===========Supplies=============
	private JLabel promptOnSuppliesLabel;
	private JLabel availableSuppliesLabel;
	private JLabel priceBaitLabel;
	private JLabel priceHayLabel;
	private JLabel priceFertilizerLabel;
	private JLabel priceTimeMachineLabel;
	private JLabel numBaitLabel;
	private JLabel numHayLabel;
	private JLabel numFertilizerLabel;
	private JButton baitButton;
	private JButton hayButton;
	private JButton fertilizerButton;
	private JButton timeMachineButton;
	
	
	private JButton soundButton;
	
	
	
	
	
	
	
	public GeneralStoreWindow(App inputApp) {
		app = inputApp;
		mainFrame = app.getFrame();
		initialize();
		mainFrame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		farmer = app.getFarmer();
		farm = farmer.getFarm();
		store = app.getStore();

//============app mode below============
		mainFrame.setSize(new Dimension(865, 640));
		mainFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(GeneralStoreWindow.class.getResource("/main/IMG/startWindowBackground.png")));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.repaint();
//============app mode above============		
		
		
		
		generalStoreTabbedPane = new JTabbedPane();

		cropProductPanel = new JPanel();
		generalStoreTabbedPane.add("Crop Products", cropProductPanel);
		animalProductPanel = new JPanel();
		generalStoreTabbedPane.add("Animal Products", animalProductPanel);
		farmSupplyPanel = new JPanel();
		generalStoreTabbedPane.add("Farm Supplies", farmSupplyPanel);
		

		generalStoreTabbedPane.setBounds(0, 80, 865, 535);
		generalStoreTabbedPane.setVisible(true);
		mainFrame.getContentPane().add(generalStoreTabbedPane);
		cropProductPanel.setLayout(null);
		animalProductPanel.setLayout(null);
		farmSupplyPanel.setLayout(null);
		
		
		
		
//Crops below==============================
		promptOnCropsLabel = new JLabel();
		promptOnCropsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		promptOnCropsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		promptOnCropsLabel.setOpaque(true);
		promptOnCropsLabel.setText("Click the picture to buy!");
		promptOnCropsLabel.setForeground(Color.BLACK);
		promptOnCropsLabel.setBounds(461, 13, 313, 40);
		cropProductPanel.add(promptOnCropsLabel);


		
		priceWheatLabel = new JLabel();
		priceWheatLabel.setText("$"+store.getPurchasingPrice("Wheat"));
		priceWheatLabel.setOpaque(true);
		priceWheatLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceWheatLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		priceWheatLabel.setBounds(440, 362, 98, 40);
		cropProductPanel.add(priceWheatLabel);
		
		
		priceSoybeanLabel = new JLabel();
		priceSoybeanLabel.setText("$"+store.getPurchasingPrice("Soybean"));
		priceSoybeanLabel.setOpaque(true);
		priceSoybeanLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceSoybeanLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		priceSoybeanLabel.setBounds(440, 231, 98, 40);
		cropProductPanel.add(priceSoybeanLabel);
		
		priceRiceLabel = new JLabel();
		priceRiceLabel.setText("$"+store.getPurchasingPrice("Rice"));
		priceRiceLabel.setOpaque(true);
		priceRiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceRiceLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		priceRiceLabel.setBounds(440, 106, 98, 40);
		cropProductPanel.add(priceRiceLabel);
		
		pricePotatoLabel = new JLabel();
		pricePotatoLabel.setText("$"+store.getPurchasingPrice("Potato"));
		pricePotatoLabel.setOpaque(true);
		pricePotatoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pricePotatoLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		pricePotatoLabel.setBounds(27, 362, 99, 40);
		cropProductPanel.add(pricePotatoLabel);
		
		priceOatsLabel = new JLabel();
		priceOatsLabel.setText("$"+store.getPurchasingPrice("Oats"));
		priceOatsLabel.setOpaque(true);
		priceOatsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceOatsLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		priceOatsLabel.setBounds(27, 231, 99, 40);
		cropProductPanel.add(priceOatsLabel);
		
		priceCornLabel = new JLabel();
		priceCornLabel.setText("$"+store.getPurchasingPrice("Corn"));
		priceCornLabel.setOpaque(true);
		priceCornLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceCornLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		priceCornLabel.setBounds(28, 106, 98, 40);
		cropProductPanel.add(priceCornLabel);
		
		numWheatLabel = new JLabel();
		numWheatLabel.setOpaque(true);
		numWheatLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numWheatLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		numWheatLabel.setBounds(676, 362, 98, 40);
		cropProductPanel.add(numWheatLabel);
		
		numSoybeanLabel = new JLabel();
		numSoybeanLabel.setOpaque(true);
		numSoybeanLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numSoybeanLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		numSoybeanLabel.setBounds(676, 231, 98, 40);
		cropProductPanel.add(numSoybeanLabel);
		
		numRiceLabel = new JLabel();
		numRiceLabel.setOpaque(true);
		numRiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numRiceLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		numRiceLabel.setBounds(676, 106, 98, 40);
		cropProductPanel.add(numRiceLabel);
		
		numPotatoLabel = new JLabel();
		numPotatoLabel.setOpaque(true);
		numPotatoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numPotatoLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		numPotatoLabel.setBounds(262, 362, 98, 40);
		cropProductPanel.add(numPotatoLabel);
		
		numOatsLabel = new JLabel();
		numOatsLabel.setOpaque(true);
		numOatsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numOatsLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		numOatsLabel.setBounds(262, 231, 98, 40);
		cropProductPanel.add(numOatsLabel);
		
		numCornLabel = new JLabel();
		numCornLabel.setOpaque(true);
		numCornLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numCornLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		numCornLabel.setBounds(262, 106, 98, 40);
		cropProductPanel.add(numCornLabel);
		
		
		wheatButton = new JButton();
		wheatButton.setToolTipText(store.getCropToolTip("Wheat", store.getSellingPrice("Wheat"), store.getGrowthDays("Wheat")));
		wheatButton.setIcon(new ImageIcon(new ImageIcon(GeneralStoreWindow.class.getResource("/main/IMG/wheat1.png")).getImage().getScaledInstance(150,135, 0)));
		wheatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((farmer.getCurrentMoney() - 10 >=0) & (farm.getCropsList().size() + 1 <= farm.getMaxCrops())){
						farmer.reduceCurrentMoney(10);
						farm.getCropsList().add(new Wheat());
						setCropLabelsText();
						currentMoneyLabel.setText("$"+farmer.getCurrentMoney());
						currentMoneyLabel.setForeground(Color.blue);
						promptOnCropsLabel.setForeground(Color.blue);
						if (promptOnCropsLabel.getText().equals("You buy a new wheat")){
							promptOnCropsLabel.setText("You buy a new wheat again!");
							}
						else {
							promptOnCropsLabel.setText("You buy a new wheat");
						}
				}
				else if(farm.getCropsList().size()==farm.getMaxCrops()){
					promptOnCropsLabel.setForeground(Color.RED);
					promptOnCropsLabel.setText("No more space in your farm!");
				}
				else {
					promptOnCropsLabel.setForeground(Color.RED);
					promptOnCropsLabel.setText("You don't have enough money!");
				}
			}
		});
		wheatButton.setFont(new Font("MS Gothic", Font.BOLD, 18));
		wheatButton.setBounds(542, 333, 130, 108);{
			
		}
		cropProductPanel.add(wheatButton);
		
		
		
		soybeanButton = new JButton();
		soybeanButton.setToolTipText(store.getCropToolTip("Soybean", store.getSellingPrice("Soybean"), store.getGrowthDays("Soybean")));
		soybeanButton.setIcon(new ImageIcon(new ImageIcon(GeneralStoreWindow.class.getResource("/main/IMG/soybean.jpg")).getImage().getScaledInstance(130, 101, 0)));
		soybeanButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if ((farmer.getCurrentMoney() - 15 >=0) & (farm.getCropsList().size() + 1 <= farm.getMaxCrops())){
					farmer.reduceCurrentMoney(15);
					farm.getCropsList().add(new Soybean());
					setCropLabelsText();
					currentMoneyLabel.setText("$"+farmer.getCurrentMoney());
					currentMoneyLabel.setForeground(Color.blue);
					promptOnCropsLabel.setForeground(Color.blue);
					if (promptOnCropsLabel.getText().equals("You buy a new soybean")){
						promptOnCropsLabel.setText("You buy a new soybean again!");
						}
					else {
						promptOnCropsLabel.setText("You buy a new soybean");
					}
			}
			else if(farm.getCropsList().size()==farm.getMaxCrops()){
				promptOnCropsLabel.setForeground(Color.RED);
				promptOnCropsLabel.setText("No more space in your farm!");
			}
			else {
				promptOnCropsLabel.setForeground(Color.RED);
				promptOnCropsLabel.setText("You don't have enough money!");
			}
		}
	});
		soybeanButton.setFont(new Font("MS Gothic", Font.BOLD, 18));
		soybeanButton.setBounds(542, 206, 130, 101);
		cropProductPanel.add(soybeanButton);
		
		riceButton = new JButton();
		riceButton.setToolTipText(store.getCropToolTip("Rice", store.getSellingPrice("Rice"), store.getGrowthDays("Rice")));
		riceButton.setIcon(new ImageIcon(new ImageIcon(GeneralStoreWindow.class.getResource("/main/IMG/rice.jpeg")).getImage().getScaledInstance(131, 101, 0)));
		riceButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if ((farmer.getCurrentMoney() - 5 >=0) & (farm.getCropsList().size() < farm.getMaxCrops())){
					farmer.reduceCurrentMoney(5);
					farm.getCropsList().add(new Rice());
					setCropLabelsText();
					currentMoneyLabel.setText("$"+farmer.getCurrentMoney());
					currentMoneyLabel.setForeground(Color.blue);
					promptOnCropsLabel.setForeground(Color.blue);
					if (promptOnCropsLabel.getText().equals("You buy some rice")){
						promptOnCropsLabel.setText("You buy some rice again!");
						}
					else {
						promptOnCropsLabel.setText("You buy some rice");
					}
				}
			else if(farm.getCropsList().size()==farm.getMaxCrops()){
				promptOnCropsLabel.setForeground(Color.RED);
				promptOnCropsLabel.setText("No more space in your farm!");
			}
			else{
				promptOnCropsLabel.setForeground(Color.RED);
				promptOnCropsLabel.setText("You don't have enough money!");
			}
			
			}
		});
		riceButton.setFont(new Font("MS Gothic", Font.BOLD, 18));
		riceButton.setBounds(542, 81, 130, 101);
		cropProductPanel.add(riceButton);
		
		potatoButton = new JButton();
		potatoButton.setToolTipText(store.getCropToolTip("Potato", store.getSellingPrice("Potato"), store.getGrowthDays("Potato")));
		potatoButton.setIcon(new ImageIcon(new ImageIcon(GeneralStoreWindow.class.getResource("/main/IMG/potato.png")).getImage().getScaledInstance(150, 108, 0)));
		potatoButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if ((farmer.getCurrentMoney() - 20 >=0) & (farm.getCropsList().size() + 1 <= farm.getMaxCrops())){
					farmer.reduceCurrentMoney(20);
					farm.getCropsList().add(new Potato());
					setCropLabelsText();
					currentMoneyLabel.setText("$"+farmer.getCurrentMoney());
					currentMoneyLabel.setForeground(Color.blue);
					promptOnCropsLabel.setForeground(Color.blue);
					if (promptOnCropsLabel.getText().equals("You buy a new potato")){
						promptOnCropsLabel.setText("You buy a new potato again!");
						}
					else {
						promptOnCropsLabel.setText("You buy a new potato");
					}
			}
			else if(farm.getCropsList().size()==farm.getMaxCrops()){
				promptOnCropsLabel.setForeground(Color.RED);
				promptOnCropsLabel.setText("No more space in your farm!");
			}
			else {
				promptOnCropsLabel.setForeground(Color.RED);
				promptOnCropsLabel.setText("You don't have enough money!");
			}
		}
	});
		potatoButton.setFont(new Font("MS Gothic", Font.BOLD, 18));
		potatoButton.setBounds(130, 333, 130, 108);
		cropProductPanel.add(potatoButton);
		
		oatsButton = new JButton();
		oatsButton.setToolTipText(store.getCropToolTip("Oats", store.getSellingPrice("Oats"), store.getGrowthDays("Oats")));
		oatsButton.setIcon(new ImageIcon(new ImageIcon(GeneralStoreWindow.class.getResource("/main/IMG/oats.jpg")).getImage().getScaledInstance(131, 101, 0)));
		oatsButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if ((farmer.getCurrentMoney() - 5 >=0) & (farm.getCropsList().size() + 1 <= farm.getMaxCrops())){
					farmer.reduceCurrentMoney(5);
					farm.getCropsList().add(new Oats());
					setCropLabelsText();
					currentMoneyLabel.setText("$"+farmer.getCurrentMoney());
					currentMoneyLabel.setForeground(Color.blue);
					promptOnCropsLabel.setForeground(Color.blue);
					if (promptOnCropsLabel.getText().equals("You buy a new oat")){
						promptOnCropsLabel.setText("You buy a new oat again!");
						}
					else {
						promptOnCropsLabel.setText("You buy a new oat");
					}
			}
			else if(farm.getCropsList().size()==farm.getMaxCrops()){
				promptOnCropsLabel.setForeground(Color.RED);
				promptOnCropsLabel.setText("No more space in your farm!");
			}
			else {
				promptOnCropsLabel.setForeground(Color.RED);
				promptOnCropsLabel.setText("You don't have enough money!");
			}
		}
	});
		oatsButton.setFont(new Font("MS Gothic", Font.BOLD, 18));
		oatsButton.setBounds(130, 202, 130, 108);
		cropProductPanel.add(oatsButton);
		
		cornButton = new JButton();
		cornButton.setIcon(new ImageIcon(new ImageIcon(GeneralStoreWindow.class.getResource("/main/IMG/corn.jpg")).getImage().getScaledInstance(131, 101, 0)));
		cornButton.setToolTipText(store.getCropToolTip("Corn", store.getSellingPrice("Corn"), store.getGrowthDays("Corn")));
		cornButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if ((farmer.getCurrentMoney() - 10 >=0) & (farm.getCropsList().size() + 1 <= farm.getMaxCrops())){
					farmer.reduceCurrentMoney(10);
					farm.getCropsList().add(new Corn());
					setCropLabelsText();
					currentMoneyLabel.setText("$"+farmer.getCurrentMoney());
					currentMoneyLabel.setForeground(Color.blue);
					promptOnCropsLabel.setForeground(Color.blue);
					if (promptOnCropsLabel.getText().equals("You buy a corn")){
						promptOnCropsLabel.setText("You buy some corn again!");
						}
					else {
						promptOnCropsLabel.setText("You buy a corn");
					}
					  
			}
			else if(farm.getCropsList().size()==farm.getMaxCrops()){
				promptOnCropsLabel.setForeground(Color.RED);
				promptOnCropsLabel.setText("No more space in your farm!");
			}
			else {
				promptOnCropsLabel.setForeground(Color.RED);
				promptOnCropsLabel.setText("You don't have enough money!");
			}
		}
	});
		cornButton.setFont(new Font("MS Gothic", Font.BOLD, 18));
		cornButton.setBounds(130, 81, 130, 101);
		cropProductPanel.add(cornButton);
		
		availableCropsLabel = new JLabel();
		availableCropsLabel.setText("Available Crops");
		availableCropsLabel.setOpaque(true);
		availableCropsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		availableCropsLabel.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		availableCropsLabel.setBounds(64, 12, 313, 40);
		cropProductPanel.add(availableCropsLabel);
		
		actionMenuButton = new JButton("Action Menu");
		actionMenuButton.setFont(new Font("Malgun Gothic", Font.BOLD, 22));
		actionMenuButton.setBounds(580, 460, 240, 37);
		cropProductPanel.add(actionMenuButton);
		actionMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.generalStoreToActionsWindow();
			}
		});
		
		backgroundLabel = new JLabel();
		backgroundLabel.setIcon(new ImageIcon(new ImageIcon(GeneralStoreWindow.class.getResource("/main/IMG/GeneralStore.jpg")).getImage().getScaledInstance(855, 666, 0)));
		backgroundLabel.setBounds(0, -80, 855, 666);
		cropProductPanel.add(backgroundLabel);

		setCropLabelsText();
//Crops above======================================================
		
		

//Animals below============================================================
		promptOnAnimalsLabel = new JLabel();
		promptOnAnimalsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		promptOnAnimalsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		promptOnAnimalsLabel.setOpaque(true);
		promptOnAnimalsLabel.setText("Click the picture to buy!");
		promptOnAnimalsLabel.setForeground(Color.BLACK);
		promptOnAnimalsLabel.setBounds(461, 13, 313, 40);
		animalProductPanel.add(promptOnAnimalsLabel);
		
		pricePigLabel = new JLabel();
		pricePigLabel.setText("$"+store.getPurchasingPrice("Pig"));
		pricePigLabel.setOpaque(true);
		pricePigLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pricePigLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		pricePigLabel.setBounds(159, 361, 130, 40);
		animalProductPanel.add(pricePigLabel);

		priceSheepLabel = new JLabel();
		priceSheepLabel.setText("$"+store.getPurchasingPrice("Sheep"));
		priceSheepLabel.setOpaque(true);
		priceSheepLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceSheepLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		priceSheepLabel.setBounds(159, 116, 130, 40);
		animalProductPanel.add(priceSheepLabel);

		priceCowLabel = new JLabel();
		priceCowLabel.setText("$"+store.getPurchasingPrice("Cow"));
		priceCowLabel.setOpaque(true);
		priceCowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceCowLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		priceCowLabel.setBounds(159, 242, 130, 40);
		animalProductPanel.add(priceCowLabel);
		
		numCowLabel = new JLabel();
		numCowLabel.setOpaque(true);
		numCowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numCowLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		numCowLabel.setBounds(508, 116, 98, 40);
		animalProductPanel.add(numCowLabel);
		
		numSheepLabel = new JLabel();
		numSheepLabel.setOpaque(true);
		numSheepLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numSheepLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		numSheepLabel.setBounds(508, 242, 98, 40);
		animalProductPanel.add(numSheepLabel);
		
		numPigLabel = new JLabel();
		numPigLabel.setOpaque(true);
		numPigLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numPigLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		numPigLabel.setBounds(508, 361, 98, 40);
		animalProductPanel.add(numPigLabel);

		availableAnimalsLabel = new JLabel();
		availableAnimalsLabel.setText("Available Animals");
		availableAnimalsLabel.setOpaque(true);
		availableAnimalsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		availableAnimalsLabel.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		availableAnimalsLabel.setBounds(64, 12, 313, 40);
		animalProductPanel.add(availableAnimalsLabel);
		
		
		sheepButton = new JButton();
		sheepButton.setToolTipText(store.getAnimalToolTip("Sheep", store.getDailyGeneratedMoney("Sheep")));
		sheepButton.setIcon(new ImageIcon(new ImageIcon(GeneralStoreWindow.class.getResource("/main/IMG/sheep.jpg")).getImage().getScaledInstance(130, 95, 0)));
		sheepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((farmer.getCurrentMoney() - 60 >= 0) & (farm.getAnimalsList().size() + 1 <= farm.getMaxAnimals())) {
					farmer.reduceCurrentMoney(60);
					farm.getAnimalsList().add(new Sheep());
					setAnimalLabelsText();
					currentMoneyLabel.setText("$" + farmer.getCurrentMoney());
					currentMoneyLabel.setForeground(Color.blue);
					promptOnAnimalsLabel.setForeground(Color.blue);
					if (promptOnAnimalsLabel.getText().equals("You buy a new sheep")) {
						promptOnAnimalsLabel.setText("You buy a new sheep again!");
					} else {
						promptOnAnimalsLabel.setText("You buy a new sheep");
					}
				} else if (farm.getAnimalsList().size() == farm.getMaxAnimals()) {
					promptOnAnimalsLabel.setForeground(Color.RED);
					promptOnAnimalsLabel.setText("No more space in your farm!");
				} else {
					promptOnAnimalsLabel.setForeground(Color.RED);
					promptOnAnimalsLabel.setText("You don't have enough money!");
				}
			}
		});
		sheepButton.setFont(new Font("MS Gothic", Font.BOLD, 18));
		sheepButton.setBounds(328, 211, 130, 95);
		animalProductPanel.add(sheepButton);

		pigButton = new JButton();
		pigButton.setToolTipText(store.getAnimalToolTip("Pig", store.getDailyGeneratedMoney("Pig")));
		pigButton.setIcon(new ImageIcon(new ImageIcon(GeneralStoreWindow.class.getResource("/main/IMG/pig.png")).getImage().getScaledInstance(130, 101, 0)));
		pigButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((farmer.getCurrentMoney() - 45 >= 0) & (farm.getAnimalsList().size() + 1 <= farm.getMaxAnimals())) {
					farmer.reduceCurrentMoney(45);
					farm.getAnimalsList().add(new Pig());
					setAnimalLabelsText();
					currentMoneyLabel.setText("$" + farmer.getCurrentMoney());
					currentMoneyLabel.setForeground(Color.blue);
					promptOnAnimalsLabel.setForeground(Color.blue);
					if (promptOnAnimalsLabel.getText().equals("You buy a pig")) {
						promptOnAnimalsLabel.setText("You buy a new pig again!");
					} else {
						promptOnAnimalsLabel.setText("You buy a pig");
					}
				} else if (farm.getAnimalsList().size() == farm.getMaxAnimals()) {
					promptOnAnimalsLabel.setForeground(Color.RED);
					promptOnAnimalsLabel.setText("No more space in your farm!");
				} else {
					promptOnAnimalsLabel.setForeground(Color.RED);
					promptOnAnimalsLabel.setText("You don't have enough money!");
				}
			}
		});
		pigButton.setFont(new Font("MS Gothic", Font.BOLD, 18));
		pigButton.setBounds(328, 335, 130, 95);
		animalProductPanel.add(pigButton);

		cowButton = new JButton();
		cowButton.setToolTipText(store.getAnimalToolTip("Cow", store.getDailyGeneratedMoney("Cow")));
		cowButton.setIcon(new ImageIcon(new ImageIcon(GeneralStoreWindow.class.getResource("/main/IMG/cow.png")).getImage().getScaledInstance(145, 98, 20)));
		cowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((farmer.getCurrentMoney() - 80 >= 0) & (farm.getAnimalsList().size() + 1 <= farm.getMaxAnimals())) {
					farmer.reduceCurrentMoney(80);
					farm.getAnimalsList().add(new Cow());
					setAnimalLabelsText();
					currentMoneyLabel.setText("$" + farmer.getCurrentMoney());
					currentMoneyLabel.setForeground(Color.blue);
					promptOnAnimalsLabel.setForeground(Color.blue);
					if (promptOnAnimalsLabel.getText().equals("You buy a cow")) {
						promptOnAnimalsLabel.setText("You buy a new cow again!");
					} else {
						promptOnAnimalsLabel.setText("You buy a cow");
					}
				} else if (farm.getAnimalsList().size() == farm.getMaxAnimals()) {
					promptOnAnimalsLabel.setForeground(Color.RED);
					promptOnAnimalsLabel.setText("No more space in your farm!");
				} else {
					promptOnAnimalsLabel.setForeground(Color.RED);
					promptOnAnimalsLabel.setText("You don't have enough money!");
				}
			}
		});
		cowButton.setFont(new Font("MS Gothic", Font.BOLD, 18));
		cowButton.setBounds(328, 86, 130, 95);
		animalProductPanel.add(cowButton);

		actionMenuButton = new JButton("Action Menu");
		actionMenuButton.setFont(new Font("Malgun Gothic", Font.BOLD, 22));
		actionMenuButton.setBounds(580, 460, 240, 37);
		animalProductPanel.add(actionMenuButton);
		actionMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.generalStoreToActionsWindow();
			}
		});

		backgroundLabel = new JLabel();
		backgroundLabel.setIcon(new ImageIcon(new ImageIcon(GeneralStoreWindow.class.getResource("/main/IMG/GeneralStore.jpg")).getImage().getScaledInstance(855, 666, 0)));
		backgroundLabel.setBounds(0, -80, 855, 666);
		animalProductPanel.add(backgroundLabel);
		
		setAnimalLabelsText();
//Animals above============================================================
		
		
		
		
// Supply below============================================================
		promptOnSuppliesLabel = new JLabel();
		promptOnSuppliesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		promptOnSuppliesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		promptOnSuppliesLabel.setOpaque(true);
		promptOnSuppliesLabel.setText("Click the picture to buy!");
		promptOnSuppliesLabel.setForeground(Color.BLACK);
		promptOnSuppliesLabel.setBounds(461, 13, 313, 40);
		farmSupplyPanel.add(promptOnSuppliesLabel);
		
		fertilizerButton = new JButton();
		fertilizerButton.setToolTipText("<html>Fertilizer <br>Using 1 Fertilizer for each plant <br>Growth Cycle - 1");
		fertilizerButton.setIcon(new ImageIcon(new ImageIcon(GeneralStoreWindow.class.getResource("/main/IMG/fertilizer.jpg")).getImage().getScaledInstance(130, 95, 0)));
		fertilizerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (farmer.getCurrentMoney() - 5 >= 0) {
					farmer.reduceCurrentMoney(5);
					farmer.increaseNumFertilizer();
					numFertilizerLabel.setText("x" + farmer.getNumFertilizer());
					currentMoneyLabel.setText("$" + farmer.getCurrentMoney());
					currentMoneyLabel.setForeground(Color.blue);
					promptOnSuppliesLabel.setForeground(Color.blue);
					if (promptOnSuppliesLabel.getText().equals("You buy a fertilizer")) {
						promptOnSuppliesLabel.setText("You buy a new fertilizer again!");
					} else {
						promptOnSuppliesLabel.setText("You buy a fertilizer");
					}
				} else {
					promptOnSuppliesLabel.setForeground(Color.RED);
					promptOnSuppliesLabel.setText("You don't have enough money!");
				}
			}

		});
		fertilizerButton.setFont(new Font("Dialog", Font.BOLD, 18));
		fertilizerButton.setBounds(168, 331, 130, 95);
		farmSupplyPanel.add(fertilizerButton);

		baitButton = new JButton();
		baitButton.setToolTipText("You can use a bait to get fish(Only for fish farm)");
		baitButton.setIcon(new ImageIcon(new ImageIcon(GeneralStoreWindow.class.getResource("/main/IMG/bait.jpg")).getImage().getScaledInstance(130, 95, 0)));
		baitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (farmer.getCurrentMoney() - 1 >= 0) {
					farmer.reduceCurrentMoney(1);
					farmer.increaseNumBait();
					numBaitLabel.setText("x" + farmer.getNumBait());
					currentMoneyLabel.setText("$" + farmer.getCurrentMoney());
					currentMoneyLabel.setForeground(Color.blue);
					promptOnSuppliesLabel.setForeground(Color.blue);
					if (promptOnSuppliesLabel.getText().equals("You buy a bait")) {
						promptOnSuppliesLabel.setText("You buy a new bait again!");
					} else {
						promptOnSuppliesLabel.setText("You buy a bait");
					}
				} else {
					promptOnSuppliesLabel.setForeground(Color.RED);
					promptOnSuppliesLabel.setText("You don't have enough money!");
				}
			}

		});
		baitButton.setFont(new Font("MS Gothic", Font.BOLD, 18));
		baitButton.setBounds(168, 84, 130, 95);
		farmSupplyPanel.add(baitButton);

		hayButton = new JButton();
		hayButton.setToolTipText("<html>Animals Food <br>Using one hay for each animal");
		hayButton.setIcon(new ImageIcon(new ImageIcon(GeneralStoreWindow.class.getResource("/main/IMG/hay.jpg")).getImage().getScaledInstance(130, 95, 0)));
		hayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (farmer.getCurrentMoney() - 5 >= 0) {
					farmer.reduceCurrentMoney(5);
					farmer.increaseNumHay();
					numHayLabel.setText("x"+farmer.getNumHay());
					currentMoneyLabel.setText("$" + farmer.getCurrentMoney());
					currentMoneyLabel.setForeground(Color.blue);
					promptOnSuppliesLabel.setForeground(Color.blue);
					if (promptOnSuppliesLabel.getText().equals("You buy a hay")) {
						promptOnSuppliesLabel.setText("You buy a new hay again!");
					} else {
						promptOnSuppliesLabel.setText("You buy a hay");
					}
				} else {
					promptOnSuppliesLabel.setForeground(Color.RED);
					promptOnSuppliesLabel.setText("You don't have enough money!");
				}
			}

		});
		hayButton.setFont(new Font("MS Gothic", Font.BOLD, 18));
		hayButton.setBounds(168, 209, 130, 95);
		farmSupplyPanel.add(hayButton);

		priceFertilizerLabel = new JLabel();
		priceFertilizerLabel.setText("$5");
		priceFertilizerLabel.setOpaque(true);
		priceFertilizerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceFertilizerLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		priceFertilizerLabel.setBounds(26, 361, 130, 40);
		farmSupplyPanel.add(priceFertilizerLabel);

		priceHayLabel = new JLabel();
		priceHayLabel.setText("$5");
		priceHayLabel.setOpaque(true);
		priceHayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceHayLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		priceHayLabel.setBounds(26, 242, 130, 40);
		farmSupplyPanel.add(priceHayLabel);

		priceBaitLabel = new JLabel();
		priceBaitLabel.setOpaque(true);
		priceBaitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceBaitLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		priceBaitLabel.setText("$1");
		priceBaitLabel.setBounds(26, 116, 130, 40);
		farmSupplyPanel.add(priceBaitLabel);
		
		priceTimeMachineLabel = new JLabel();
		priceTimeMachineLabel.setText("$200");
		priceTimeMachineLabel.setOpaque(true);
		priceTimeMachineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceTimeMachineLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
		priceTimeMachineLabel.setBounds(489, 116, 120, 40);
		farmSupplyPanel.add(priceTimeMachineLabel);
		
		
		numBaitLabel = new JLabel();
		numBaitLabel.setOpaque(true);
		numBaitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numBaitLabel.setText("x"+farmer.getNumBait());
		numBaitLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		numBaitLabel.setBounds(310, 116, 98, 40);
		farmSupplyPanel.add(numBaitLabel);
		
		numHayLabel = new JLabel();
		numHayLabel.setOpaque(true);
		numHayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numHayLabel.setText("x"+farmer.getNumHay());
		numHayLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		numHayLabel.setBounds(310, 242, 98, 40);
		farmSupplyPanel.add(numHayLabel);
		
		numFertilizerLabel = new JLabel();
		numFertilizerLabel.setOpaque(true);
		numFertilizerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numFertilizerLabel.setText("x"+farmer.getNumFertilizer());
		numFertilizerLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 32));
		numFertilizerLabel.setBounds(310, 361, 98, 40);
		farmSupplyPanel.add(numFertilizerLabel);
		
		

		availableSuppliesLabel = new JLabel();
		availableSuppliesLabel.setText("Avaliable Supplies");
		availableSuppliesLabel.setOpaque(true);
		availableSuppliesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		availableSuppliesLabel.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		availableSuppliesLabel.setBounds(64, 12, 313, 40);
		farmSupplyPanel.add(availableSuppliesLabel);

		
		
		timeMachineButton = new JButton();
		timeMachineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (farmer.getCurrentMoney() - 200 < 0) {
					promptOnSuppliesLabel.setForeground(Color.RED);
					promptOnSuppliesLabel.setText("You don't have enough money!");
				}

				else {
					farmer.reduceCurrentMoney(200);
					farmer.useTimeMachine();
					currentMoneyLabel.setText("$" + farmer.getCurrentMoney());
					currentMoneyLabel.setForeground(Color.blue);
					promptOnSuppliesLabel.setForeground(Color.blue);
					if (promptOnSuppliesLabel.getText().equals("You used a time machine")) {
						promptOnSuppliesLabel.setText("You used a time machine again!");
					} else {
						promptOnSuppliesLabel.setText("You used a time machine");
					}
				}
			}
		});
		timeMachineButton.setToolTipText("Increase one day apply immediately");
		timeMachineButton.setFont(new Font("Dialog", Font.BOLD, 18));
		timeMachineButton.setIcon(new ImageIcon(new ImageIcon(GeneralStoreWindow.class.getResource("/main/IMG/timeMachine.jpg")).getImage().getScaledInstance(130, 95, 0)));
		timeMachineButton.setBounds(621, 84, 130, 95);
		farmSupplyPanel.add(timeMachineButton);
		
		actionMenuButton = new JButton("Action Menu");
		actionMenuButton.setFont(new Font("Malgun Gothic", Font.BOLD, 22));
		actionMenuButton.setBounds(580, 460, 240, 37);
		farmSupplyPanel.add(actionMenuButton);
		actionMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.generalStoreToActionsWindow();
			}
		});

		backgroundLabel = new JLabel();
		backgroundLabel.setIcon(new ImageIcon(new ImageIcon(GeneralStoreWindow.class.getResource("/main/IMG/GeneralStore.jpg")).getImage().getScaledInstance(855, 666, 0)));
		backgroundLabel.setBounds(0, -80, 855, 666);
		farmSupplyPanel.add(backgroundLabel);
		
		
		
// Supply above============================================================
		
		currentMoneyLabel = new JLabel();
		currentMoneyLabel.setBorder(null);
		currentMoneyLabel.setOpaque(false);
		currentMoneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		currentMoneyLabel.setFont(new Font("MS Gothic", Font.BOLD, 55));
		currentMoneyLabel.setText("$"+farmer.getCurrentMoney());
		currentMoneyLabel.setBounds(505, 0, 219, 99);
		mainFrame.getContentPane().add(currentMoneyLabel);
		
		
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
		
		generalStoreTitleLabel = new JTextField();
		generalStoreTitleLabel.setText("General Store");
		generalStoreTitleLabel.setOpaque(false);
		generalStoreTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		generalStoreTitleLabel.setFont(new Font("MS Gothic", Font.BOLD, 55));
		generalStoreTitleLabel.setEditable(false);
		generalStoreTitleLabel.setColumns(10);
		generalStoreTitleLabel.setBorder(null);
		generalStoreTitleLabel.setBounds(48, 0, 445, 99);
		mainFrame.getContentPane().add(generalStoreTitleLabel);
		
		
	}
	private void setCropLabelsText() {
		int tempNumPotato=0;
		int tempNumWheat=0;
		int tempNumSoybean=0;
		int tempNumOats=0;
		int tempNumRice=0;
		int tempNumCorn=0;
		for (Crop crop:farm.getCropsList()) {
			switch(crop.getType()) {
			case "Potato":
				tempNumPotato += 1;
				break;
			case "Wheat":
				tempNumWheat += 1;
				break;
			case "Soybean":
				tempNumSoybean += 1;
				break;
			case "Oats":
				tempNumOats += 1;
				break;
			case "Rice":
				tempNumRice += 1;
				break;
			case "Corn":
				tempNumCorn += 1;
				break;
			}
		}
		
		numPotatoLabel.setText("x" +tempNumPotato);
		numWheatLabel.setText("x" +tempNumWheat);
		numSoybeanLabel.setText("x" +tempNumSoybean);
		numOatsLabel.setText("x" +tempNumOats);
		numRiceLabel.setText("x" +tempNumRice);
		numCornLabel.setText("x" +tempNumCorn);
		
	}
	
	private void setAnimalLabelsText() {
		int tempNumCow=0;
		int tempNumSheep=0;
		int tempNumPig=0;
		
		for (Animal animal:farm.getAnimalsList()) {
			switch(animal.getType()) {
			case "Cow":
				tempNumCow += 1;
				break;
			case "Sheep":
				tempNumSheep += 1;
				break;
			case "Pig":
				tempNumPig += 1;
				break;
			}
		}
		numCowLabel.setText("x"+tempNumCow);
		numSheepLabel.setText("x"+tempNumSheep);
		numPigLabel.setText("x"+tempNumPig);
		
	}
	
	public void closeWindow() {
		mainFrame.getContentPane().removeAll();
	}
}
