package com.tastekorea.webapp.pin.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.tastekorea.webapp.auth.web.command.User;
import com.tastekorea.webapp.common.Constants;
import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.service.PinService;

@Controller
public class GetPinController {
	
	@Autowired
	private PinService pinService;
	
	@GetMapping("/pin/{alias}/find")
	public String findById(@PathVariable String alias,HttpSession session, 
			@RequestParam(defaultValue="1") int pageNum, Model model){
		User user = (User) session.getAttribute("user");
		
		pageNum = pageNum < 1 ? 0 : pageNum - 1;
		Pageable pageable = PageRequest.of(pageNum, Constants.FETCH_SIZE, 
											Sort.Direction.DESC, "regDate");
		
		alias = user.getAlias();
		
		Page<Pin> page = pinService.findPinById(user.getId(), pageable);
		
		model.addAttribute("pinList", page);
		
		return "/pin/page_pin";
	}
}
