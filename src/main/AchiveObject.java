package main;

import java.io.Serializable;
import java.util.Date;

public class AchiveObject implements Serializable{
	private int days;
	private String farmerName;
	private int farmerAge;
	private Farm farm;
	private Date startDate;

	private int currentMoney;
	private int actions = 2;
	private int numBait = 0;
	private int numHay = 0;
	private int numFertilizer = 0;
	
	public AchiveObject(Farmer farmer) {
		if (farmer != null) {
		days = farmer.getDaysLeft();
		farmerName = farmer.getName();
		farmerAge = farmer.getAge();
		startDate = farmer.getStartDate();
		currentMoney = farmer.getCurrentMoney();
		actions = farmer.getActionsLeft();
		numBait = farmer.getNumBait();
		numHay = farmer.getNumHay();
		numFertilizer = farmer.getNumFertilizer();
		}
//		farm = farmer.getFarm();
	}
	
	public int getDays() {
		return days;
	}
	
	public String getFarmerName() {
		return farmerName;
	}
	
	public int getFarmerAge() {
		return farmerAge;
	}
	
	public Farm getFarm() {
		return farm;
	}
	
	public Date getDate() {
		return startDate;
	}
	
	public int getCurrentMoney() {
		return currentMoney;
	}
	
	public int getActionsLeft() {
		return actions;
	}
	
	public int getNumHay() {
		return numHay;
	}
	
	public int getNumBait() {
		return numBait;
	}
	
	public int getNumFertilizer() {
		return numFertilizer;
	}
}

