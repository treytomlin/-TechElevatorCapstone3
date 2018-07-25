package com.techelevator.npgeek;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
 
public class Survey  {
	
	private int id; 
	private String parkCode;
	@NotBlank(message="*")
	@Email(message="email address is required")
	private String emailAddress; 
	private String state; 
	@NotBlank(message="you must choose an activity level")
	private String activityLevel;
	private String parkName; 
	private String getParkCodeLowerCase; 
	private int surveyCount; 
	
	public int getSurveyCount() {
		return surveyCount;
	}

	public void setSurveyCount(int surveyCount) {
		this.surveyCount = surveyCount;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkname) {
		this.parkName = parkname;
	}
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkcode) {
		this.parkCode = parkcode;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	
	public String getParkCodeLowerCase() {
		this.getParkCodeLowerCase = this.parkCode.toLowerCase(); 
		return getParkCodeLowerCase; 
	}
}
