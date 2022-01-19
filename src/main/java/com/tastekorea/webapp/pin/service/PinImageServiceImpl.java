package com.tastekorea.webapp.pin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.pin.dao.PinImageDao;
import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.domain.PinImage;

/**
 * 
 * @author "rohyh"
 *
 */
@Service
public class PinImageServiceImpl implements PinImageService {
	
	@Autowired
	private PinImageDao pinImageDao;
	
	/**
	 * 사진 등록
	 */
	@Override
	public void addPinImage(PinImage pimg) {
		pinImageDao.add(pimg);
		
	}
	
	/**
	 * 사진 찾기
	 */
	@Override
	public List<PinImage> getImageByPinId(Pin pin) {
		return pinImageDao.findById(pin);
	}

}
