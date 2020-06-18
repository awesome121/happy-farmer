package main;

import java.io.Serializable;

/*Abstract class Farm
 * All the implementation is in package crops
 * Contains crops and animals information
 */

import java.util.ArrayList;

public abstract class Farm implements Serializable{
	protected String farmName;
	protected String farmType;
	protected int maxCrops;
	protected int maxAnimals;
	protected ArrayList<Crop> cropsList;
	protected ArrayList<Animal> animalsList;
	
	public Farm() {
		
	}
	
	public String getFarmName() {
		return farmName;
	}
	
	public String getfarmType() {
		return farmType;
	}
	
	
	public int getMaxCrops() {
		return maxCrops;
	}
	
	public int getMaxAnimals() {
		return maxAnimals;
	}
	
	public ArrayList<Crop> getCropsList(){
		return cropsList;
	}
	
	public ArrayList<Animal> getAnimalsList(){
		return animalsList;
	}
	
}
