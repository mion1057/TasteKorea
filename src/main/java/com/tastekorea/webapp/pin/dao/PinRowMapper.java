package com.tastekorea.webapp.pin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.member.domain.TasteMember;
import com.tastekorea.webapp.pin.domain.Pin;

/**
 * 
 * @author "rohyh"
 *
 */
public class PinRowMapper implements RowMapper<Pin> {
	
	/**
	 * 
	 */
	@Override
	public Pin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pin pin = new Pin();
		 pin.setId(rs.getLong("id"));
	     pin.setMember(new TasteMember(rs.getLong("memberId")));
	     pin.setTitle(rs.getString("title"));
	     pin.setDetails(rs.getString("details"));
	     pin.setMapData(rs.getString("mapData"));
	     pin.setRegDate(rs.getTimestamp("regDate"));
	     pin.setUpdateDate(rs.getTimestamp("updateDate"));
	     
		return pin;
	}

}
