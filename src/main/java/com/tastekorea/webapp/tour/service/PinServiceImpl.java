package com.tastekorea.webapp.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.guide.domain.Companion;
import com.tastekorea.webapp.tour.dao.PinDao;
import com.tastekorea.webapp.tour.domain.Pin;

@Service("pinServiceImpl")
public class PinServiceImpl implements PinService{
	
	@Autowired
	private PinDao pinDao;

	@Override
	public void addPin(Pin pin) {
		pinDao.add(pin);		
	}

	@Override
	public List<Pin> getPinByCompanion(Companion companion) {
		return pinDao.findByCompanion(companion);
	}

	@Override
	public Page<Pin> getPinList(Pageable pageable) {
		return pinDao.findAll(pageable);
	}

	@Override
	public List<Pin> getAllPinList() {
		return pinDao.findAll();
	}
	
	
}
