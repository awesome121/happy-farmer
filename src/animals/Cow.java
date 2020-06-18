package animals;

import main.Animal;

public class Cow extends Animal{
	
	public Cow() {
		type = "Cow";
		health = 100; // maximum 100%
		happiness = 60; //maximum 100%
		dailyGeneratedMoney = (int) ((int) health * 0.3 + (int)happiness * 0.3);
		purchasingPrice = 80;
		fedToday = false;
	}
	
	
	public void updateDailyGeneratedMoney() {
		dailyGeneratedMoney = (int) ((int) health * 0.3 + (int)happiness * 0.3);
	}
}
