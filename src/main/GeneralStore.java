package main;

public class GeneralStore {
    public GeneralStore(){
    	
    }
    
    public int getBaitPrice() {
    	return 1;
    }
    
    public int getHayPrice() {
    	return 5;
    }
    
    public int getFertilizer() {
    	return 5;
    }
    public String getAnimalToolTip(String type, int money) {
    	return "<html>" + type + "<br>Daily Generated Money: $ "+ money + " <br>Happiness: 60 <br>Health: 100";
    }
    public String getCropToolTip(String type, int price, int growthDays) {
    	return "<html>" + type + "<br>Selling price: $ "+ price + "<br>Growrth Cycle: " + growthDays + "days";
    }
    public int getSellingPrice(String type) {
    	int price=0;
    	switch (type) {
    	case "Corn":
    		price = 20;
    		break;
    	case "Oats":
    		price = 9;
    		break;
    	case "Potato":
    		price = 50;
    		break;
    	case "Rice":
    		price = 10;
    		break;
    	case "Soybean":
    		price = 30;
    		break;
    	case "Wheat":
    		price = 20;
    		break;
    	}
    	return price;
    }
    
    public int getPurchasingPrice(String type) {
    	int price=0;
    	switch (type) {
    	case "Corn":
    		price = 10;
    		break;
    	case "Oats":
    		price = 5;
    		break;
    	case "Potato":
    		price = 20;
    		break;
    	case "Rice":
    		price = 5;
    		break;
    	case "Soybean":
    		price = 15;
    		break;
    	case "Wheat":
    		price = 10;
    		break;
    	case "Cow":
    		price = 80;
    		break;
    	case "Sheep":
    		price = 60;
    		break;
    	case "Pig":
    		price = 45;
    		break;
    	}
    	return price;
    }
    
    
    public int getGrowthDays(String type) {
    	int days=0;
    	switch (type) {
    	case "Corn":
    		days = 3;
    		break;
    	case "Oats":
    		days = 2;
    		break;
    	case "Potato":
    		days = 4;
    		break;
    	case "Rice":
    		days = 2;
    		break;
    	case "Soybean":
    		days = 3;
    		break;
    	case "Wheat":
    		days = 2;
    		break;
    	}
    	
    	return days;
    }
    
    
    public int getDailyGeneratedMoney(String type) {
    	int money=0;
    	switch (type) {
    	case "Sheep":
    		money = 32;
    		break;
    	case "Cow":
    		money = 48;
    		break;
    	case "Pig":
    		money = 16;
    		break;
    	}
    	
    	return money;
    }
}
