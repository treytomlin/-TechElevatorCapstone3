package com.techelevator;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.SurveyDAO;

 

public abstract class DAOIntegrationTest {

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	SurveyDAO surveyDao;
	
	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/historygeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections 
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}
	
	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	/* This method provides access to the DataSource for subclasses so that 
	 * they can instantiate a DAO for testing */
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Test
	public void add_survey_to_database() {
		//Arrange
		Survey testSurvey = new Survey();
		testSurvey.setId(360); // might not want to do this
		testSurvey.setParkCode("CVNP");
		testSurvey.setEmailAddress("trey@apple.com");
		testSurvey.setState("CA");
		testSurvey.setActivityLevel("moderate");
		//Act
		surveyDao.saveSurvey(testSurvey);
		//Assert
		Assert.assertEquals(360, testSurvey.getId());
		Assert.assertEquals("CVNP", testSurvey.getParkCode());
		Assert.assertEquals("trey@apple.com", testSurvey.getEmailAddress());
		Assert.assertEquals("CA", testSurvey.getState());
		Assert.assertEquals("moderate", testSurvey.getActivityLevel());
	}
}
