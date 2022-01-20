package com.tastekorea.webapp.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.member.dao.LanguageSkillDao;
import com.tastekorea.webapp.member.domain.LanguageSkill;
import com.tastekorea.webapp.member.domain.TasteMember;


@Service
public class LanguageSkillServiceImpl implements LanguageSkillService{
	
	@Autowired
	private LanguageSkillDao languageSkillDao;
	
	
	@Override
	public void addLanguageSkill(LanguageSkill ls) {
		languageSkillDao.add(ls);
	}


	@Override
	public List<LanguageSkill> getLanguageSkillListByMember(TasteMember tasteMember) {
		// TODO Auto-generated method stub
		return languageSkillDao.findByMember(tasteMember);
	}



	
}
