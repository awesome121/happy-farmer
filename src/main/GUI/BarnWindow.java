package main.GUI;

/*
 * Designed similarly as TendCropsWindow.java
 * 
 */

import javax.swing.JFrame;

import main.Animal;
import main.App;
import main.Crop;
import main.Farm;
import main.Farmer;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JViewport;

import java.awt.Color;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

@SuppressWarnings("unchecked")
public class BarnWindow {
	private App app;
	private JFrame mainFrame;
	private Farmer farmer;
	private Farm farm;

	private boolean hasSpecifiedAnimalsTypeToShow = false;

	private ArrayList<String> animalTypesString;
	private String specifiedAnimalTypeToShow;
	private ArrayList<Animal> animalsSameType;


	private JButton soundButton;
	private JButton actionMenuButton;
	private JButton confirmButton;

	private JLabel messageLabel;
	private JLabel actionsAvailableLabel;
	private JLabel animalsInfoLabel;
	private JLabel hayLabel;
	private JLabel baitLabel;
	private JLabel actionsInfoLabel;
	private JLabel backgroundLabel;

	@SuppressWarnings("rawtypes")
	private JList actionsList;
	

	private JTextArea animalsInformationTextArea;
	@SuppressWarnings("rawtypes")
	private JComboBox typesOfAnimalsToShowCombobox;
	private JScrollPane specificInfoScrollPane;
	private JList specificInfoList;
	

	
	
	public BarnWindow(App inputApp) {
		app = inputApp;
		mainFrame = app.getFrame();
		initialize();
		mainFrame.repaint();
		mainFrame.setVisible(true);
	}

	public BarnWindow(App inputApp, String action, int comboIndex, int listIndex, int num) {
		app = inputApp;
		mainFrame = app.getFrame();
		initialize();
		typesOfAnimalsToShowCombobox.setSelectedIndex(comboIndex);
		specificInfoList.setSelectedIndex(listIndex);
		if(action.equals("Play")) {
			messageLabel.setText("Total animals happiness +"+num);
			messageLabel.setForeground(Color.GREEN);
			actionsList.setSelectedIndex(1);
		}
		else if (action.equals("Feed")){
			if(num==0)
				messageLabel.setText("Daily bonus +$"+num+" as no more health increases");
			else
				messageLabel.setText("Daily bonus +$"+num);
			messageLabel.setForeground(Color.GREEN);
			actionsList.setSelectedIndex(0);
			
		}
		else if(action.equals("Fishing")) {
			messageLabel.setText("Money increased by 30 for doing Fishing");
			messageLabel.setForeground(Color.GREEN);
			actionsList.setSelectedIndex(2);
		}
		mainFrame.repaint();
		mainFrame.setVisible(true);
	}


	
	@SuppressWarnings("unchecked")
	private void initialize() {
		farmer = app.getFarmer();
		farm = farmer.getFarm();

		
//	============app mode below============
		mainFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(GeneralStoreWindow.class.getResource("/main/IMG/startWindowBackground.png")));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.repaint();
//	============app mode above============

		animalsInfoLabel = new JLabel("Animals Information");
		animalsInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		animalsInfoLabel.setOpaque(true);
		animalsInfoLabel.setFont(new Font("Stencil", Font.PLAIN, 13));
		animalsInfoLabel.setBounds(438, 79, 429, 51);
		mainFrame.getContentPane().add(animalsInfoLabel);
		
		
		
		
// *******************DO NOT CHANGE the order below(Unpredicted error would appear otherwise)*************************
		animalsInformationTextArea = new JTextArea();
		animalsInformationTextArea.setEditable(false);
		animalsInformationTextArea.setBorder(null);
		animalsInformationTextArea.setInheritsPopupMenu(true);
		animalsInformationTextArea.setBounds(514, 213, 331, 298);
		animalsInformationTextArea.setText("You don't have any animals.\nBuy some animals first!\n");
		mainFrame.getContentPane().add(animalsInformationTextArea);
		

		typesOfAnimalsToShowCombobox = new JComboBox();
		typesOfAnimalsToShowCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (farm.getCropsList().size() != 0) {
					hasSpecifiedAnimalsTypeToShow = true;
					specifiedAnimalTypeToShow = (String) typesOfAnimalsToShowCombobox.getSelectedItem();
					ArrayList<String> specifiedAnimalsString = new ArrayList<String>();
					specifiedAnimalsString.add("Whole variaty");
					animalsSameType = new ArrayList<Animal>();

					int index = 1;
					for (Animal animal : farm.getAnimalsList()) {
						if (animal.getType().equals(specifiedAnimalTypeToShow)) {
							if (animal.getFedStatus()) 
								specifiedAnimalsString.add(specifiedAnimalTypeToShow + index + " (Fed Today)");
							 else 
								specifiedAnimalsString.add(specifiedAnimalTypeToShow + index);
							
							animalsSameType.add(animal);
							index += 1;
						}
					}
					specificInfoList.setModel(new AbstractListModel() {
						Object[] values = specifiedAnimalsString.toArray();
						public int getSize() {
							return values.length;
						}
						public Object getElementAt(int index) {
							return values[index];
						}
					});
					specificInfoList.setSelectedIndex(0);
					specificInfoScrollPane.setVisible(true);
					specificInfoList.setVisible(true);
					processWholeVariety();
				}
			}

		});
		typesOfAnimalsToShowCombobox.setBorder(null);
		typesOfAnimalsToShowCombobox.setOpaque(false);
		typesOfAnimalsToShowCombobox.setFont(new Font("Dialog", Font.BOLD, 20));
		typesOfAnimalsToShowCombobox.setBounds(51, 195, 199, 51);
		initCombobox();
		mainFrame.getContentPane().add(typesOfAnimalsToShowCombobox);
		
		
		specificInfoList = new JList();
		specificInfoList.setFont(new Font("Dialog", Font.BOLD, 20));
		specificInfoList.setBounds(280, 213, 220, 298);
		specificInfoList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (specificInfoList.getSelectedIndex() == 0)
					processWholeVariety();
				else if (specificInfoList.getSelectedIndex() > 0)
					processIndividualCrop(specificInfoList.getSelectedIndex());
			}
		});
		
		
		specificInfoScrollPane = new JScrollPane(specificInfoList);
		specificInfoScrollPane.setBounds(280, 213, 220, 298);
		mainFrame.getContentPane().add(specificInfoScrollPane);
		
		initJlist();
		specificInfoList.setSelectedIndex(0);
// *******************DO NOT CHANGE the order above(Unpredicted error would appear otherwise)*************************

		
		

		hayLabel = new JLabel();
		hayLabel.setOpaque(true);
		hayLabel.setBackground(Color.WHITE);
		hayLabel.setBounds(33, 153, 96, 30);
		hayLabel.setText("Hay : "+farmer.getNumHay());
		mainFrame.getContentPane().add(hayLabel);
		
		baitLabel = new JLabel();
		baitLabel.setOpaque(true);
		baitLabel.setBackground(Color.WHITE);
		baitLabel.setBounds(141, 153, 96, 30);
		baitLabel.setText("Bait : "+farmer.getNumBait());
		mainFrame.getContentPane().add(baitLabel);
		if(farm.getfarmType().equals("FishFarm"))
			baitLabel.setVisible(true);
		else
			baitLabel.setVisible(false);
		

		actionsInfoLabel = new JLabel("Choose action then press confirm to do the aciton");
		actionsInfoLabel.setForeground(Color.BLACK);
		actionsInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		actionsInfoLabel.setOpaque(true);
		actionsInfoLabel.setFont(new Font("Stencil", Font.PLAIN, 13));
		actionsInfoLabel.setBounds(0, 79, 441, 51);
		mainFrame.getContentPane().add(actionsInfoLabel);
		
		
		actionsList = new JList();
		actionsList.setModel(new AbstractListModel() {
			
			String[] values = farm.getfarmType().equals("FishFarm")? new String[] {"Feed with Hay", "Play with Animals", "Do Fishing"}:new String[] {"Feed with Hay", "Play with Animals"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		actionsList.setSelectedIndex(0);
		actionsList.setFont(new Font("Dialog", Font.BOLD, 20));
		actionsList.setBounds(33, 315, 236, 108);
		actionsList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (actionsList.getSelectedIndex() == 0)
					confirmButton.setToolTipText("Apply to the selected animals");
				else if (actionsList.getSelectedIndex() == 1)
					confirmButton.setToolTipText("Apply to the whole variety");
			}
		});
		mainFrame.getContentPane().add(actionsList);

		confirmButton = new JButton("Confirm");
		confirmButton.setToolTipText("Only apply to one selected animal");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!hasSpecifiedAnimalsTypeToShow & farm.getfarmType() != "FishFarm") { // Haven't chosen animal
					actionsInfoLabel.setText("Choose animals before confirm");
					actionsInfoLabel.setForeground(Color.red);
				} else if (farmer.getActionsLeft() == 0) {// No actions available
					actionsInfoLabel.setText("NO actions available! Time to sleep!");
					actionsInfoLabel.setForeground(Color.red);
					actionsAvailableLabel.setForeground(Color.red);
				}

				else if (actionsList.getSelectedIndex() == 0) {// Feed animal using hay

					int animalToFeedIndex = specificInfoList.getSelectedIndex();
					if (animalToFeedIndex == 0) {//feed whole variety
						String type = (String) typesOfAnimalsToShowCombobox.getSelectedItem();
						int count = 0;
						for (Animal animal : farm.getAnimalsList()) {
							if (animal.getType().equals(type)) 
								count += 1;
						}
						if(count>farmer.getNumHay()) {
							actionsInfoLabel.setText("You need " + (count - farmer.getNumHay()) + " more hay!");
							actionsInfoLabel.setForeground(Color.red);
							hayLabel.setForeground(Color.red);
						}
						else {
							int increasedBonus = farmer.feedAnimals(type);
							app.refreshBarnWindow("Feed", typesOfAnimalsToShowCombobox.getSelectedIndex(), specificInfoList.getSelectedIndex(), increasedBonus);
						}
						
					} else {//feed a single animal
						if (farmer.getNumHay() == 0) { 
							actionsInfoLabel.setText("You need more hay!");
							actionsInfoLabel.setForeground(Color.red);
							hayLabel.setForeground(Color.red);
						} else {
							String type = (String) typesOfAnimalsToShowCombobox.getSelectedItem();
							int increasedBonus = farmer.feedOneAnimal(type, animalToFeedIndex);
							app.refreshBarnWindow("Feed", typesOfAnimalsToShowCombobox.getSelectedIndex(), specificInfoList.getSelectedIndex(), increasedBonus);
						}
					}
				} else if(actionsList.getSelectedIndex() == 1){ // Play with animal
					int increasedHappiness = farmer.playWithAnimals();
					app.refreshBarnWindow("Play", typesOfAnimalsToShowCombobox.getSelectedIndex(), specificInfoList.getSelectedIndex(), increasedHappiness);
				} else if(farm.getfarmType().equals("FishFarm")){	//Fishing
					if(farmer.getNumBait()==0) {
						actionsInfoLabel.setText("You don't have enough bait!");
						actionsInfoLabel.setForeground(Color.red);
						baitLabel.setForeground(Color.red);
					}
					else {
						int increasedMoney = farmer.doFishing();
						app.refreshBarnWindow("Fishing", typesOfAnimalsToShowCombobox.getSelectedIndex(), specificInfoList.getSelectedIndex(), increasedMoney);
					}
				}

			}

		});
		confirmButton.setFont(new Font("Malgun Gothic", Font.BOLD, 22));
		confirmButton.setBounds(53, 444, 184, 51);
		mainFrame.getContentPane().add(confirmButton);
		
		

		actionMenuButton = new JButton("Action Menu");
		actionMenuButton.setFont(new Font("Malgun Gothic", Font.BOLD, 22));
		actionMenuButton.setBounds(661, 571, 184, 41);
		mainFrame.getContentPane().add(actionMenuButton);
		actionMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.barnWindowToActionsWindow();
			}
		});

		messageLabel = new JLabel("");
		messageLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		messageLabel.setBounds(6, 16, 460, 51);
		mainFrame.getContentPane().add(messageLabel);

		actionsAvailableLabel = new JLabel("Actions Available : " + farmer.getActionsLeft());
		actionsAvailableLabel.setFont(new Font("Stencil", Font.PLAIN, 22));
		actionsAvailableLabel.setBounds(478, 16, 254, 51);
		mainFrame.getContentPane().add(actionsAvailableLabel);

		soundButton = new JButton("sound");
		soundButton.setBounds(757, 0, 109, 67);
		soundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (app.getIsMuted()) {
					soundButton.setIcon(new ImageIcon(StartWindow.class.getResource("/main/IMG/unmute.png")));
					app.unmute();

				} else {
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
		
		
		

		backgroundLabel = new JLabel();
		backgroundLabel.setAutoscrolls(true);
		backgroundLabel.setFont(new Font("Stencil", Font.PLAIN, 22));
		backgroundLabel
				.setIcon(new ImageIcon(BarnWindow.class.getResource("/main/IMG/tendCropsBackground.png")));
		backgroundLabel.setBounds(0, 23, 865, 698);
		mainFrame.getContentPane().add(backgroundLabel);
		
		
	}
	
	private void processWholeVariety() {
		animalsInformationTextArea.setRows(20);
		animalsInformationTextArea.setText("Name: "+typesOfAnimalsToShowCombobox.getSelectedItem()+"\n");
		animalsInformationTextArea.append("Quantity: "+animalsSameType.size()+"\n");
		int totalBonusToday = 0;
		for (Animal animal:animalsSameType) {
			totalBonusToday += animal.getDailyGeneratedMoney();
		}
		animalsInformationTextArea.append("Total Bonus Today: $"+totalBonusToday+"\n\n\n");
		animalsInformationTextArea.append("Number"+" ".repeat(10)+"Status"+" ".repeat(10)+"Daily Bonus\n");
		int index = 1;
		for (Animal animal:animalsSameType) {
			if (animal.getFedStatus())
				animalsInformationTextArea.append(String.format("  %-4d "+" ".repeat(12)+" %-10s"+" ".repeat(10)+"   %s", index, "Fed Today", "$"+animal.getDailyGeneratedMoney())+"\n");
			else
				animalsInformationTextArea.append(String.format("  %-4d "+" ".repeat(12)+" %-10s"+" ".repeat(10)+"   %s", index, "Hungry", "$"+animal.getDailyGeneratedMoney())+"\n");
			index += 1;
		}
	}
	
	
	private void processIndividualCrop(int animalNum) {
		Animal animal = animalsSameType.get(animalNum - 1);
		animalsInformationTextArea.setRows(20);
		animalsInformationTextArea.setText(typesOfAnimalsToShowCombobox.getSelectedItem()+" number: "+animalNum+"\n\n");
		animalsInformationTextArea.append("Health: "+animal.getHealth()+"%"+"\n");
		animalsInformationTextArea.append("Happiness: "+animal.getHappiness()+"%"+"\n\n");
		animalsInformationTextArea.append("Was Fed Today: "+animal.getFedStatus()+"\n");
		animalsInformationTextArea.append("Purchasing Price: $"+animal.getPurchasingPrice()+"\n");
		if(animal.getHappiness()==100 & animal.getHealth()==100)
			animalsInformationTextArea.append("Daily Bonus: $"+animal.getDailyGeneratedMoney()+" (Maximum)\n");
		else
			animalsInformationTextArea.append("Daily Bonus: $"+animal.getDailyGeneratedMoney()+"\n");
		
		switch (animal.getType()) {
		case "Sheep":
			animalsInformationTextArea.append("Note: 20% from happiness and 20% from health \nfor sheep");
			break;
		case "Cow":
			animalsInformationTextArea.append("Note: 30% from happiness and 30% from health \nfor a cow");
			break;
		case "Pig":
			animalsInformationTextArea.append("Note: 10% from happiness and 10% from health \nfor a pig");
			break;
		}
		
	}
	

	public void closeWindow() {
		mainFrame.getContentPane().removeAll();
	}
	
	
	private void initCombobox()
	{
		animalTypesString = new ArrayList<String>();
		for (Animal animal : farm.getAnimalsList()) {
			if (!animalTypesString.contains(animal.getType()))
				animalTypesString.add(animal.getType());
		}
		if (animalTypesString.size() != 0) {
			typesOfAnimalsToShowCombobox.setModel(new DefaultComboBoxModel(animalTypesString.toArray()));
			hasSpecifiedAnimalsTypeToShow = true;
		} else
			typesOfAnimalsToShowCombobox.setModel(new DefaultComboBoxModel(new String[] { "Buy animals first" }));
	}
		
	private void initJlist() {
		
		
		if (hasSpecifiedAnimalsTypeToShow) {
			specifiedAnimalTypeToShow = (String) typesOfAnimalsToShowCombobox.getSelectedItem();
			ArrayList<String> specifiedAnimalsString = new ArrayList<String>();
			specifiedAnimalsString.add("Whole variaty");
			animalsSameType = new ArrayList<Animal>();

			int index = 1;
			for (Animal animal : farm.getAnimalsList()) {
				if (animal.getType().equals(specifiedAnimalTypeToShow)) {
					if (animal.getFedStatus())
						specifiedAnimalsString.add(specifiedAnimalTypeToShow + index + " (Fed Today)");
					else
						specifiedAnimalsString.add(specifiedAnimalTypeToShow + index);
					animalsSameType.add(animal);
					index += 1;
				}
			}
			specificInfoList.setModel(new AbstractListModel() {
				Object[] values = specifiedAnimalsString.toArray();

				public int getSize() {
					return values.length;
				}

				public Object getElementAt(int index) {
					return values[index];
				}
			});
			specificInfoScrollPane.setVisible(true);
			specificInfoList.setVisible(true);
		} else {
			specificInfoList.setVisible(false);
			specificInfoScrollPane.setVisible(false);
		}
	}
}
