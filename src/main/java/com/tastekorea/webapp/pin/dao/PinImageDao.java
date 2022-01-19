package com.tastekorea.webapp.pin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.domain.PinImage;

/**
 * 
 * @author "rohyh"
 *
 */
public class PinImageDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * pin 사진 추가
	 * @param img
	 */
	public void add(PinImage img) {
		String sql ="INSERT INTO pinImage(pinId, photo)"
				+ "VALUES(?, ?)";
		jdbcTemplate.update(sql, img.getPin().getId(), 
				img.getPhoto());
	}
	
	public List<PinImage> findById(Pin pin) {
		String sql ="SELECT photo FROM PinImage"
				+ "WHERE pinId = ?";
		return jdbcTemplate.query(sql, new PinImageRowMapper(), pin.getId());
	}
	
	
}
