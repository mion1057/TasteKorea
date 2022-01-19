package com.tastekorea.webapp.pin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.domain.PinImage;

/**
 * 
 * @author "rohyh"
 *
 */
public class PinImageRowMapper implements RowMapper<PinImage> {
	
	/**
	 * 
	 */
	@Override
	public PinImage mapRow(ResultSet rs, int rowNum) throws SQLException {
		PinImage img = new PinImage();
		img.setId(rs.getLong("id"));
		img.setPin(new Pin(rs.getLong("pinId")));
		img.setPhoto(rs.getString("photo"));
		img.setRegDate(rs.getTimestamp("regDate"));
		img.setUpdateDate(rs.getTimestamp("updateDate"));
		
		return img;
	}

}
