package com.tastekorea.webapp.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.user.domain.Traveler;

public class TravelerRowMapper implements RowMapper<Traveler> {

	@Override
	public Traveler mapRow(ResultSet rs, int rowNum) throws SQLException {
		Traveler traveler = new Traveler();
		traveler.setId(rs.getLong("id"));
		traveler.setEmail(rs.getString("email"));
		traveler.setPasswd(rs.getString("passwd"));
		traveler.setName(rs.getString("name"));
		return traveler;
	}

}
