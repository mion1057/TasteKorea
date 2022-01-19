package com.tastekorea.webapp.pin.service;

import java.util.List;

import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.domain.PinInterest;

/**
 * 
 * @author "rohyh"
 *
 */
public interface PinInterestService {
	void addPinInterest(PinInterest pinterest);
	
	/**
	 * pinId로 등록된 pinInterest 불러오기
	 * 
	 * @param pin
	 * @return
	 */
	List<PinInterest> getPinInterestByPinId(Pin pin);
}
