package com.tastekorea.webapp.auth.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tastekorea.webapp.auth.web.LoginFailException;
import com.tastekorea.webapp.auth.web.command.User;
import com.tastekorea.webapp.member.service.TasteMemberService;
import com.tastekorea.webapp.member.web.command.MemberCommand;


@Controller
public class LoginController {

	@Autowired
	private TasteMemberService memberService;

	@GetMapping("/member/login")
	public String login(MemberCommand command, Model model) {
		return "/auth/login_member";
		
	}

	@PostMapping("/member/login")
	public String login(MemberCommand memberCommand, Model model, HttpSession session) throws LoginFailException {
		
		User user = memberService.loginMember(memberCommand.getEmail(), memberCommand.getPasswd());
		
		if(user == null) {
			System.out.println("로그인 오류: 유저 정보를 다시 확인해 주세요.");
			return "redirect:/member/login";
		}
		
		System.out.println(user.getDetail());
		
		session.setAttribute("user", user);
		
		model.addAttribute("user", user);
		
		return "redirect:/";
		
	}

	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
}
