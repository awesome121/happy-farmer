package unitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import farms.*;

public class FarmClassTest {
	StandardFarm standardFarm;
	AnimalFarm animalFarm;
	CropsFarm cropsFarm;
	FishFarm fishFarm;
	

	@Before
	public void setUp() throws Exception {
		String mockName = "Test";
		standardFarm = new StandardFarm(mockName);
		animalFarm = new AnimalFarm(mockName);
		cropsFarm = new CropsFarm(mockName);
		fishFarm = new FishFarm(mockName);
		
		
	}

	@After
	public void tearDown() throws Exception {
		standardFarm = null;
		animalFarm = null;
		cropsFarm = null;
		fishFarm = null;
		
	}

	@Test
	public void test() {
		//initial properties for standard farm
		assertEquals("Test", standardFarm.getFarmName());
		assertEquals("StandardFarm", standardFarm.getfarmType());
//		assertEquals("Test", standardFarm.getBonus());
		assertEquals(20, standardFarm.getMaxCrops());
		assertEquals(3, standardFarm.getMaxAnimals());
		assertEquals(0, standardFarm.getCropsList().size());
		assertEquals(0, standardFarm.getAnimalsList().size());
		
		//initial properties for animal farm
		assertEquals("Test", animalFarm.getFarmName());
		assertEquals("AnimalFarm", animalFarm.getfarmType());
//		assertEquals("Test", animalFarm.getBonus());
		assertEquals(10, animalFarm.getMaxCrops());
		assertEquals(7, animalFarm.getMaxAnimals());
		assertEquals(0, animalFarm.getCropsList().size());
		assertEquals(0, animalFarm.getAnimalsList().size());
		
		//initial properties for crops farm
		assertEquals("Test", cropsFarm.getFarmName());
		assertEquals("CropsFarm", cropsFarm.getfarmType());
//		assertEquals("Test", cropsFarm.getBonus());
		assertEquals(30, cropsFarm.getMaxCrops());
		assertEquals(2, cropsFarm.getMaxAnimals());
		assertEquals(0, cropsFarm.getCropsList().size());
		assertEquals(0, cropsFarm.getAnimalsList().size());
		
		//initial properties for fish farm
		assertEquals("Test", fishFarm.getFarmName());
		assertEquals("FishFarm", fishFarm.getfarmType());
//		assertEquals("Test", fishFarm.getBonus());
		assertEquals(10, fishFarm.getMaxCrops());
		assertEquals(2, fishFarm.getMaxAnimals());
		assertEquals(0, fishFarm.getCropsList().size());
		assertEquals(0, fishFarm.getAnimalsList().size());
	}

}
