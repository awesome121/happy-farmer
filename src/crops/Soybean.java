package crops;

import main.Crop;

public class Soybean extends Crop{

	public Soybean() {
		type = "Soybean";
		status = "Healthy";
		purchasingPrice = 15;
		sellingPrice = 30;
		daysToHarvest = 3;
		wasTendedToday = false;
	}
	
}
