package main;

import java.io.Serializable;

/*Abstract class Animal
 * All the implementation is in package crops
 * 
 */

public abstract class Animal implements Serializable {
	protected String type;
	protected int health; // maximum 100%
	protected int happiness; //maximum 100%
	protected int dailyGeneratedMoney;
	protected int purchasingPrice;
	protected boolean fedToday;//fedToday today
	
	public Animal() {}
	
	public String getType() {
		return type;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getHappiness() {
		return happiness;
	}
	
	public int getDailyGeneratedMoney() {
		return dailyGeneratedMoney;
	}
	
	public int getPurchasingPrice() {
		return purchasingPrice;
	}
	
	public boolean getFedStatus() {
		return fedToday;
	}
	
	public void setFedStatus(boolean status) {
		fedToday = status;
	}
	
	public void increaseHealthBy(int num) {
		if (health+num>100)
			health = 100;
		else
			health += num;
	}
	
	public void decreaseHealthBy(int num) {
		if(health-num<=0) 
			health = 0;
		else
			health -= num;
	}
	
	public void increaseHappinessBy(int num) {
		if(happiness+num>100)
			happiness = 100;
		else
			happiness += num;
	}
	
	public void decreaseHappinessBy(int num) {
		if(happiness-num<=0) 
			happiness = 0;
		else
			happiness -= num;
	}
	
	public void updateDailyGeneratedMoney() {
		
	}

	
}