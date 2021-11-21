package main;


import java.io.Serializable;

/*Class Farmer is the main class for player in this project.
 * It contains all the information the player has and interacts with GUI classes through App.java
 * 
 * 
 * All the actions, switch to the next day method are in this class
 */


import java.util.ArrayList;
import java.util.Date;

public class Farmer implements Serializable{
	private int daysLeft;
	private int startingDays;
	private String farmerName;
	private int farmerAge;
	private Farm farm;
	private Date startDate;
	private Date lastActiveTime;
	
	private int currentMoney;
	private int actions = 2;
	private int numBait=0;
	private int numHay=0;
	private int numFertilizer=0;
	private transient RandomEvent event;
	
	public Farmer(int initialDays, String name, int age, Farm inputFarm){
		daysLeft = initialDays;
		startingDays = initialDays;
		farmerName = name;
		farmerAge = age;
		farm = inputFarm;
		
		if (inputFarm.farmType.equals("StandardFarm")){
			currentMoney = 150;
		}
		else {
			currentMoney = 100;
		}
		currentMoney -= 10 * (daysLeft-5);
	}
	

	public int tendtoFarmLand() {
		actions -= 1;
		int totalHappiness = 0;
		farm.maxCrops += 3;
		for (int i = 0; i < farm.animalsList.size(); i++) {
			if (farm.animalsList.get(i).happiness + 10 < 100) {
				farm.animalsList.get(i).happiness += 10;
				totalHappiness += 10;
				}
			else {
				totalHappiness += 100 - farm.animalsList.get(i).happiness;
				farm.animalsList.get(i).happiness = 100;
			}
		}
		return totalHappiness;
	
	}

		
	public void tendToCrops(String type, int numFertilizerUsed) { // fertilizer
		actions -= 1;
		numFertilizer -= numFertilizerUsed;
		for(Crop crop: farm.getCropsList()) {
			if(crop.getType().equals(type)) {
				crop.status = "Healthy";
				if(crop.getHarvestDays()!=0) {
					if(crop.wasTendedToday) {
						crop.decreaseHarvestDaysBy(3);
					}
					else {
						crop.wasTendedToday = true;
						crop.decreaseHarvestDaysBy(2);
					}
						
				}
			}
		}
	}
	
	
	public void tendToCrops(String type) { // water
		actions -= 1;
		for(Crop crop: farm.getCropsList()) {
			if(crop.getType().equals(type)) {
				crop.setStatus("Healthy");
				if(crop.getHarvestDays()!=0) {
					if(crop.wasTendedToday) {
						crop.decreaseHarvestDaysBy(2);
					}
					else {
						crop.decreaseHarvestDaysBy(1);
						crop.setTendStatus(true);
					}
						
				}
			}
		}
		
	}
		
	

	
	
	
	public int harvestCrops() { // return the amount of money that crop can generated
		int total = 0;
		actions -= 1;
		ArrayList<Crop> newCropsList = new ArrayList<Crop>();
		for(Crop crop: farm.getCropsList()) {
			if(crop.getHarvestDays()==0) {
				total += crop.sellingPrice;
			}
			else 
				newCropsList.add(crop);
		}
		farm.cropsList = newCropsList;
		currentMoney += total;
		return total;
	}
	
	
	public int feedOneAnimal(String type, int animalToFeedIndex) {
		animalToFeedIndex -= 1;
		actions -= 1;
		numHay -= 1;
		int temp;
		ArrayList<Animal> animals = new ArrayList<Animal>();
		for(Animal animal: farm.getAnimalsList()) {
			animals.add(animal);
		}
		Animal animal = animals.get(animalToFeedIndex);
		temp = animal.getDailyGeneratedMoney();
		if(animal.getFedStatus())
			animal.increaseHealthBy(30);
		else
			animal.increaseHealthBy(20);
		animal.updateDailyGeneratedMoney();
		animal.setFedStatus(true);
		
		return animal.getDailyGeneratedMoney()-temp;
	}
	
	public int feedAnimals(String type) {
		actions -= 1;
		int total = 0;
		int temp;
		for (int i = 0; i < farm.getAnimalsList().size(); i++) {
			if (farm.getAnimalsList().get(i).getType().equals(type)) {
				Animal animal = farm.getAnimalsList().get(i);
				numHay -= 1;
				temp = animal.getDailyGeneratedMoney();
				if (animal.getFedStatus())
					animal.increaseHealthBy(30);
				else
					animal.increaseHealthBy(20);
				animal.updateDailyGeneratedMoney();
				total += animal.getDailyGeneratedMoney() - temp;

				animal.setFedStatus(true);

			}
		}
		return total;
	}
	

	
	public int playWithAnimals() {
		actions -= 1;
		int total = 0;
		for(Animal animal: farm.getAnimalsList()) {
			int temp = animal.getHappiness();
			animal.increaseHappinessBy(20);
			animal.updateDailyGeneratedMoney();
			total += animal.getHappiness() - temp;
		}
		return total;
	}
	
	public int doFishing() {
		actions -= 1;
		currentMoney += 30;
		numBait -= 1;
		return 30;
	}
	
	public void useTimeMachine() {
		daysLeft += 1;
	}
	
	public int generateFinalScore() {
		return (int) (currentMoney*0.8+farm.getAnimalsList().size()*100+farm.getCropsList().size()*20);
	}
	

	public int nextDay(App app) {
		int dailyBonusAnimal = 0;
		for(int i=0; i<farm.getAnimalsList().size();i++) {
			dailyBonusAnimal += farm.getAnimalsList().get(i).getDailyGeneratedMoney();
		}
		int temp = dailyBonusAnimal;
		currentMoney += dailyBonusAnimal;
		dailyBonusAnimal = 0;
		daysLeft -= 1;
		actions = 2;
		event = new RandomEvent(this);
		for(int i=0; i<farm.getCropsList().size();i++) {
			if(farm.getCropsList().get(i).daysToHarvest!=0) {
				farm.getCropsList().get(i).daysToHarvest -= 1;
				farm.getCropsList().get(i).setWasTendedToday(false);
			}
		}
		
		for(int i=0; i<farm.getAnimalsList().size();i++) {
			Animal animal = farm.getAnimalsList().get(i);
			animal.setFedStatus(false);
			animal.decreaseHappinessBy(10);
			animal.decreaseHealthBy(10);
			animal.updateDailyGeneratedMoney();
		}
		return temp;
		
	}
	
	public String getName() {
		return farmerName;
	}
	
	public int getActionsLeft() {
		return actions;
	}
	public int getAge() {
		return farmerAge;
	}
	public Date getStartDate() {
		return startDate;
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
	
	public void increaseNumHay() {
		numHay += 1;
	}
	
	public void increaseNumBait() {
		numBait += 1;
	}
	
	public void increaseNumFertilizer() {
		numFertilizer += 1;
	}
	
	
	
	public int getDaysLeft() {
		return daysLeft;
	}
	
	public int getStartingDays() {
		return startingDays;
	}

	
	public int getCurrentMoney(){
		return currentMoney;
	}
	
	
	public void reduceCurrentMoney(int money) {
		currentMoney -= money;
	}
	
	public void increaseCurrentMoney(int money) {
		currentMoney += money;
	}
	
	public Farm getFarm() {
		return farm;
	}
	
	public String getRandomEventMessage() {
		return event.getEventInfo();
	}
	
	public int getDailyBonus() {
		int total = 0;
		for (Animal animal : farm.getAnimalsList()) {
			total += animal.getDailyGeneratedMoney();
		}
		return total;
	}
	
	public void setStartDate() {
		startDate = new Date();
	}
	
	public void setLastActiveTime(Date date) {
		lastActiveTime = date;
	}
	
	public Date getLastActiveTime() {
		return this.lastActiveTime;
	}
	
	public void resetAnimalsList(ArrayList<Animal> list) {
		farm.animalsList = list;
	}
	
	public void resetCropsList(ArrayList<Crop> list) {
		farm.cropsList = list;
	}
	
	
}
