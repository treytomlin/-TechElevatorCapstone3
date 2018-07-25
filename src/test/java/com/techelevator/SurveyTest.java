package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.Survey;


public class SurveyTest {
	private Survey survey;
	
	@Before
	public void setup() {
		survey = new Survey();
		survey.setId(310);
		survey.setParkCode("OONP");
		survey.setEmailAddress("trey@apple.com");
		survey.setState("CA");
		survey.setActivityLevel("moderate");
	}
	
	@Test
	public void surveyIdAccuracy() {
		//Act
		survey.getId();
		//Assert
		Assert.assertEquals(310, survey.getId());
	}
	@Test
	public void surveyCodeAccuracy() {
		//Act
		survey.getParkCode();
		//Assert
		Assert.assertEquals("OONP", survey.getParkCode());
	}
	@Test
	public void surveyEmailAccuracy() {
		//Act
		survey.getEmailAddress();
		//Assert
		Assert.assertEquals("trey@apple.com", survey.getEmailAddress());
	}
	@Test
	public void surveyStateAccuracy() {
		//Act 
		survey.getState();
		//Assert
		Assert.assertEquals("CA", survey.getState());
	}
	@Test
	public void surveyActivityLevelAccuracy() {
		//Act
		survey.getActivityLevel();
		//Assert
		Assert.assertEquals("moderate", survey.getActivityLevel());
	}

}
