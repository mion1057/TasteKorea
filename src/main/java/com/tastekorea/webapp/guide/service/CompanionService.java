package com.tastekorea.webapp.guide.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tastekorea.webapp.guide.domain.Companion;

public interface CompanionService {

	Companion addCompanion(Companion companion);


	/**
	 * 
	 * @param id
	 * @return
	 */
	Companion getCompanion(long id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Companion getFullCompanion(long id);


	/**
	 * 가이드 목록 조회
	 * 
	 * @param pageable
	 * @return
	 */
	Page<Companion> getCompanionList(Pageable pageable);

}
