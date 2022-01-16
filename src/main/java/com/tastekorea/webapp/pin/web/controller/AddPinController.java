package com.tastekorea.webapp.pin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tastekorea.webapp.pin.service.PinService;

@Controller
public class AddPinController {

	@Autowired
	private PinService pinService;
	
	
}
