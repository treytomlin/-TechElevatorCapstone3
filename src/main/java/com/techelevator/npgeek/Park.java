package com.techelevator.npgeek;

import java.util.List;

public class Park implements ParkDAO{
	
	private String parkCode; 
	private String name; 
	private String state; 
	private int acreage; 
	private int elevationInFeet; 
	private float milesOfTrail; 
	private int numberOfCampsites; 
	private String climate; 
	private int yearFounded; 
	private int annualVisitorCount; 
	private String inspirationalQuote; 
	private String inspirationalQuoteSource; 
	private String parkDescription; 
	private int entryFee; 
	private int numberOfAnimalSpecies;
	private String getParkCodeLowerCase;

	
	public Park findParkByParkCode(String parkCode) {
		return null;
	}
	
	public List<Park> getAllParks() {
		return null;
	}

	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAcreage() {
		return acreage;
	}
	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}
	public int getElevationInFeet() {
		return elevationInFeet;
	}
	public void setElevationInFeet(int elevationInFeet) {
		this.elevationInFeet = elevationInFeet;
	}
	public float getMilesOfTrail() {
		return milesOfTrail;
	}
	public void setMilesOfTrail(float milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}
	public int getNumberOfCampsites() {
		return numberOfCampsites;
	}
	public void setNumberOfCampsites(int numberOfCampsites) {
		this.numberOfCampsites = numberOfCampsites;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public int getYearFounded() {
		return yearFounded;
	}
	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}
	public int getAnnualVisitorCount() {
		return annualVisitorCount;
	}
	public void setAnnualVisitorCount(int annualVisitorCount) {
		this.annualVisitorCount = annualVisitorCount;
	}
	public String getInspirationalQuote() {
		return inspirationalQuote;
	}
	public void setInspirationalQuote(String inspirationalQuote) {
		this.inspirationalQuote = inspirationalQuote;
	}
	public String getInspirationalQuoteSource() {
		return inspirationalQuoteSource;
	}
	public void setInspirationalQuoteSource(String inspirationalQuoteSource) {
		this.inspirationalQuoteSource = inspirationalQuoteSource;
	}
	public String getParkDescription() {
		return parkDescription;
	}
	public void setParkDescription(String parkDescription) {
		this.parkDescription = parkDescription;
	}
	public int getEntryFee() {
		return entryFee;
	}
	public void setEntryFee(int entryFee) {
		this.entryFee = entryFee;
	}
	public int getNumberOfAnimalSpecies() {
		return numberOfAnimalSpecies;
	}
	public void setNumberOfAnimalSpecies(int numberOfAnimalSpecies) {
		this.numberOfAnimalSpecies = numberOfAnimalSpecies;
	}
	
	public String getParkCodeLowerCase() {
		this.getParkCodeLowerCase = this.parkCode.toLowerCase(); 
		return getParkCodeLowerCase; 
	}
	
}