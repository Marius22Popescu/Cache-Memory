package Cache;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

//This method will test the CacheMemory file 
class TestCache {
		//Create the cache
		Source s = new FileSource();
		CacheMemory cache = new CacheMemory(3, s);
		
	@Test	//This method will test if was inserted in the cache
	void testPutObject() {				
				cache.getObject("1");				
				Object expected = cache.getObject("1"); //Create the expected variable
				//Create the actual assertion
				assertEquals(expected, "apple");	
	}
	@Test	//This method is testing if the display miss method is working proper
	void testDisplayMiss() {				
				cache.getObject("1");
				cache.getObject("2");
				cache.getObject("1");
				cache.getObject("3");
				Object expected = cache.displayMissRatio(); //Create the expected variable
				//Create the actual assertion
				assertEquals(expected, 0.75);	
	}
	@Test	//This method is testing if the display hit method is working proper
	void testDisplayHit() {				
		cache.getObject("1");
		cache.getObject("2");
		cache.getObject("1");
		cache.getObject("3");
				Object expected = cache.displayHitRatio(); //Create the expected variable
				//Create the actual assertion
				assertEquals(expected, 0.25);	
	}
	@Test	//This test case is testing the contain method
	void testContain1() {				
				cache.getObject("1");				
				Object expected = cache.contain("1"); //Create the expected variable
				//Create the actual assertion
				assertEquals(expected, true);	
	}
	@Test	//This test case is testing the contain method
	void testContain2() {				
		cache.getObject("1");				
		Object expected = cache.contain("2"); //Create the expected variable
		//Create the actual assertion
		assertEquals(expected, false);	
}
	@Test	//This will test if the cache is deleting the last element if there is no more space in the cache
	void testIfDelletingLast() {				
			cache.getObject("1");
			cache.getObject("2");
			cache.getObject("3");
			cache.getObject("4");
			Object expected = cache.contain("1"); //Create the expected variable
			//Create the actual assertion
			assertEquals(expected, false);	
	}
	@Test	//This test case will test the clearing method
	void testIfClearCache1() {				
				cache.getObject("1");
				cache.getObject("2");
				cache.getObject("3");
				cache.clearCash();
				Object expected = cache.contain("1"); //Create the expected variable
				//Create the actual assertion
				assertEquals(expected, false);	
	}
	@Test	//This test case will test the clearing method
	void testIfClearCache2() {				
				cache.getObject("1");
				cache.getObject("2");
				cache.getObject("3");
				cache.clearCash();
				Object expected = cache.contain("2"); //Create the expected variable
				//Create the actual assertion
				assertEquals(expected, false);	
	}
	@Test	//This test case will test the clearing method
	void testIfClearCache3() {				
				cache.getObject("1");
				cache.getObject("2");
				cache.getObject("3");
				cache.clearCash();
				Object expected = cache.contain("3"); //Create the expected variable
				//Create the actual assertion
				assertEquals(expected, false);	
	}	
}