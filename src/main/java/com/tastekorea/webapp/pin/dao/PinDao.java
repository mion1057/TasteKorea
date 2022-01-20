package com.tastekorea.webapp.pin.dao;

import java.sql.PreparedStatement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tastekorea.webapp.common.dao.TasteDao;
import com.tastekorea.webapp.pin.domain.Pin;

@Repository
public class PinDao extends TasteDao {
	
	public long savePin(Pin pin) {
		String sql = "INSERT INTO Pin(memberId, imagePath, pinRegion, "
				+ "description, recommand, hate) VALUES (?, ?, ?, ?, ?"
				+ "?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator preparedStatementCreator  = (connection) -> {
			PreparedStatement pstmt = connection.prepareStatement(sql, new String[] { "id" });
			pstmt.setLong(1, pin.getMember().getId());
			pstmt.setString(2, pin.getImagePath());
			pstmt.setString(3, pin.getPinRegion());
			pstmt.setString(4, pin.getDescription());
			pstmt.setInt(5, pin.getLike());
			pstmt.setInt(6, pin.getDislike());
			pstmt.setInt(7, pin.getReadCount());
			return pstmt;
		};
		jdbcTemplate.update(preparedStatementCreator, keyHolder);
		
		return keyHolder.getKey().longValue();
	}
}
