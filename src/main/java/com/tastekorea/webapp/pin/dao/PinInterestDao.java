package com.tastekorea.webapp.pin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.domain.PinInterest;

/**
 * 
 * @author "rohyh"
 *
 */
public class PinInterestDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * pinInterest 등록
	 * 
	 * @param pinterest
	 */
	public void add(PinInterest pinterest) {
		String sql = "INSERT INTO PinInterest(pinId, categoryId) "
				+ "VALUES(?, ?)";
		jdbcTemplate.update(sql, pinterest.getPin().getId(), 
				pinterest.getPinCategory().getId());
	}
	
	/**
	 * pinId로 등록된 interest 검색
	 * @param pin
	 * @return
	 */
	public List<PinInterest> findById(Pin pin) {
		String sql = "SELECT categoryId FROM pinInterest"
				+ " WHERE pinId = ?";
		return jdbcTemplate.query(sql, new PinInterestRowMapper(), pin.getId());
	}
	
}
