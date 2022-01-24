package com.tastekorea.webapp.pin.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.member.domain.Region;
import com.tastekorea.webapp.member.domain.TasteMember;

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
	      pin.setCategory(new PinCategory(rs.getLong("c.id"), 
	            rs.getString("c.eng"), rs.getString("c.kor")));
	       pin.setMember(new TasteMember(rs.getLong("m.id"), 
	             rs.getString("m.alias")));
	       pin.setRegion(new Region(rs.getLong("r.id"),
	             rs.getString("r.eng"), rs.getString("r.kor")));
	       pin.setImagePath(rs.getString("pinPhoto"));
	       pin.setTitle(rs.getString("title"));
	       pin.setDescription(rs.getString("details"));
	       pin.setMapData(rs.getString("mapData"));
	       pin.setLike(rs.getInt("like"));
	       pin.setDislike(rs.getInt("dislike"));
	       pin.setRegDate(rs.getTimestamp("regDate"));
	       pin.setUpdateDate(rs.getTimestamp("updateDate"));
	        
	      return pin;
	   }

	}