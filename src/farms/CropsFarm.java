package farms;

import java.util.ArrayList;

import main.Animal;
import main.Crop;
import main.Farm;

//import main.Crop;
public class CropsFarm extends Farm{
	public CropsFarm(String inputFarmName) {
		farmName = inputFarmName;
		farmType = "CropsFarm";
//		bonus = 
		maxCrops = 30;
		maxAnimals = 2;
		cropsList = new ArrayList<Crop>();
		animalsList = new ArrayList<Animal>();
		//daysToHarvest -= 1;
	}
}
