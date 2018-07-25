package com.techelevator.npgeek;

public class Forecast {

	private String parkCode; 
	private int fiveDayForecastValue; 
	private String forecast; 
	private String weatherMessage;
	private int lowTemp; 
	private int highTemp;
	
	
	public int getLowTemp() {
		return lowTemp;
	}
	public int getHighTemp() {
		return highTemp;
	}
	public void setLowTemp(int lowTemp) {
		this.lowTemp = lowTemp;
	}
	public void setHighTemp(int highTemp) {
		this.highTemp = highTemp;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

public String getWeatherMessage() {
		
		if(forecast.equals("snow")){
			if(highTemp < 20 || lowTemp < 20){
				weatherMessage = "Pack snowshoes and beware exposure to frigid temperatures.";
			}else if( highTemp - lowTemp > 20){
				weatherMessage = "Pack snowshoes and wear breathable layers.";
			}else if( (highTemp - lowTemp > 20)&& highTemp > 75){
					weatherMessage = "Pack snowshoes,wear breathable layers and bring an extra gallon of water.";
			}else if(highTemp > 75){
				weatherMessage = "Pack snowshoes and bring an extra gallon of water.";
			} else {
				weatherMessage = "Pack snowshoes";
			}
		} else if (forecast.equals("rain")){
			if(highTemp < 20 || lowTemp < 20){
				weatherMessage = "Pack rain gear and waterproof shoes. Beware of exposure to frigid temperatures.";
			}else if( highTemp - lowTemp > 20){
				weatherMessage = "Pack rain gear and waterproof shoes. Wear breathable layers.";
			}else if( (highTemp - lowTemp > 20) && highTemp > 75){
					weatherMessage = "Pack rain gear,waterproof shoes, wear breathable layers and bring an extra gallon of water.";
			}else if(highTemp > 75){
				weatherMessage = "Pack rain gear,waterproof shoes and bring an extra gallon of water.";
			}else {
				weatherMessage = "Pack rain gear and waterproof shoes.";
			}
		}else if (forecast.equals("thunderstorms")){
			if(highTemp < 20 || lowTemp < 20){
				weatherMessage = "Seek shelter and avoid hiking on exposed ridges. Beware of exposure to frigid temperatures.";
			}else if( highTemp - lowTemp > 20){
				weatherMessage = "Seek shelter and avoid hiking on exposed ridges. Wear breathable layers.";
			}else if( (highTemp - lowTemp > 20) && highTemp > 75){
					weatherMessage = "Seek shelter and avoid hiking on exposed ridges. Wear breathble layers and bring an extra gallon of water.";
			}else if(highTemp > 75){
				weatherMessage = "Seek shelter and avoid hiking on exposed ridges. Bring an extra gallon of water.";
			}else {
				weatherMessage = "Seek shelter and avoid hiking on exposed ridges";
			}	
		}else if (forecast.equals("sunny")){
			if(highTemp < 20 || lowTemp < 20){
				weatherMessage = "Pack sunblock. Beware of exposure to frigid temperatures.";
			}else if( highTemp - lowTemp > 20){
				weatherMessage = "Pack sunblock. Wear breathable layers.";
			}else if( (highTemp - lowTemp > 20)&& highTemp > 75){
					weatherMessage = "Pack sunblock, wear breathable layers and bring an extra gallon of water.";
			}else if(highTemp > 75){
				weatherMessage = "Pack sunblock and bring an extra gallon of water.";
			}else {
				weatherMessage = "Pack sunblock";
			}	
		} else {
			if(highTemp < 20 || lowTemp < 20){
				weatherMessage = "Beware of exposure to frigid temperatures.";
			}else if( highTemp - lowTemp > 20){
				weatherMessage = "Wear breathable layers.";
			}else if( (highTemp - lowTemp > 20)&& highTemp > 75){
					weatherMessage = "Wear breathable layers and bring an extra gallon of water.";
			}else if(highTemp > 75){
				weatherMessage = "Bring an extra gallon of water.";
			}
		}
		return weatherMessage;
	}
	public void setWeatherMessage(String weatherMessage) {
		this.weatherMessage = weatherMessage;
	}
}
