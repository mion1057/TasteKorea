package com.tastekorea.webapp.guide.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.guide.domain.Companion;
import com.tastekorea.webapp.guide.domain.ForeignLanguage;
import com.tastekorea.webapp.guide.domain.LanguageSkill;

public class LanguageSkillRowMapper implements RowMapper<LanguageSkill> {

   @Override
   public LanguageSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
      LanguageSkill languageSkill = new LanguageSkill();
      languageSkill.setId(rs.getLong("id"));
      languageSkill.setCompanion(new Companion(rs.getLong("companionId")));
      languageSkill.setLanguage(new ForeignLanguage(rs.getLong("languageId"))); 
      languageSkill.setSkillLevel(rs.getDouble("skillLevel"));
      
      return languageSkill;
   }

}