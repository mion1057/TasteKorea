package com.tastekorea.webapp.pin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.pin.dao.PinDao;

@Service
public class PinServiceImpl implements PinService{
	
	@Autowired
	private PinDao pinDao;
}
