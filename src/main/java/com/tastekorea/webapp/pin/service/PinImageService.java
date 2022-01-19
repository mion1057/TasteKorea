package com.tastekorea.webapp.pin.service;

import java.util.List;

import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.domain.PinImage;

/**
 * 
 * @author "rohyh"
 *
 */
public interface PinImageService {
	
	void addPinImage(PinImage pimg);
	
	/**
	 * pinId로 등록된 이미지들 불러오기
	 * 
	 * @param pin
	 * @return
	 */
	List<PinImage> getImageByPinId(Pin pin);
}
