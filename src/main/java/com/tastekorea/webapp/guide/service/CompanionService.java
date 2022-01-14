package com.tastekorea.webapp.guide.service;

import java.util.List;

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
	
	
	/**
	 * 가이드 목록을 List로 조회
	 * 
	 * @param companion
	 * @return
	 */
	List<Companion> getAllCompanionList();
	
	/**
	 * 회원가입시 email 중복체크
	 * 
	 * @param email
	 * @return
	 */
	boolean isEmailCheck(String email);


	Companion login(String email);


	boolean ruCompanion(String email);
	
}
