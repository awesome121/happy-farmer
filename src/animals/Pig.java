package animals;

import main.Animal;

public class Pig extends Animal{
	public Pig() {
		type = "Pig";
		health = 100; // maximum 100%
		happiness = 60; //maximum 100%
		dailyGeneratedMoney = (int) ((int) health * 0.1 + (int)happiness * 0.1);
		purchasingPrice = 45;
		fedToday = false;
	}
	
	public void updateDailyGeneratedMoney() {
		dailyGeneratedMoney = (int) ((int) health * 0.1 + (int)happiness * 0.1);
	}
	
}
