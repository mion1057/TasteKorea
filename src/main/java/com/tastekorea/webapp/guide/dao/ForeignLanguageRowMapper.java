package com.tastekorea.webapp.guide.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.guide.domain.ForeignLanguage;

public class ForeignLanguageRowMapper implements RowMapper<ForeignLanguage> {

	@Override
	public ForeignLanguage mapRow(ResultSet rs, int rowNum) throws SQLException {
		ForeignLanguage language = new ForeignLanguage();
		language.setId(rs.getLong("id"));
		language.setLang(rs.getString("lang"));

		return language;
	}
}