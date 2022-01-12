package com.tastekorea.webapp.guide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tastekorea.webapp.guide.dao.CompanionDao;
import com.tastekorea.webapp.guide.domain.Companion;
import com.tastekorea.webapp.guide.domain.LanguageSkill;

import lombok.extern.slf4j.Slf4j;

@Service("companionServiceImpl")
@Slf4j
public class CompanionServiceImpl implements CompanionService{
	
	@Autowired
	private CompanionDao companionDao;
	
	@Autowired
	@Qualifier("languageSkillServiceImpl")
	private LanguageSkillService languageSkillService;
	
	
	
	@Override
	@Transactional
	public Companion addCompanion(Companion companion) {
		//1.Companion 저장
		Companion dbCompanion = companionDao.save(companion);
		
		//2.LanguageSkill 목록 저장
		List<LanguageSkill> skillList = companion.getLanguageSkillList();
		for(LanguageSkill ls : skillList) {
			ls.setCompanion(dbCompanion);
			languageSkillService.addLanguageSkill(ls);
		}
		return dbCompanion;
	}
	
	
	/**
	 * 가이드 상세보기
	 * @param id
	 * @return
	 */
	@Override
	public Companion getCompanion(long id) {
		Companion companion = companionDao.findById(id);
		List<LanguageSkill> skillList = languageSkillService.
				getLanguageSkillListByCompanion(companion);
		companion.setLanguageSkillList(skillList);
		
		return companion;
	}
	
	
	/**
	 * 가이드 목록 조회
	 * 
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<Companion> getCompanionList(Pageable pageable){
		return companionDao.findAll(pageable);
	}
	
	
	//-------------------------------------------------------------------------
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Companion getFullCompanion(long id) {
		List<LanguageSkill> skillList = languageSkillService.
				getLanguageSkillListByCompanion(new Companion(id));
		Companion companion = null;
		if(skillList.size() > 0) {
			companion = skillList.get(0).getCompanion();
		}
		companion.setLanguageSkillList(skillList);
		return companion;
	}

}
