package com.tastekorea.webapp.pin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.domain.PinCategory;
import com.tastekorea.webapp.pin.domain.PinInterest;

/**
 * 
 * @author "rohyh"
 *
 */
public class PinInterestRowMapper implements RowMapper<PinInterest> {
	
	/**
	 * 
	 */
	@Override
	public PinInterest mapRow(ResultSet rs, int rowNum) throws SQLException {
		PinInterest pinterest = new PinInterest();
		pinterest.setId(rs.getLong("id"));
		pinterest.setPin(new Pin(rs.getLong("pinId")));
		pinterest.setPinCategory(new PinCategory(rs.getLong("categoryId")));
		pinterest.setRegDate(rs.getTimestamp("regDate"));
		pinterest.setUpdateDate(rs.getTimestamp("updateDate"));	
		
		return pinterest;
	}

}
