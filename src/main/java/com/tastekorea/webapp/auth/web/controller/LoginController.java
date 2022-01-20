package com.tastekorea.webapp.auth.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tastekorea.webapp.auth.web.command.User;
import com.tastekorea.webapp.member.service.TasteMemberService;
import com.tastekorea.webapp.member.web.command.MemberCommand;

@Controller
public class LoginController {

	@Autowired
	private TasteMemberService memberService;

	@GetMapping("/login")
	public String login( MemberCommand command, Model model) {
		
		return "/login/login_traveler";
		
	}

	@PostMapping("/login")
	public String login(MemberCommand memberCommand, Model model, HttpSession session) {
	
		User user = memberService.loginMember(memberCommand.getEmail());
		
		if(user.equals(null)) {
			session.setAttribute("user", null);
			model.addAttribute(user);
		}
		
		session.setAttribute("user", user);
		
		System.out.println(user.toString());

		return "redirect:/";
	}

	@PostMapping("/member/{type}/logout")
	public String logout(HttpSession session) {
		Object obj = session.getAttribute("member");
		
		if(!obj.equals(null)) {
		session.removeAttribute("member");
		session.invalidate();
		}
		return "redirect:/";
	}
}
