package com.tastekorea.webapp.user.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tastekorea.webapp.user.domain.Traveler;
import com.tastekorea.webapp.user.service.TravelerService;
import com.tastekorea.webapp.user.web.command.TravelerCommand;

@Controller
public class LoginTravelerController {

	@Autowired
	private TravelerService travelerService;


	@GetMapping("/user/traveler/login")
	public String loginUser(TravelerCommand command) {

		return "user/traveler/login_traveler";

	}

	@PostMapping("/user/traveler/login")
	public String login(TravelerCommand command, HttpSession session, RedirectAttributes rttr, Model model) {

		Traveler traveler = travelerService.loginUser(command.getEmail());

		session.setAttribute("traveler", traveler);
		
		Traveler travel = (Traveler) session.getAttribute("traveler");
		
		System.out.println("되나? :"+travel.toString());
		rttr.addFlashAttribute("traveler", travel);
		
		return "index";
	}

	@PostMapping("/guide/traveler/logout")
	public String logout(HttpSession session) throws Exception {

		session.invalidate();

		return "redirect:/";
	}

	@GetMapping("/user/traveler/mypage")
	public String backToMypage(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.getAttribute("traveler");
		return "user/traveler/traveler_mypage";
	}

}
