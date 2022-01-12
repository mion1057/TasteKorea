package com.tastekorea.webapp.guide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.guide.dao.ForeignLanguageDao;
import com.tastekorea.webapp.guide.domain.ForeignLanguage;



@Service
public class ForeignLanguageServiceImpl implements ForeignLanguageService{
	
	@Autowired
	private ForeignLanguageDao languageDao;
	
	
	
	/**
	 * 
	 */
	@Override
	public List<ForeignLanguage> getAll() {
		return languageDao.findAll();
	}

}
