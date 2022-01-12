package com.tastekorea.webapp.guide.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tastekorea.webapp.guide.domain.ForeignLanguage;

@Repository
public class ForeignLanguageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * 
	 * @return
	 */
	public List<ForeignLanguage> findAll(){
		String sql = "SELECT * FROM ForeignLanguage";
		return jdbcTemplate.query(sql, new ForeignLanguageRowMapper());
	}
}
