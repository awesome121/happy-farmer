package unitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import animals.*;


public class AnimalClassTest {
	Cow cow;
	Pig pig;
	Sheep sheep;
	

	@Before
	public void setUp() throws Exception {
		cow = new Cow();
		pig = new Pig();
		sheep = new Sheep();
		
	}

	@After
	public void tearDown() throws Exception {
		cow = null;
		pig = null;
		sheep = null;
	}

	@Test
	public void test() {
		//Initial properties of a new cow
		assertEquals("Cow", cow.getType());        
		assertEquals(100, cow.getHealth());       
		assertEquals(25, cow.getDailyGeneratedMoney());
		assertEquals(80, cow.getPurchasingPrice());
		assertEquals(false, cow.getFedStatus());
		//Initial properties of a new pig
		assertEquals("Pig", pig.getType());        
		assertEquals(100, pig.getHealth());       
		assertEquals(20, pig.getDailyGeneratedMoney());
		assertEquals(45, pig.getPurchasingPrice());
		assertEquals(false, pig.getFedStatus());
		
		//Initial properties of a new sheep
		assertEquals("Sheep", sheep.getType());        
		assertEquals(100, sheep.getHealth());       
		assertEquals(35, sheep.getDailyGeneratedMoney());
		assertEquals(60, sheep.getPurchasingPrice());
		assertEquals(false, sheep.getFedStatus());
		
	}

}
