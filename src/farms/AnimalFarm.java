package farms;

import java.util.ArrayList;

import main.Animal;
import main.Crop;
import main.Farm;

//import main.animals;
public class AnimalFarm extends Farm {
	public AnimalFarm(String inputFarmName){
		farmName = inputFarmName;
		farmType = "AnimalFarm";
		maxCrops = 10;
		maxAnimals = 7;
		cropsList = new ArrayList<Crop>();
		animalsList = new ArrayList<Animal>();
	}
}