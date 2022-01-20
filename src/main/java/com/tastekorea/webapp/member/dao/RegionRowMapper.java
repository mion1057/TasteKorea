package com.tastekorea.webapp.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.member.domain.Region;

public class RegionRowMapper implements RowMapper<Region> {

	@Override
	public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
		Region region = new Region();
		region.setId(rs.getLong("id"));
		region.setKor(rs.getString("kor"));
		region.setEng(rs.getString("eng"));
<<<<<<< HEAD
		region.setGuide(rs.getBoolean("guide"));
=======
		region.setGuide(rs.getBoolean(rowNum));
>>>>>>> ef9369a398f2db785d7e7d7c8bd396aaa2cfba39
		
		return region;
	}

}
