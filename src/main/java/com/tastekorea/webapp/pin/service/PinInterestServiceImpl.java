package com.tastekorea.webapp.pin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.pin.dao.PinInterestDao;
import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.domain.PinInterest;

/**
 * 
 * @author "rohyh"
 *
 */
@Service
public class PinInterestServiceImpl implements PinInterestService {
	
	@Autowired
	private PinInterestDao pinInterestDao;

	@Override
	public void addPinInterest(PinInterest pinterest) {
		pinInterestDao.add(pinterest);
	}

	@Override
	public List<PinInterest> getPinInterestByPinId(Pin pin) {
		return pinInterestDao.findById(pin);
	}
}
