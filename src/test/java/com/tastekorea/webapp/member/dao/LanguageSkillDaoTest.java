package com.tastekorea.webapp.member.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.tastekorea.webapp.TasteTest;
import com.tastekorea.webapp.member.domain.ForeignLanguage;
import com.tastekorea.webapp.member.domain.LanguageSkill;
import com.tastekorea.webapp.member.domain.TasteMember;

public class LanguageSkillDaoTest extends TasteTest{
	
	@Autowired
	private LanguageSkillDao dao;
	
	
	@Test
	@Transactional
	@Commit
	public void add() {
		start("add");
		
		LanguageSkill skill = new LanguageSkill(new ForeignLanguage(10000001), 4.5);
		skill.setMember(new TasteMember(15000001));
		
		dao.add(skill);
		
		end();
	}
}
