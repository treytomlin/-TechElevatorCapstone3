package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCSurveyDAO implements SurveyDAO{
	
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	@Override
	public void saveSurvey(Survey newSurvey) {
		Integer id = getNextId(); 
		String sqlInsertSurvey = "INSERT INTO survey_result (surveyid, parkcode, emailaddress, state, activitylevel) " + 
								 "VALUES(?, ?, ?, ?, ?)";  
		jdbcTemplate.update(sqlInsertSurvey, id, newSurvey.getParkCode(),
												 newSurvey.getEmailAddress(),
												 newSurvey.getState(),
												 newSurvey.getActivityLevel()); 	
		newSurvey.setId(id);
	}
	
	private int getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('serial')"; 
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Integer id = null; 
		if(results.next()) {
			id = results.getInt(1); 
		} else {
			throw new RuntimeException("Something strange happened"); 
		}
		return id; 
	}

	@Override
	public List<Survey> getAllSurveys() {
		List<Survey> allSurveys = new ArrayList<>(); 
		String sqlSearchAllSurveys = "SELECT * FROM survey_result"; 
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchAllSurveys); 
		while(results.next()) {
			Survey survey = new Survey(); 
			survey.setId(results.getInt("surveyid"));
			survey.setParkCode(results.getString("parkcode"));
			survey.setEmailAddress(results.getString("emailaddress"));
			survey.setState(results.getString("state"));
			survey.setActivityLevel(results.getString("activitylevel"));
			allSurveys.add(survey); 
		}
		return allSurveys;
	}

}
