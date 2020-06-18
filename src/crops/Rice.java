package crops;

import main.Crop;

public class Rice extends Crop{

	public Rice() {
		type = "Rice";
		status = "Healthy";
		purchasingPrice = 5;
		sellingPrice = 10;
		daysToHarvest = 2;
		wasTendedToday = false;
	}
	
}
