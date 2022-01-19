package com.tastekorea.webapp.pin.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tastekorea.webapp.member.domain.TasteMember;
import com.tastekorea.webapp.pin.domain.Pin;

/**
 * 
 * 작업중(미완성)
 * 
 * @author "rohyh"
 *
 */
public interface PinService {
	
	Pin addPin(Pin pin);
	
	/**
	 * 
	 * @param companion : companionId required
	 * 
	 * @return
	 */
	List<Pin> getPinByTasteMember(TasteMember tasteMember);
	
	/**
	 * 핀 목록 조회(page)
	 * 
	 * @param pageable
	 * @return
	 */
	Page<Pin> getPinPage(Pageable pageable);
	
	
	/**
	 * 핀 목록 조회(list)
	 * 
	 * @param companion
	 * @return
	 */
	List<Pin> getPinList();

}
