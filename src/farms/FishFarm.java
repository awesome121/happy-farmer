package farms;

import java.util.ArrayList;

import main.Animal;
import main.Crop;
import main.Farm;

//import main.Fish;
public class FishFarm extends Farm{
	public FishFarm(String inputFarmName) {
		farmName = inputFarmName;
		farmType = "FishFarm";
		maxCrops = 10;
		maxAnimals = 2;
		cropsList = new ArrayList<Crop>();
		animalsList = new ArrayList<Animal>();
		//Can do Fishing;
	}
}
