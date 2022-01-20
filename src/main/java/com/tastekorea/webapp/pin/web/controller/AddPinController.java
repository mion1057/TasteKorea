package com.tastekorea.webapp.pin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tastekorea.webapp.common.service.FileUploader;
import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.service.PinService;
import com.tastekorea.webapp.pin.web.command.PinCommand;

@Controller
public class AddPinController {

	@Autowired
	private PinService pinService;
	
	@Autowired
	private FileUploader fileUploader;
	
	@GetMapping("/pin/index")
	public String addPin(PinCommand command) {
		
		return "pin/add_pin";
	}
	
	@PostMapping("/pin/index")
	public String addPin(PinCommand command, Model model) {
		Pin pin = new Pin();
		pin.setMember(command.getMember());
		pin.setPinRegion(command.getPinRegion());
		pin.setDescription(command.getDescription());
		pin.setLike(command.getLike());
		pin.setDislike(command.getDislike());
		pin.setReadCount(command.getReadCount());
		
		if(command.getImagePath() != null) {
			pin.setImagePath(fileUploader.fileUpload(command.getImagePath()));
		}
		
		pin = pinService.addPin(pin);
		model.addAttribute("pin", pin);
		return "pin/index";
		
	}
}
