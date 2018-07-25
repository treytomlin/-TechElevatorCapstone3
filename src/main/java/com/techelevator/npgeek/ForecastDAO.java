package com.techelevator.npgeek;

import java.util.List;

public interface ForecastDAO {
		
	public List <Forecast> getForecastByParkCode(String parkCode); 
}
