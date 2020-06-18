package farms;

import java.util.ArrayList;

import main.Animal;
import main.Crop;
import main.Farm;


public class StandardFarm extends Farm{
	public StandardFarm(String inputFarmName) {
		farmName = inputFarmName;
		farmType = "StandardFarm";
		maxCrops = 20;
		maxAnimals = 3;
		cropsList = new ArrayList<Crop>();
		animalsList = new ArrayList<Animal>();
	}
}