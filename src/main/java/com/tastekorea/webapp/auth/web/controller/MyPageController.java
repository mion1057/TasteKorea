package com.tastekorea.webapp.auth.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tastekorea.webapp.auth.web.command.User;
import com.tastekorea.webapp.auth.web.exception.LoginFailException;
import com.tastekorea.webapp.member.service.TasteMemberService;
import com.tastekorea.webapp.member.web.command.MemberCommand;

@Controller
public class MyPageController {
	
	@Autowired
	private TasteMemberService memberService;
	
	@GetMapping("/member/{type}/mypage")
	public String myPage(@PathVariable String type, HttpSession session, Model model) throws LoginFailException {
		
		User user = (User) session.getAttribute("user");
		
		model.addAttribute(user);
		
		String nextPage = null;
		if(type == "traveler") {
			memberService.myPage(user);
			nextPage = "/member/infomanagement_traveler";
		}else {
			memberService.myPage(user);
			nextPage = "/member/infomanagement_companion";
		}
		
		return nextPage;
		
	}

	
	
	
}
