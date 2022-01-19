package com.tastekorea.webapp.pin.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tastekorea.webapp.common.dao.TasteDao;
import com.tastekorea.webapp.member.domain.TasteMember;
import com.tastekorea.webapp.pin.domain.Pin;

/**
 * 
 * 작업중(미완성)
 * 
 * @author "rohyh"
 *
 */
@Repository
public class PinDao extends TasteDao {
	
	/**
	 * 신규 Pin 추가
	 * 
	 * @param member
	 * @return
	 */
	public long save(Pin pin) {
		String sql = "INSERT INTO Pin(member, title, details, mapData)"
				+ " VALUES(?, ?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator preparedStatementCreator = (connection) -> {
			PreparedStatement pstmt = connection.prepareStatement(sql, new String[] { "id" });
			pstmt.setLong(1, pin.getMember().getId());
			pstmt.setString(2, pin.getTitle());
			pstmt.setString(3, pin.getDetails());
			pstmt.setString(4, pin.getMapData());
			
			return pstmt;
		};
		jdbcTemplate.update(preparedStatementCreator, keyHolder);
		
		return keyHolder.getKey().longValue();
	}

	/**
	 * 
	 * @return
	 */
	public List<Pin> findAll() {
		String sql = "SELECT * FROM Pin";
		return jdbcTemplate.query(sql, new PinRowMapper());
	}
	
	/**
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<Pin> findAll(Pageable pageable) {
		String sql = pagingQuery("SELECT * FROM Pin", pageable);
		List<Pin> list = jdbcTemplate.query(sql, new PinRowMapper());

		return new PageImpl<Pin>(list, pageable, count("Pin"));
	}
	
	/**
	 * 
	 * @param TasteMember
	 * @return
	 */
	public List<Pin> findByTasteMember(TasteMember TasteMember) {
		String sql = "SELECT * FROM Pin WHERE TasteMemberId = ?";
		return jdbcTemplate.query(sql, new PinRowMapper(), TasteMember.getId());
	}

}
