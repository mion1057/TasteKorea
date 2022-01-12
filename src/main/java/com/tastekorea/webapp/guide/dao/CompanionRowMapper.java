package com.tastekorea.webapp.guide.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.guide.domain.Companion;

public class CompanionRowMapper implements RowMapper<Companion> {

	@Override
	public Companion mapRow(ResultSet rs, int rowNum) throws SQLException {
		Companion companion = new Companion();
		companion.setId(rs.getLong("id"));
		companion.setEmail(rs.getString("email"));
		companion.setPasswd(rs.getString("passwd"));
		companion.setName(rs.getString("name"));
		companion.setPhone(rs.getString("phone"));
		companion.setSsn(rs.getString("ssn"));
		companion.setSex(rs.getString("sex").charAt(0));
		companion.setPhoto(rs.getString("photo"));
		companion.setIntroduction(rs.getString("introduction"));
		companion.setRegion(rs.getString("region"));

		return companion;
	}
	
}