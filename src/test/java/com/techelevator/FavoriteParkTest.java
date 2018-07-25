package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.FavoritePark;


public class FavoriteParkTest {
	
	private FavoritePark favPark;
	
	@Before
	public void setup() {
		favPark = new FavoritePark();
		favPark.setCount(20);
		favPark.setParkCode("OONP");
		favPark.setParkName("Ohio's Only National Park");
	}
	
	@Test
	public void favParkCountAccuracy() {
		//Act
		favPark.getCount();
		//Assert
		Assert.assertEquals(20, favPark.getCount());
	}
	@Test
	public void favParkCodeAccuracy() {
		//Act
		favPark.getParkCode();
		//Assert
		Assert.assertEquals("OONP", favPark.getParkCode());
	}
	@Test
	public void favParkName() {
		//Act
		favPark.getParkName();
		//Assert
		Assert.assertEquals("Ohio's Only National Park", favPark.getParkName());
	}

}
