package com.tastekorea.webapp.tour.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.tastekorea.webapp.common.dao.TasteDao;
import com.tastekorea.webapp.guide.domain.Companion;
import com.tastekorea.webapp.tour.domain.Pin;

@Repository
public class PinDao extends TasteDao {

	public void add(Pin pin) {
		String sql = "INSERT INTO Pin(companionId, title, photo, price, duration, location, details)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?)";

		jdbcTemplate.update(sql, pin.getCompanion().getId(), pin.getTitle(), pin.getPhoto(), pin.getPrice(),
				pin.getDuration(), pin.getLocation(), pin.getDetails());
	}

	public List<Pin> findAll() {
		String sql = "SELECT * FROM Pin";
		return jdbcTemplate.query(sql, new PinRowMapper());
	}

	public Page<Pin> findAll(Pageable pageable) {
		String sql = pagingQuery("SELECT * FROM Pin", pageable);
		List<Pin> list = jdbcTemplate.query(sql, new PinRowMapper());

		return new PageImpl<Pin>(list, pageable, count("Pin"));
	}

	public List<Pin> findByCompanion(Companion companion) {
		String sql = "SELECT * FROM Pin WHERE CompanionId = ?";
		return jdbcTemplate.query(sql, new PinRowMapper(), companion.getId());
	}

}
