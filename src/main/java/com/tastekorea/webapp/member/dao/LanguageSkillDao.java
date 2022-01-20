package com.tastekorea.webapp.member.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tastekorea.webapp.guide.domain.Companion;
import com.tastekorea.webapp.member.domain.LanguageSkill;



@Repository
public class LanguageSkillDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * languageSkill 등록
	 */
	public void add(LanguageSkill languageSkill) {
		String sql = "INSERT INTO LanguageSkill(companionId, languageId, "
				+ "skillLevel) VALUES(?, ?, ?)";
		
		jdbcTemplate.update(sql, languageSkill.getCompanion().getId(), 
				languageSkill.getLanguage().getId(), languageSkill.getSkillLevel());
	}

	/*
	 * companionId를 통해 각 companion이 보유한 languageSkill조회
	 */
	public List<LanguageSkill> findByCompanion(Companion companion) {
		String sql = "SELECT * FROM languageSkill WHERE companionId = ?";
		return jdbcTemplate.query(sql, new LanguageSkillRowMapper(), companion.getId());
	}
}