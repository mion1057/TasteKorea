package com.tastekorea.webapp.pin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.pin.dao.PinDao;
<<<<<<< HEAD
import com.tastekorea.webapp.pin.domain.Pin;
=======
>>>>>>> ef9369a398f2db785d7e7d7c8bd396aaa2cfba39

@Service
public class PinServiceImpl implements PinService{
	
	@Autowired
	private PinDao pinDao;
<<<<<<< HEAD

	@Override
	public Pin addPin(Pin pin) {
		long id = pinDao.savePin(pin);
		pin.setId(id);
		return pin;
	}

	@Override
	public Pin findPin() {
		// TODO Auto-generated method stub
		return null;
	}
=======
>>>>>>> ef9369a398f2db785d7e7d7c8bd396aaa2cfba39
}
