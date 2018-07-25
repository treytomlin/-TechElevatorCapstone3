package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.Forecast;


public class ForecastTest {
	
	private Forecast forecast;
	@Before
	public void setup() {
		//Arrange
		forecast = new Forecast();
		forecast.setParkCode("OONP");
		forecast.setForecast("rain");
		forecast.setFiveDayForecastValue(75);
		forecast.setHighTemp(90);
		forecast.setLowTemp(45);		
	}
	@Test
	public void parkCodeAccuracy() {
		//Act
		forecast.getParkCode();
		//Assert
		Assert.assertEquals("OONP", forecast.getParkCode());
	}
	@Test
	public void forecastAccuracy() {
		//Act
		forecast.getForecast();
		//Assert
		Assert.assertEquals("rain", forecast.getForecast());
	}
	@Test
	public void FiveDayAccuracy() {
		//Act
		forecast.getFiveDayForecastValue();
		//Assert
		Assert.assertEquals(75, forecast.getFiveDayForecastValue());
	}
	@Test
	public void highTempAccuracy() {
		//Act
		forecast.getHighTemp();
		//Assert
		Assert.assertEquals(90, forecast.getHighTemp());
	}
	@Test
	public void lowTempAccuracy() {
		//Act
		forecast.getLowTemp();
		//Assert
		Assert.assertEquals(45, forecast.getLowTemp());
	}
	@Test
	public void weatherMessageAccuracy() {
		//Act
		forecast.getWeatherMessage();
		//Assert
		Assert.assertEquals("Pack rain gear and waterproof shoes. Wear breathable layers.", forecast.getWeatherMessage());
	}
	
	

}
