package com.tastekorea.webapp.pin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.pin.dao.PinDao;
import com.tastekorea.webapp.pin.domain.Pin;

@Service
public class PinServiceImpl implements PinService{
	
	@Autowired
	private PinDao pinDao;

	@Override
	public Pin addPin(Pin pin) {
		long id = pinDao.save(pin);
		pin.setId(id);
		return pin;
	}

	@Override
	public Page<Pin> findPinById(long id, Pageable pageable) {
		return (Page<Pin>) pinDao.findByMemberId(id, pageable);
		
	}
}
