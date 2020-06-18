package unitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import crops.Corn;
import crops.Oats;
import crops.Potato;
import crops.Rice;
import crops.Soybean;
import crops.Wheat;

public class CropClassTest {
	Corn corn;
	Oats oats;
	Potato potato;
	Rice rice;
	Soybean soybean;
	Wheat wheat;
	@Before
	public void setUp() throws Exception {
		corn = new Corn();
		oats = new Oats();
		potato = new Potato();
		rice = new Rice();
		soybean = new Soybean();
		wheat = new Wheat();
	}

	@After
	public void tearDown() throws Exception {
		corn = null;
		oats = null;
		potato = null;
		rice = null;
		soybean = null;
		wheat = null;
	}

	@Test
	public void test() {
		//Initial properties of a new corn
		assertEquals("Corn", corn.getType());        
		assertEquals("Healthy", corn.getStatus());       
		assertEquals(4, corn.getHarvestDays());
		assertEquals(10, corn.getPurchasingPrice());
		assertEquals(20, corn.getSellingPrice());
		assertEquals(false, corn.getTendedStatus());
		//Initial properties of a new oats
		assertEquals("Oats", oats.getType());        
		assertEquals("Healthy", oats.getStatus());       
		assertEquals(2, oats.getHarvestDays());
		assertEquals(5, oats.getPurchasingPrice());
		assertEquals(9, oats.getSellingPrice());
		assertEquals(false, oats.getTendedStatus());
		
		//Initial properties of a new potato
		assertEquals("Potato", potato.getType());        
		assertEquals("Healthy", potato.getStatus());       
		assertEquals(5, potato.getHarvestDays());
		assertEquals(20, potato.getPurchasingPrice());
		assertEquals(50, potato.getSellingPrice());
		assertEquals(false, potato.getTendedStatus());
		
		//Initial properties of a new rice
		assertEquals("Rice", rice.getType());        
		assertEquals("Healthy", rice.getStatus());       
		assertEquals(3, rice.getHarvestDays());
		assertEquals(5, rice.getPurchasingPrice());
		assertEquals(10, rice.getSellingPrice());
		assertEquals(false, rice.getTendedStatus());
		
		//Initial properties of a new soybean
		assertEquals("Soybean", soybean.getType());        
		assertEquals("Healthy", soybean.getStatus());       
		assertEquals(5, soybean.getHarvestDays());
		assertEquals(15, soybean.getPurchasingPrice());
		assertEquals(30, soybean.getSellingPrice());
		assertEquals(false, soybean.getTendedStatus());
		
		//Initial properties of a new wheat
		assertEquals("Wheat", wheat.getType());        
		assertEquals("Healthy", wheat.getStatus());       
		assertEquals(3, wheat.getHarvestDays());
		assertEquals(10, wheat.getPurchasingPrice());
		assertEquals(20, wheat.getSellingPrice());
		assertEquals(false, wheat.getTendedStatus());
	}
}
