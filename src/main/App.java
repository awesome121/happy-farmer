package main;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import main.GUI.AchiveWindow;
import main.GUI.ActionsWindow;
import main.GUI.BarnWindow;
import main.GUI.FinishWindow;
import main.GUI.FirstPlayerSettingWindow;
import main.GUI.GeneralStoreWindow;
import main.GUI.PlayerProfileWindow;
import main.GUI.SecondPlayerSettingWindow;
import main.GUI.StartWindow;
import main.GUI.TendCropsWindow;


/**
 * ***********Application starts here!***********
 * 
 * App() triggers the first window
 * 
 * 1. Player Setting:
 * 		StartWindow.java  -->  AchiveWindow.java
 * 			|                     |
 * 		   \|/                   \|/
 * 		FirstPlayerSettingWindow.java
 * 		SecondPlayerSettingWindow.java
 * 
 * 2. Game starts:
 * 		ActionsWindow.java
 * 		
 * 		There are a few windows the player is able to switch back on:
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
 * 3. Game finishes:
 * 		FinishWindow.java
 * 
 * 
 * 
 */
public class App {
	private JFrame mainFrame;
	
	private StartWindow startWindow;
	private AchiveWindow achiveWindow;
	private FirstPlayerSettingWindow firstPlayerSettingWindow;
	private SecondPlayerSettingWindow secondPlayerSettingWindow;
	private ActionsWindow actionsWindow;
	private GeneralStoreWindow generalStoreWindow;
	private TendCropsWindow tendCropsWindow;
	private BarnWindow barnWindow;
	private PlayerProfileWindow playerProfileWindow;
	private FinishWindow finishWindow;
	
	
	private Clip sound;
	private boolean isMuted = true;
	private boolean isFarmerCreated = false;
	
	private int startingDays;
	private int age;
	private String farmerName;
	
	private Farmer farmer;
	private GeneralStore store;
	

	public App() {
		launchStartWindow();
		
	}
	
//	===================================Launch below==============
	
	public void launchStartWindow() {
		startWindow = new StartWindow(this);
	}
	
	public void launchAchiveWindow() {
			achiveWindow = new AchiveWindow(this);
	}
	
	
	public void launchFirstPlayerSettingWindow() {
		firstPlayerSettingWindow = new FirstPlayerSettingWindow(this);
	}
	
	
	public void launchSecondPlayerSettingWindow() {
		secondPlayerSettingWindow = new SecondPlayerSettingWindow(this);
	}

	
	public void launchActionsWindow() {
		actionsWindow = new ActionsWindow(this);
	}
	
	
	public void launchGeneralStoreWindow() {
		generalStoreWindow = new GeneralStoreWindow(this);
	}
	
	
	public void launchTendCropsWindow() {
		tendCropsWindow = new TendCropsWindow(this);
	}
	
	public void launchBarnWindow() {
		barnWindow = new BarnWindow(this);
	}
	
	public void launchPlayerProfileWindow() {
		playerProfileWindow = new PlayerProfileWindow(this);
	}
	
	public void launchFinishWindow() {
		finishWindow = new FinishWindow(this);
	}
	
//	===================================switch window method below==============
	
	public void startWindowToAchiveWindow() {
		mainFrame = startWindow.closeWindow();
		startWindow = null;
		launchAchiveWindow();
	}
	
	public void achiveWindowToFirstPlayerSettingWindow() {
		achiveWindow.closeWindow();
		achiveWindow = null;
		launchFirstPlayerSettingWindow();
	}
	
	
	
	public void startWindowToFirstPlayerSettingWindow() {
		mainFrame = startWindow.closeWindow();
		startWindow = null;
		launchFirstPlayerSettingWindow();
	}
	
	
	public void firstPlayerSettingWindowToSecondPlayerSettingWindow(int inputDays, int inputAge, String inputFarmerName) {
		startingDays = inputDays;
		age = inputAge;
		farmerName = inputFarmerName;
		firstPlayerSettingWindow.closeWindow();
		firstPlayerSettingWindow = null;
		launchSecondPlayerSettingWindow();
	}

	
	public void secondPlayerSettingWindowToActionsWindow(Farm farm) {
		farmer = new Farmer(startingDays, farmerName, age, farm);
		isFarmerCreated = true;
		farmer.setStartDate();
		store = new GeneralStore();
		secondPlayerSettingWindow.closeWindow();
		secondPlayerSettingWindow = null;
		launchActionsWindow();
	}
	
	
	public void actionsWindowToGeneralStoreWindow() {
		actionsWindow.closeWindow();
		actionsWindow = null;
		launchGeneralStoreWindow();
	}

	public void generalStoreToActionsWindow() {
		generalStoreWindow.closeWindow();
		generalStoreWindow = null;
		launchActionsWindow();
	}
	
	public void actionsWindowToTendCropsWindow() {
		actionsWindow.closeWindow();
		actionsWindow = null;
		launchTendCropsWindow();
	}
	
	public void tendCropsWindowToActionsWindow() {
		tendCropsWindow.closeWindow();
		actionsWindow = null;
		launchActionsWindow();
	}

	public void actionsWindowToBarnWindow() {
		actionsWindow.closeWindow();
		actionsWindow = null;
		launchBarnWindow();
	}
	
	public void barnWindowToActionsWindow() {
		barnWindow.closeWindow();
		barnWindow = null;
		launchActionsWindow();
	}
	
	public void actionsWindowToPlayerProfileWindow() {
		actionsWindow.closeWindow();
		actionsWindow = null;
		launchPlayerProfileWindow();
		
	}
	
	public void playerProfileWindowToActionsWindow() {
		playerProfileWindow.closeWindow();
		playerProfileWindow = null;
		launchActionsWindow();
		
	}
	
	public void actionsWindowToFinishWindow() {
		actionsWindow.closeWindow();
		actionsWindow = null;
		launchFinishWindow();
	}
	
	public void playerProfileWindowToAchiveWindow() {
		playerProfileWindow.closeWindow();
		playerProfileWindow = null;
		launchAchiveWindow();
	}
	
//	===================================refresh method below=============
	
	
	public void refreshTendCropsWindow() {
		tendCropsWindow.closeWindow();
		tendCropsWindow = new TendCropsWindow(this);
	}
	
	public void refreshTendCropsWindow(String action, int comIndex, int index,int num) {//tend land, harverst
		tendCropsWindow.closeWindow();
		tendCropsWindow = new TendCropsWindow(this, action, comIndex, index, num);
	}
	
	public void refreshTendCropsWindow(String action, int comIndex, int index) {//fertilizer, water
		tendCropsWindow.closeWindow();
		tendCropsWindow = new TendCropsWindow(this, action, comIndex, index);
	}
	
	public void refreshActionsWindow() {
		actionsWindow.closeWindow();
		actionsWindow = new ActionsWindow(this);
	}
	
	public void refreshActionsWindow(int dailyBonus, String message) {
		actionsWindow.closeWindow();
		actionsWindow = new ActionsWindow(this, dailyBonus, message);
	}
	
	public void refreshBarnWindow() {
		barnWindow.closeWindow();
		barnWindow = new BarnWindow(this);
	}
	
	public void refreshBarnWindow(String action, int comboIndex, int listIndex,  int num) {
		barnWindow.closeWindow();
		barnWindow = new BarnWindow(this, action, comboIndex, listIndex, num);
	}
	
	
	public void refreshAchiveWindow() {
		achiveWindow.closeWindow();
		achiveWindow = new AchiveWindow(this);
	}
	
	
//	===================================getter and setter below================
	
	public JFrame getFrame() {
		return mainFrame;
	}
	
	public String getFarmerName() {
		return farmerName;
	}
	
	public Farmer getFarmer() {
		return farmer;
	}
	
	
	public boolean getIsMuted() {
		return isMuted;
	}
	
	public boolean isGameStarted() {
		return isFarmerCreated;
	}
	
	public GeneralStore getStore() {
		return store;
	}
	
	public int getPlayingDuration() {	
		return startingDays;
	}
	
	public void load_game(Farmer achiveObject) {
		farmer = achiveObject;
		farmerName = farmer.getName();
		isFarmerCreated = true;
		startingDays = farmer.getStartingDays();
		store = new GeneralStore();
		achiveWindow.closeWindow();
		launchActionsWindow();
	}
	
//	=========sound==============================
	public void mute() {
		if (!isMuted) {
			isMuted = true;
			sound.stop();
		}
	}
	
	public void unmute() {
		if (isMuted) {
			isMuted = false;
			try {
				if (sound==null) {
				AudioInputStream audioInputStream = AudioSystem
						.getAudioInputStream(this.getClass().getResource("/main/IMG/backgroundMusic.wav"));
				sound = AudioSystem.getClip();
				sound.open(audioInputStream);
				sound.start();
				sound.loop(Clip.LOOP_CONTINUOUSLY);
				// If you want the sound to loop infinitely, then put:
				// clip.loop(Clip.LOOPCONTINUOUSLY);
				// If you want to stop the sound, then use clip.stop();
				}
				else {
					sound.start();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
//	=========sound===============================
	
	public static void main(String[] args) {
		App application = new App();
	}

	
}
