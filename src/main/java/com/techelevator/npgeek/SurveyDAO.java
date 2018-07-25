package com.techelevator.npgeek;

import java.util.List;

public interface SurveyDAO {
	
	public List<Survey> getAllSurveys(); 
	public void saveSurvey(Survey newSurvey); 
}
