package com.tastekorea.webapp.guide.service;

import java.util.List;

import com.tastekorea.webapp.guide.domain.Companion;
import com.tastekorea.webapp.guide.domain.LanguageSkill;

public interface LanguageSkillService {

	void addLanguageSkill(LanguageSkill ls);

	/**
	 * 
	 * @param companion : companionId required
	 * 
	 * @return
	 */
	List<LanguageSkill> getLanguageSkillListByCompanion(Companion companion);

}
