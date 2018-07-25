package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCForecastDao implements ForecastDAO {
	
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
	public JDBCForecastDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	@Override
	public List <Forecast> getForecastByParkCode(String parkCode) {
		List <Forecast> forecast = new ArrayList(); 
		
		String forecastSqlSearch = "SELECT * FROM weather WHERE parkcode = ?"; 
		SqlRowSet results = jdbcTemplate.queryForRowSet(forecastSqlSearch, parkCode); 
		
		while(results.next()) {
			forecast.add(mapRowToForecast(results)); 
		}
		return forecast;
	}
	
	private Forecast mapRowToForecast(SqlRowSet results) {
		Forecast forecast = new Forecast(); 
		forecast.setParkCode(results.getString("parkcode"));
		forecast.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		forecast.setLowTemp(results.getInt("low"));
		forecast.setHighTemp(results.getInt("high"));
		forecast.setForecast(results.getString("forecast"));
		
		return forecast; 
	}

	
	public String getWeatherMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	

	


	

	
	


	}

