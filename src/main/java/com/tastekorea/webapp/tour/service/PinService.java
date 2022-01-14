package com.tastekorea.webapp.tour.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tastekorea.webapp.guide.domain.Companion;
import com.tastekorea.webapp.tour.domain.Pin;

public interface PinService {
	
	void addPin(Pin pin);
	
	/**
	 * 
	 * @param companion : companionId required
	 * 
	 * @return
	 */
	List<Pin> getPinByCompanion(Companion companion);
	
	/**
	 * 핀 목록 조회(page)
	 * 
	 * @param pageable
	 * @return
	 */
	Page<Pin> getPinList(Pageable pageable);
	
	
	/**
	 * 핀 목록 조회(list)
	 * 
	 * @param companion
	 * @return
	 */
	List<Pin> getAllPinList();

}
