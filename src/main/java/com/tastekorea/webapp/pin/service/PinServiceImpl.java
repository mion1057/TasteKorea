package com.tastekorea.webapp.pin.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Pin findPin() {
		// TODO Auto-generated method stub
		return null;
	}
}
