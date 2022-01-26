package com.tastekorea.webapp.pin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tastekorea.webapp.pin.domain.Pin;

public interface PinService {
	Pin addPin(Pin pin);
	
	Page<Pin> findPinById(long id, Pageable pageable);
	
	Page<Pin> findAllPin(Pageable pageable);
}
