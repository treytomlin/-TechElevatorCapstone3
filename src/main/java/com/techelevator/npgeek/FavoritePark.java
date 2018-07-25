package com.techelevator.npgeek;

public class FavoritePark {

	private int count; 
	private String parkName;
	private String parkCode; 
	private String parkCodeLowerCase; 
	 
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	} 
	
	public String getParkCodeLowerCase() {
		this.parkCodeLowerCase = this.parkCode.toLowerCase(); 
		return parkCodeLowerCase; 
	}
}
