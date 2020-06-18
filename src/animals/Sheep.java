package animals;

import main.Animal;

public class Sheep extends Animal{
	public Sheep() {
		type = "Sheep";
		health = 100; // maximum 100%
		happiness = 60; //maximum 100%
		dailyGeneratedMoney = (int) ((int) health * 0.2 + (int)happiness * 0.2);
		purchasingPrice = 60;
		fedToday = false;
	}
	
	public void updateDailyGeneratedMoney() {
		dailyGeneratedMoney = (int) ((int) health * 0.2 + (int)happiness * 0.2);
	}
}
