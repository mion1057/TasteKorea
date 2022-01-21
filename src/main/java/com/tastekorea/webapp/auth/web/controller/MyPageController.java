package com.tastekorea.webapp.auth.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tastekorea.webapp.auth.web.command.User;
import com.tastekorea.webapp.member.domain.Region;
import com.tastekorea.webapp.member.domain.TasteMember;
import com.tastekorea.webapp.member.service.TasteMemberService;
import com.tastekorea.webapp.member.web.command.MemberCommand;

@Controller
public class MyPageController {
	
	@Autowired
	private TasteMemberService memberService;
	
	@GetMapping("/member/{type}/mypage")
	public String myPage(@PathVariable String type, MemberCommand command, HttpSession session, Model model) {
		String nextPage = null;
		User user = (User) session.getAttribute("user");
	
		TasteMember member = new TasteMember();
		member.setPasswd(command.getPasswd());
		Region region = new Region();
		region.setId(command.getRegion());
		member.setRegion(region);
		member.setEmail(command.getEmail());
		
		if(type.equals("traveler")) {
			memberService.UpdateMemberInfo(member, user.getEmail());
			nextPage =  "/member/infomational_traveler";
		}else {
			nextPage = "/member/informational_companion";
		}
		return nextPage;
	}
	
	
	
}
