package com.tastekorea.webapp.guide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.guide.dao.LanguageSkillDao;
import com.tastekorea.webapp.guide.domain.Companion;
import com.tastekorea.webapp.guide.domain.LanguageSkill;


@Service
public class LanguageSkillServiceImpl implements LanguageSkillService{
	
	@Autowired
	private LanguageSkillDao languageSkillDao;
	
	
	@Override
	public void addLanguageSkill(LanguageSkill ls) {
		languageSkillDao.add(ls);
	}


	@Override
	public List<LanguageSkill> getLanguageSkillListByCompanion(Companion companion) {
		return languageSkillDao.findByCompanion(companion);
	}
	
}
