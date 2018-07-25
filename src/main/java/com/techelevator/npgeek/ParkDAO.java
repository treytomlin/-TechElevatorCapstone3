package com.techelevator.npgeek;

import java.util.List;

public interface ParkDAO {
	
	public Park findParkByParkCode(String parkCode);  
	public List<Park> getAllParks(); 
}
