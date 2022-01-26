package com.tastekorea.webapp.auth.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tastekorea.webapp.auth.web.command.User;
import com.tastekorea.webapp.auth.web.exception.LoginFailException;
import com.tastekorea.webapp.member.domain.LanguageSkill;
import com.tastekorea.webapp.member.domain.TasteMember;
import com.tastekorea.webapp.member.service.TasteMemberService;
import com.tastekorea.webapp.member.web.command.MemberCommand;

@Controller
public class MyPageController {
	
	@Autowired
	private TasteMemberService memberService;
	
	@GetMapping("/member/{type}/mypage")
	public String myPage(@PathVariable String type, HttpSession session, Model model) throws LoginFailException {
		
		User user = (User) session.getAttribute("user");
		
		List<LanguageSkill> userList =  (List<LanguageSkill>)session.getAttribute("list");		
		
		session.setAttribute("list", userList);
		
		model.addAttribute(user);
		
		String nextPage = null;
		if(type == "traveler") {
			memberService.myPage(user);
			nextPage = "/member/infomanagement_traveler";
		}else {
			memberService.myPage(user);
			nextPage = "/member/information_companion";
		}
		
		return nextPage;
		
	}
	@GetMapping("/member/companion/info")
	public String companionDetail(MemberCommand memberCommand, Model model) {
		
		TasteMember comlist = memberService.getMember(memberCommand.getId());
		
		model.addAttribute("comlist",comlist);
		
		return "/member/information_companions_detail";
	}
	
	
	
}
