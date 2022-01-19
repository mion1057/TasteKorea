package com.tastekorea.webapp.pin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.member.domain.TasteMember;
import com.tastekorea.webapp.pin.dao.PinDao;
import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.domain.PinImage;
import com.tastekorea.webapp.pin.domain.PinInterest;
import com.tastekorea.webapp.pin.domain.PinMapData;

/**
 * 작업중 (미완성)
 * 
 * @author "rohyh"
 *
 */
@Service("pinServiceImpl")
public class PinServiceImpl implements PinService{
	
	@Autowired
	private PinDao pinDao;
	
	@Autowired
	private PinMapService pinMapService;
	
	@Autowired
	private PinImageService pinImageService;
	
	@Autowired
	private PinInterestService pinInterestService;
	
	/**
	 * Pin정보를 
	 * PinMapData, PinImages, PinInterest에 각각 저장
	 * 
	 * @param member
	 * @return
	 */
	@Override
	public Pin addPin(Pin pin) {
		//1.TasteMember 저장
		long id = pinDao.save(pin);
		pin.setId(id);
		
		//2.PinMapData에 좌표값(String) 저장
		PinMapData pinMap = new PinMapData();
		pinMap.setPin(pin);
		pinMapService.addPinMap(pinMap);
		
		//3.PinImages 목록 저장
		List<PinImage> imageList = pin.getImageList();
		for(PinImage pimg : imageList) {
			pimg.setPin(pin);
			pinImageService.addPinImage(pimg);
		}
		
		//4.PinInterest 목록 저장
		List<PinInterest> interestList = pin.getInterestList();
		for(PinInterest pinterest : interestList) {
			pinterest.setPin(pin);
			pinInterestService.addPinInterest(pinterest);
		}
		
		return pin;
	}
	
	/**
	 * memberId로 pin 조회
	 */
	@Override
	public List<Pin> getPinByTasteMember(TasteMember tasteMember) {
		return pinDao.findByTasteMember(tasteMember);
	}
	
	/**
	 * pin 목록 조회(page)
	 */
	@Override
	public Page<Pin> getPinPage(Pageable pageable) {
		return pinDao.findAll(pageable);
	}
	
	/**
	 * pin 목록 조회(List)
	 */
	@Override
	public List<Pin> getPinList() {
		return pinDao.findAll();
	}

	
	
}
