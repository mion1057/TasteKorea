package com.tastekorea.webapp.common.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tastekorea.webapp.common.Constants;
import com.tastekorea.webapp.common.domain.AppReply;
import com.tastekorea.webapp.common.service.AppReplyService;
import com.tastekorea.webapp.main.web.command.AppReplyCommand;
import com.tastekorea.webapp.member.domain.TasteMember;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author kaminish
 *
 */
@Controller
@Slf4j
public class AppReplyController {
	
	@Autowired
	private AppReplyService appReplyService;
	
	@GetMapping("/common/addreply")
	public String addReply(AppReplyCommand appReplyCommand) {
		
		return "/pin/add_pin";
	}
	/**
	 * 
	 * @param appReplyCommand
	 * @param model
	 * @return
	 */
	@PostMapping("/common/addreply")
	public String addReply(AppReplyCommand appReplyCommand, Model model) {
		
		AppReply ar = new AppReply();
		ar.setParentId(appReplyCommand.getParentId());
		ar.setMember(new TasteMember(appReplyCommand.getMemberId()));
		ar.setAppCode(appReplyCommand.getAppCode());
		ar.setComment(appReplyCommand.getComment());
		ar.setRecipient(appReplyCommand.getRecipient());
		ar.setMasterId(appReplyCommand.getMasterId());
		ar.setPriority(appReplyCommand.getPriority());
		ar.setAlias(appReplyCommand.getAlias());
		
		ar = appReplyService.saveReply(ar);
		
		
		return "redirect:/common/pinpage";
	}
	
	@GetMapping("/common/appreply")
	public String appReply(@RequestParam(defaultValue = "1") int pageNum, Model model) {
		
		log.debug("pageNum : " + pageNum);
		pageNum = pageNum < 1 ? 0 : pageNum - 1;
		Pageable pageable = PageRequest.of(pageNum, Constants.FETCH_SIZE, 
											Sort.Direction.DESC, "regDate");
		
		Page<AppReply> memberPage = appReplyService.findParentRepliesByAppCode(pageNum, pageable);
		
		model.addAttribute("memberPage", memberPage);
		
		return "/pin/page_pin";
	}
	
}
