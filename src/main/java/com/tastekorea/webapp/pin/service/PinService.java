package com.tastekorea.webapp.pin.service;

import com.tastekorea.webapp.pin.domain.Pin;

public interface PinService {
	Pin addPin(Pin pin);
	Pin findPin();
}
