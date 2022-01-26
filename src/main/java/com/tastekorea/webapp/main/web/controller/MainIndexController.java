package com.tastekorea.webapp.main.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainIndexController {
	
	@GetMapping("/")
	public String index(HttpSession session) {
		session.getAttribute("user");
		return "index";
	}
}
