package com.tastekorea.webapp.user.web.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tastekorea.webapp.user.domain.Traveler;
import com.tastekorea.webapp.user.service.TravelerService;
import com.tastekorea.webapp.user.web.command.TravelerCommand;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AddTravelerController {

	@Autowired
	@Qualifier("travelerServiceImpl")
	private TravelerService travelerService;


	/**
	 * 
	 * @param travelerCommand
	 * @return
	 */
	@GetMapping("/user/traveler/signup")
	public String addTraveler(TravelerCommand travelerCommand) {
		return "user/traveler/signup_traveler";
	}

	/**
	 * 
	 * @param travelerCommand
	 * @param model
	 * @return
	 */
	@PostMapping("/user/traveler/signup")
	public String addTraveler(TravelerCommand travelerCommand, Model model) {
		Traveler t = new Traveler();
		t.setEmail(travelerCommand.getEmail());
		t.setPasswd(travelerCommand.getPasswd());
		t.setName(travelerCommand.getName());

		t = travelerService.addTraveler(t);
		model.addAttribute("traveler", t);

		return "user/traveler/welcome_traveler";
	}

	@ResponseBody
	@PostMapping("user/traveler/emailCheck")
	public Map<String, String> isEmailCheck(@RequestBody Map<String, String> param) {
		System.out.println("email입력" + param.get("email"));
		String msg = "";
		String email = param.get("email");

		if (travelerService.isEmailCheck(email)) {
			msg = "사용 가능한 email입니다";
		} else {
			msg = "사용 불가능한 email입니다";
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", msg);

		return map;
	}

}
