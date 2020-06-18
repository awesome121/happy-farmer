package main;

import java.io.Serializable;

/*Abstract class Crop
 * All the implementation is in package crops
 * 
 */

public abstract class Crop implements Serializable {
	protected String type;
	protected String status;// Healthy/Thirsty
	protected int purchasingPrice;
	protected int sellingPrice;
	protected int daysToHarvest;
	protected boolean wasTendedToday;
	
	public Crop() {}
	
	public String getType() {
		return type;
	}
	
	public String getStatus() {
		return status;
	}
	
	public int getPurchasingPrice() {
		return purchasingPrice;
	}
	
	public int getSellingPrice() {
		return sellingPrice;
	}
	
	public int getHarvestDays(){
		return daysToHarvest;
	}
	
	public boolean getTendedStatus() {
		return wasTendedToday;
	}
	
	public void setStatus(String string) {
		status = string;
	}
	
	public void setTendStatus(boolean bool) {
		wasTendedToday = bool;
	}
	
	public void decreaseHarvestDaysBy(int num){
		if(daysToHarvest-num<0)
			daysToHarvest = 0;
		else
			daysToHarvest -= num;
	}
	
	public void setWasTendedToday(boolean bool) {
		wasTendedToday = bool;
	}
	
}



