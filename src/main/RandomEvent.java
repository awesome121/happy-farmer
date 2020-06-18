package main;

/*
 * Class RandomEvent  generates random event in game
 * A event message will be kept after generating the event
 * 
 * 
 */


import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;


public class RandomEvent {
	String message;
	
	
	public RandomEvent(Farmer farmer) {
		Random rand = new Random();
		int evetIndex = rand.nextInt(10);// 100% chance in total
		Farm farm = farmer.getFarm();
		//County fair   
		if(evetIndex == 0) {	// 10% chance
			if(farm.getCropsList().size()!=0 | farm.getAnimalsList().size()!=0) {
				int money = farm.getAnimalsList().size()*10 + farm.getCropsList().size()*5;
				message = "Good Job! You won the top award at the anumal county fair!";
				farmer.increaseCurrentMoney(money);
			}
		}
		//Broken fence
		else if (evetIndex == 1 | evetIndex == 2 | evetIndex == 3) {	//30% chance but it won't if there is good management
			if (farm.getAnimalsList().size() != 0) {
				ArrayList<Animal> animalList = new ArrayList<Animal>();
				int count = rand.nextInt(3) + 1;
				int left = count;
				for (int i = 0; i < farm.getAnimalsList().size(); i++) {
					Animal animal = farm.getAnimalsList().get(i);
					if (left > 0) {
						if (animal.fedToday | (animal.getHealth() >= 30 & animal.getHappiness() >= 50)) {
							animalList.add(animal);
						} else
							left -= 1;
					} else {
						animalList.add(animal);
					}
				}
				if (count != left) {
					for(Animal animal : animalList) {
						animal.decreaseHappinessBy(40);
					}
					message = "There is a broken fence! Check out your barn!";
					farmer.resetAnimalsList(animalList);
				}
			}
		}
		//Drought
		else if(evetIndex == 4) {  // 10% chance
			if(farm.getCropsList().size()!=0) {
				ArrayList<Crop> cropList = new ArrayList<Crop>();
				int count = (int) farm.getCropsList().size()/2 ;
				int left = count;
				for (int i = 0; i < farm.getCropsList().size(); i++) {
					Crop crop = farm.getCropsList().get(i);
					if (left > 0)
						left -= 1;
					else 
						cropList.add(crop);
					message = "Your wells have dried up! Check out your farm land!";
					farmer.resetCropsList(cropList);
				}
			}
		}
	}
	
	
	
		public String getEventInfo() {
			return message;
		}
		

}
