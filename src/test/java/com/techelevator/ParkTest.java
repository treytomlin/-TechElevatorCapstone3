package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.Park;


public class ParkTest {
	private Park park; 
	
	@Before
	public void setup() {
		park = new Park();
		
		park.setParkCode("OONP");
		park.setName("Ohio's Only National Park");
		park.setState("Ohio");
		park.setAcreage(420000);
		park.setElevationInFeet(8080);
		park.setMilesOfTrail(9000);
		park.setNumberOfCampsites(666);
		park.setClimate("Hot As Balls");
		park.setYearFounded(1776);
		park.setAnnualVisitorCount(1234567);
		park.setInspirationalQuote("Look, Ohio Ain't That Bad!");
		park.setInspirationalQuoteSource("Some Guy");
		park.setParkDescription("Smack Dab in da middle of Ohio lies Ohio's Only National Park!");
		park.setEntryFee(1);
		park.setNumberOfAnimalSpecies(456);			
	}
	@Test
	public void parkCodeLowerCaseAccuracy() {
		//Act
		park.getParkCodeLowerCase();
		//Assert
		Assert.assertEquals("oonp", park.getParkCodeLowerCase());
	}
	@Test
	public void parkCodeAccuracy() {
		//Act
		park.getParkCode();
		//Assert
		Assert.assertEquals("OONP", park.getParkCode());	
	}
	@Test
	public void parkNameAccuracy() {
		//Act
		park.getName();
		//Assert
		Assert.assertEquals("Ohio's Only National Park", park.getName());
	}
	@Test
	public void parkStateAccuracy() {
		//Act
		park.getState();
		//Assert
		Assert.assertEquals("Ohio", park.getState());
	}
	@Test
	public void parkAcreageAccuracy() {
		//Act
		park.getAcreage();
		//Assert
		Assert.assertEquals(420000, park.getAcreage());
	}
	@Test
	public void parkElevationAccuracy() {
		//Act
		park.getElevationInFeet();
		//Assert
		Assert.assertEquals(8080, park.getElevationInFeet());
	}
	@Test
	public void parkMilesOfTrailAccuracy() {
		//Act
		park.getMilesOfTrail();
		//Assert
		Assert.assertEquals(9000, park.getMilesOfTrail(), 0);
	}
	@Test
	public void parkCampsiteNumberAccuracy() {
		//Act
		park.getNumberOfCampsites();
		//Assert
		Assert.assertEquals(666, park.getNumberOfCampsites());
	}
	@Test
	public void parkClimateAccuracy() {
		//Act
		park.getClimate();
		//Assert
		Assert.assertEquals("Hot As Balls", park.getClimate());
	}
	@Test
	public void parkFoundedAccuracy() {
		//Act
		park.getYearFounded();
		//Assert
		Assert.assertEquals(1776, park.getYearFounded());
	}
	@Test
	public void parkVisitorAccuracy() {
		//Act
		park.getAnnualVisitorCount();
		//Assert
		Assert.assertEquals(1234567, park.getAnnualVisitorCount());
	}
	@Test
	public void parkQuoteAccuracy() {
		//Act
		park.getInspirationalQuote();
		//Assert
		Assert.assertEquals("Look, Ohio Ain't That Bad!", park.getInspirationalQuote());
	}
	@Test
	public void parkQuoteSourceAccuracy() {
		//Act
		park.getInspirationalQuoteSource();
		//Assert
		Assert.assertEquals("Some Guy", park.getInspirationalQuoteSource());
	}
	@Test
	public void parkDescriptionAccuracy() {
		//Act
		park.getParkDescription();
		//Assert
		Assert.assertEquals("Smack Dab in da middle of Ohio lies Ohio's Only National Park!", park.getParkDescription());	
	}
	@Test
	public void parkFeeAccuracy() {
		//Act
		park.getEntryFee();
		//Assert
		Assert.assertEquals(1, park.getEntryFee());
	}
	@Test
	public void parkSpeciesAccuracy() {
		//Act
		park.getNumberOfAnimalSpecies();
		//Assert
		Assert.assertEquals(456, park.getNumberOfAnimalSpecies());
	}
	
}
