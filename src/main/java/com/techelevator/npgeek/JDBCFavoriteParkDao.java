package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCFavoriteParkDao implements FavoriteParkDAO {
	
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
	public JDBCFavoriteParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	@Override
	public List<FavoritePark> getFavoriteParks() {
		List<FavoritePark> allFavoriteParks = new ArrayList<>(); 
		String sqlSearchAllFavoriteParks = "SELECT COUNT(park.parkname), park.parkname, park.parkcode FROM survey_result " + 
											"JOIN PARK ON survey_result.parkcode = park.parkcode " + 
											"GROUP BY park.parkname, park.parkcode ORDER BY COUNT DESC"; 
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchAllFavoriteParks);
		while(results.next()) {
			FavoritePark park = new FavoritePark(); 
			park.setCount(results.getInt("count"));
			park.setParkName(results.getString("parkname"));
			park.setParkCode(results.getString("parkcode"));
			allFavoriteParks.add(park); 
		}
		return allFavoriteParks;
	}

}
