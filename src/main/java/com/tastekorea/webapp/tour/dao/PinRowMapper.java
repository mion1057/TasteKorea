package com.tastekorea.webapp.tour.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.guide.domain.Companion;
import com.tastekorea.webapp.tour.domain.Pin;

public class PinRowMapper implements RowMapper<Pin> {

	@Override
	public Pin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pin pin = new Pin();
		 pin.setId(rs.getLong("id"));
	     pin.setCompanion(new Companion(rs.getLong("companionId")));
	     pin.setTitle(rs.getString("title"));
	     pin.setPhoto(rs.getString("photo"));
	     pin.setPrice(rs.getDouble("price"));
	     pin.setDuration(rs.getDouble("duration"));
	     pin.setLocation(rs.getString("location"));
	     pin.setDetails(rs.getString("details"));
	     
		return pin;
	}

}
