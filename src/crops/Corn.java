package crops;

import main.Crop;

public class Corn extends Crop{

	public Corn() {
		type = "Corn";
		status = "Healthy";
		purchasingPrice = 10;
		sellingPrice = 20;
		daysToHarvest = 3;
		wasTendedToday = false;
	}
	
}
