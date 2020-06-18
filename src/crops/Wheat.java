package crops;

import main.Crop;

public class Wheat extends Crop{

	public Wheat() {
		type = "Wheat";
		status = "Healthy";
		purchasingPrice = 10;
		sellingPrice = 20;
		daysToHarvest = 2;
		wasTendedToday = false;
	}
	
}
