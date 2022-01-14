package com.tastekorea.webapp.guide.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tastekorea.webapp.guide.domain.Companion;
import com.tastekorea.webapp.guide.service.CompanionService;
import com.tastekorea.webapp.guide.web.command.CompanionCommand;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class LoginCompanionController {

	@Autowired
	@Qualifier("companionServiceImpl")
	private CompanionService companionService;

	@GetMapping("/guide/companion/login")
	public String login(CompanionCommand command) {

		return "guide/companion/companion_login";
	}

	@PostMapping("/guide/companion/login")
	public String login(CompanionCommand command, HttpSession session, RedirectAttributes rttr, Model model) {

		Companion companion = companionService.login(command.getEmail());

		session.setAttribute("companion", companion);

		model.addAttribute("companion", companion);

		rttr.addFlashAttribute("companion", companion);

		System.out.println(companion.getDetails());

		return "redirect:/";
	}

	@PostMapping("/guide/companion/logout")
	public String logout(HttpSession session) throws Exception {

		session.invalidate();

		return "redirect:/";
	}
}
