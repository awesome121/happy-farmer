package main.GUI;

import javax.swing.JFrame;
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
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

@SuppressWarnings("unchecked")
public class TendCropsWindow {
	private App app;
	private JFrame mainFrame;
	private Farmer farmer;
	private Farm farm;

	private boolean hasSpecifiedCropsTypeToShow = false;

	private ArrayList<String> cropTypesString;
	private String specifiedCropTypeToShow;
	private ArrayList<Crop> cropsSameType;


	private JButton soundButton;
	private JButton actionMenuButton;
	private JButton confirmButton;

	private JLabel messageLabel;
	private JLabel actionsAvailableLabel;
	private JLabel cropsInfoLabel;
	private JLabel fertilizerLabel;
	private JLabel actionsInfoLabel;
	private JLabel backgroundLabel;

	private JList actionsList;
	

	private JTextArea cropsInformationTextArea;
	private JComboBox typesOfCropsToShowCombobox;
	private JScrollPane specificInfoScrollPane;
	private JList specificInfoList;

	public TendCropsWindow(App inputApp) {
		app = inputApp;
		mainFrame = app.getFrame();
		initialize();
		mainFrame.repaint();
		mainFrame.setVisible(true);
	}

	public TendCropsWindow(App inputApp, String action, int comIndex, int actionListIndex, int num) {
		app = inputApp;
		mainFrame = app.getFrame();
		initialize();
		if(action.equals("Land")) {
			messageLabel.setText("Last Action: Capacity of growing +" + 3 + ". Animal happiness +" +num);
			messageLabel.setForeground(Color.GREEN);
			typesOfCropsToShowCombobox.setSelectedIndex(comIndex);
		}
		else if(action.equals("Harvest")){
			messageLabel.setText("Last Action: +$" + num + " from harversting!");
			messageLabel.setForeground(Color.GREEN);
		}
		actionsList.setSelectedIndex(actionListIndex);
		mainFrame.repaint();
		mainFrame.setVisible(true);
	}
	
	public TendCropsWindow(App inputApp, String action, int comIndex, int actionListIndex) {
		app = inputApp;
		mainFrame = app.getFrame();
		initialize();
		if(action.equals("Water")) {
			messageLabel.setText("Last Action: You tended crops by water(Free)");
			messageLabel.setForeground(Color.GREEN);
		}
		else if(action.equals("Fertilizer")){
			messageLabel.setText("Last Action: You tended crops by fertilizer");
			messageLabel.setForeground(Color.GREEN);
		}
		typesOfCropsToShowCombobox.setSelectedIndex(comIndex);
		actionsList.setSelectedIndex(actionListIndex);
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

		cropsInfoLabel = new JLabel("Crops Information");
		cropsInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cropsInfoLabel.setOpaque(true);
		cropsInfoLabel.setFont(new Font("Stencil", Font.PLAIN, 13));
		cropsInfoLabel.setBounds(438, 79, 429, 51);
		mainFrame.getContentPane().add(cropsInfoLabel);
		
		
		
		
// *******************DO NOT CHANGE the order below(Unpredicted error would appear otherwise)*************************
		cropsInformationTextArea = new JTextArea();
		cropsInformationTextArea.setEditable(false);
		cropsInformationTextArea.setBorder(null);
		cropsInformationTextArea.setInheritsPopupMenu(true);
		cropsInformationTextArea.setBounds(514, 170, 331, 375);
		cropsInformationTextArea.setText("You don't have any crops.\nBuy some crops to grow first!\n\nYou can only tend your farm land!");
		mainFrame.getContentPane().add(cropsInformationTextArea);
		

		typesOfCropsToShowCombobox = new JComboBox();
		typesOfCropsToShowCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (farm.getCropsList().size() != 0) {
					hasSpecifiedCropsTypeToShow = true;
					specifiedCropTypeToShow = (String) typesOfCropsToShowCombobox.getSelectedItem();
					ArrayList<String> specifiedCropsString = new ArrayList<String>();
					specifiedCropsString.add("Whole variaty");
					cropsSameType = new ArrayList<Crop>();

					int index = 1;
					for (Crop crop : farm.getCropsList()) {
						if (crop.getType().equals(specifiedCropTypeToShow)) {
							if (crop.getHarvestDays() == 0) {
								specifiedCropsString
										.add(specifiedCropTypeToShow + index + " (Ready)");
							} else {
								specifiedCropsString.add(specifiedCropTypeToShow + index);

							}
							cropsSameType.add(crop);
							index += 1;
						}
					}
					specificInfoList.setModel(new AbstractListModel() {
						Object[] values = specifiedCropsString.toArray();
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
		typesOfCropsToShowCombobox.setBorder(null);
		typesOfCropsToShowCombobox.setOpaque(false);
		typesOfCropsToShowCombobox.setFont(new Font("Dialog", Font.BOLD, 20));
		typesOfCropsToShowCombobox.setBounds(51, 195, 199, 51);
		initCombobox();
		mainFrame.getContentPane().add(typesOfCropsToShowCombobox);
		
		
		specificInfoList = new JList();
		specificInfoList.setFont(new Font("Dialog", Font.BOLD, 20));
		specificInfoList.setBounds(293, 170, 199, 375);
		specificInfoList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (specificInfoList.getSelectedIndex() == 0)
					processWholeVariety();
				else if (specificInfoList.getSelectedIndex() > 0)
					processIndividualCrop(specificInfoList.getSelectedIndex());
			}
		});
		
		
		specificInfoScrollPane = new JScrollPane(specificInfoList);
		specificInfoScrollPane.setBounds(293, 170, 199, 375);
		mainFrame.getContentPane().add(specificInfoScrollPane);

		initJlist();
		specificInfoList.setSelectedIndex(0);
// *******************DO NOT CHANGE the order above(Unpredicted error would appear otherwise)*************************

		
		

		fertilizerLabel = new JLabel("Fertilizer: " + farmer.getNumFertilizer());
		fertilizerLabel.setOpaque(true);
		fertilizerLabel.setBackground(Color.WHITE);
		fertilizerLabel.setBounds(33, 153, 109, 30);
		mainFrame.getContentPane().add(fertilizerLabel);
						
						
		
		
		
		

		actionsInfoLabel = new JLabel("Choose action then press confirm to do the aciton");
		actionsInfoLabel.setForeground(Color.BLACK);
		actionsInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		actionsInfoLabel.setOpaque(true);
		actionsInfoLabel.setFont(new Font("Stencil", Font.PLAIN, 13));
		actionsInfoLabel.setBounds(0, 79, 441, 51);
		mainFrame.getContentPane().add(actionsInfoLabel);


		
		
		actionsList = new JList();
		actionsList.setModel(new AbstractListModel() {
			String[] values = new String[] { "Tend Farm Land", "Tend Crops (Fertilizer)", "Tend Crops (Water)", "Harvest Crops" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		actionsList.setSelectedIndex(0);
		actionsList.setFont(new Font("Dialog", Font.BOLD, 20));
		actionsList.setBounds(6, 315, 275, 108);
		actionsList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (actionsList.getSelectedIndex() == 0)
					confirmButton.setToolTipText("Apply to the land");
				else if (actionsList.getSelectedIndex() == 1 | actionsList.getSelectedIndex() == 2)
					confirmButton.setToolTipText("Apply to the whole variety");
				else if(actionsList.getSelectedIndex() == 3)
					confirmButton.setToolTipText("Apply to all crops");
			}
		});
		mainFrame.getContentPane().add(actionsList);
		
		confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (actionsList.getSelectedIndex() == 0) { //Tend land
					if(farmer.getActionsLeft()!=0) {
						int increasedHappiness = farmer.tendtoFarmLand();
						app.refreshTendCropsWindow("Land", typesOfCropsToShowCombobox.getSelectedIndex(), actionsList.getSelectedIndex(), increasedHappiness);
					}
					else {
						actionsInfoLabel.setText("No actions available! Time to sleep!");
						actionsInfoLabel.setForeground(Color.red);
					}
				} else if (!hasSpecifiedCropsTypeToShow) {  
					actionsInfoLabel.setText("Choose crops before confirm");
					actionsInfoLabel.setForeground(Color.red);
				} 
				else {
					if(farmer.getActionsLeft()!=0) {
						String type = (String) typesOfCropsToShowCombobox.getSelectedItem();
						if (actionsList.getSelectedIndex() == 1){//Tend crops by fertilizer
							int count = 0;
							for (Crop crop : farm.getCropsList()) {
								if(crop.getType().equals(type) & crop.getHarvestDays()!=0) 
									count += 1;
							}
							if(count>farmer.getNumFertilizer()) {  // not enough fertilizer
								actionsInfoLabel.setText("Not enough Fertilizer");
								actionsInfoLabel.setForeground(Color.red);
								fertilizerLabel.setForeground(Color.red);
							}
							else if(count == 0) 
								actionsInfoLabel.setText("Don't have to use fertilizer");
								
							else {				//enough fertilizer
								farmer.tendToCrops(type, count);
								app.refreshTendCropsWindow("Fertilizer", typesOfCropsToShowCombobox.getSelectedIndex(), actionsList.getSelectedIndex());
							}
							
							
						} else if (actionsList.getSelectedIndex() == 2) {//Tend Crops by water
							farmer.tendToCrops(type);
							app.refreshTendCropsWindow("Water", typesOfCropsToShowCombobox.getSelectedIndex(), actionsList.getSelectedIndex());
						}

						else { // Harvest crops
							
							boolean hasMatureCrop = false;
							for (Crop crop : farm.getCropsList()) {
								if(crop.getHarvestDays()==0) {
									hasMatureCrop = true;
									break;
								}
							}
							
							if(hasMatureCrop) {
								int total = farmer.harvestCrops();
								app.refreshTendCropsWindow("Harvest", typesOfCropsToShowCombobox.getSelectedIndex(), actionsList.getSelectedIndex(), total);
							}
							else {
								actionsInfoLabel.setText("Be patient! None of them is ready!");
								actionsInfoLabel.setForeground(Color.red);
							}
						}
					}
					else {
						actionsInfoLabel.setText("No actions available! Time to sleep!");
						actionsInfoLabel.setForeground(Color.red);
						
					}
				
				}
			}
		});
		confirmButton.setFont(new Font("Malgun Gothic", Font.BOLD, 22));
		confirmButton.setBounds(53, 444, 184, 51);
		mainFrame.getContentPane().add(confirmButton);
		
		

		actionMenuButton = new JButton("Action Menu");
		actionMenuButton.setFont(new Font("Malgun Gothic", Font.BOLD, 22));
		actionMenuButton.setBounds(633, 562, 212, 41);
		mainFrame.getContentPane().add(actionMenuButton);
		actionMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.tendCropsWindowToActionsWindow();
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
				.setIcon(new ImageIcon(TendCropsWindow.class.getResource("/main/IMG/tendCropsBackground.png")));
		backgroundLabel.setBounds(0, 23, 865, 698);
		mainFrame.getContentPane().add(backgroundLabel);
		
		
	}
	
	private void processWholeVariety() {
		cropsInformationTextArea.setRows(20);
		cropsInformationTextArea.setText("Name: "+typesOfCropsToShowCombobox.getSelectedItem()+"\n");
		cropsInformationTextArea.append("Quantity: "+cropsSameType.size()+"\n");
		int numReadyCrops = 0;
		for (Crop crop:cropsSameType) {
			if(crop.getHarvestDays()==0) 
				numReadyCrops += 1;
		}
		if(numReadyCrops!=0)
			cropsInformationTextArea.append(numReadyCrops+" ready to be harversted!\n\n");
		else
			cropsInformationTextArea.append("No crop is ready, be more patient...\n\n");
		cropsInformationTextArea.append("Number"+" ".repeat(10)+"Status"+" ".repeat(10)+"Days left\n");
		int index = 1;
		for (Crop crop:cropsSameType) {
			if(crop.getHarvestDays()!=0)
				cropsInformationTextArea.append(String.format("  %-4d "+" ".repeat(12)+" %-10s"+" ".repeat(10)+"   %s", index, crop.getStatus(), crop.getHarvestDays())+"\n");
			else
				cropsInformationTextArea.append(String.format("  %-4d "+" ".repeat(12)+" %-10s"+" ".repeat(10)+"*Ready*", index, crop.getStatus())+"\n");
			index += 1;
		}
	}
	
	
	private void processIndividualCrop(int cropNum) {
		Crop crop = cropsSameType.get(cropNum - 1);
		cropsInformationTextArea.setRows(20);
		cropsInformationTextArea.setText(typesOfCropsToShowCombobox.getSelectedItem()+" number: "+cropNum+"\n");
		cropsInformationTextArea.append("Status: "+crop.getStatus()+"\n\n\n");
		if(crop.getTendedStatus()) 
			cropsInformationTextArea.append("Was Tended Yesterday(grow quicklier if you tend it today)\n");
		else
			cropsInformationTextArea.append("Wasn't Tended Yesterday\n");
		if (crop.getHarvestDays()!=0)
			cropsInformationTextArea.append("Days Left to Harvest: "+crop.getHarvestDays()+"\n\n\n");
		else
			cropsInformationTextArea.append("***Ready to Harvest***\n\n\n");
		cropsInformationTextArea.append("Purchasing Price: $"+crop.getPurchasingPrice()+"\n");
		cropsInformationTextArea.append("Selling Price: $"+crop.getSellingPrice()+"\n");
	}
	

	public void closeWindow() {
		mainFrame.getContentPane().removeAll();
	}
	
	
	private void initCombobox()
	{
		cropTypesString = new ArrayList<String>();
		for (Crop crop : farm.getCropsList()) {
			if (!cropTypesString.contains(crop.getType()))
				cropTypesString.add(crop.getType());
		}
		if (cropTypesString.size() != 0) {
			typesOfCropsToShowCombobox.setModel(new DefaultComboBoxModel(cropTypesString.toArray()));
			hasSpecifiedCropsTypeToShow = true;
		} else
			typesOfCropsToShowCombobox.setModel(new DefaultComboBoxModel(new String[] { "Grow crops first" }));
	}
		
	private void initJlist() {
		
		
		if (hasSpecifiedCropsTypeToShow) {
			specifiedCropTypeToShow = (String) typesOfCropsToShowCombobox.getSelectedItem();
			ArrayList<String> specifiedCropsString = new ArrayList<String>();
			specifiedCropsString.add("Whole variaty");
			cropsSameType = new ArrayList<Crop>();

			int index = 1;
			for (Crop crop : farm.getCropsList()) {
				if (crop.getType().equals(specifiedCropTypeToShow)) {
					if (crop.getHarvestDays() == 0) {
						specifiedCropsString.add(specifiedCropTypeToShow + index + " (Ready)");
					} else {
						specifiedCropsString.add(specifiedCropTypeToShow + index);

					}
					cropsSameType.add(crop);
					index += 1;
				}
			}
			specificInfoList.setModel(new AbstractListModel() {
				Object[] values = specifiedCropsString.toArray();

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
