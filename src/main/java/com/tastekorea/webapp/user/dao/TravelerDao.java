package com.tastekorea.webapp.user.dao;

import java.util.List;

import com.tastekorea.webapp.common.dao.TasteDao;
import com.tastekorea.webapp.user.domain.Traveler;

public class TravelerDao extends TasteDao{
	
	public Traveler add(Traveler traveler) {
		String sql = "INSERT INTO Traveler(email, passwd, name ) values"
				+ "(?, ?, ?)";
		jdbcTemplate.update(sql, traveler.getEmail(), 
				traveler.getPasswd(), traveler.getName());
		return traveler;
	}
	
	public List<Traveler> findAll(Traveler traveler) {
		String sql = "SELECT * FROM Traveler";
		return jdbcTemplate.query(sql, new TravelerRowMapper());
	}
	
	public Traveler findByEmail(String email) {
		String sql = "SELECT * FROM Traveler WHERE email = ?";
		return jdbcTemplate.queryForObject(sql, new TravelerRowMapper(), email);
	}
	
	/**
	 * email 중복체크
	 * 
	 * @param email
	 * @return
	 */
	public boolean isEmailCheck(String email) {
		System.out.println("DAO들어왔습니까?");
		String sql = "SELECT * FROM Traveler WHERE email=?";
		List<Traveler> list = null;
		list = jdbcTemplate.query(sql, new TravelerRowMapper(), email);

		if (list == null || list.equals(null) || list.size() == 0) {
			return true;
		}
		return false;
	}
	public Traveler loginUser(String email) {
		String sql = "SELECT * FROM Traveler WHERE email = ?";
		return jdbcTemplate.queryForObject(sql, new TravelerRowMapper(), email);
	}
}
