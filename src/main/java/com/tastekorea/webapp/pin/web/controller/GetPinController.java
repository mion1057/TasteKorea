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
import org.springframework.web.bind.annotation.RequestParam;

import com.tastekorea.webapp.auth.web.command.User;
import com.tastekorea.webapp.common.Constants;
import com.tastekorea.webapp.common.vo.PageMaker;
import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.service.PinService;

@Controller
public class GetPinController {
	
	@Autowired
	private PinService pinService;
	/**
	 * 전체 핀 찾기
	 * @param alias
	 * @param session
	 * @param pageNum
	 * @param model
	 * @return
	 */
	@GetMapping("/pin/find")
	public String findById(HttpSession session, 
			@RequestParam(defaultValue="1") int pageNum, Model model){
		User user = (User) session.getAttribute("user");
		
		pageNum = pageNum < 1 ? 0 : pageNum - 1;
		Pageable pageable = PageRequest.of(pageNum, Constants.FETCH_SIZE, 
											Sort.Direction.DESC, "regDate");
		
		
		Page<Pin> page = pinService.findAllPin(pageable);
		
		model.addAttribute("user", user);
		model.addAttribute("pinList", new PageMaker<Pin>(page));
		
		return "/pin/page_allPin";
	}
}
