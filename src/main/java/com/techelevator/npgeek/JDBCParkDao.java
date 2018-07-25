package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCParkDao implements ParkDAO{
	
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
	public JDBCParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	

	@Override
	public Park findParkByParkCode(String parkCode) {
		Park park = new Park(); 
		
		String sqlParkSearch = "SELECT * FROM park WHERE parkcode= ?"; 
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlParkSearch, parkCode); 
		
		while(results.next()) {
			 park = mapRowToPark(results); 
		}
		return park;
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList();
		String sqlParkSearch = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlParkSearch);
		
		while(results.next()){
			allParks.add(mapRowToPark(results));
		}
		return allParks;
	}
	

	
	private Park mapRowToPark(SqlRowSet results) {
		Park allParks = new Park();
		allParks.setParkCode(results.getString("parkcode"));
		allParks.setName(results.getString("parkname"));
		allParks.setState(results.getString("state")); // must match datatype in database
		allParks.setAcreage(results.getInt("acreage"));
		allParks.setElevationInFeet(results.getInt("elevationinfeet"));
		allParks.setMilesOfTrail(results.getFloat("milesoftrail"));
		allParks.setNumberOfCampsites(results.getInt("numberofcampsites"));
		allParks.setClimate(results.getString("climate"));
		allParks.setYearFounded(results.getInt("yearfounded"));
		allParks.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		allParks.setInspirationalQuote(results.getString("inspirationalquote"));
		allParks.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
		allParks.setParkDescription(results.getString("parkdescription"));
		allParks.setEntryFee(results.getInt("entryfee"));
		allParks.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		
		return allParks;
	}


}
