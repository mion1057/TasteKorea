package com.tastekorea.webapp.guide.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tastekorea.webapp.common.Constants;
import com.tastekorea.webapp.common.vo.PageMaker;
import com.tastekorea.webapp.guide.domain.Companion;
import com.tastekorea.webapp.guide.service.CompanionService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GetCompanionController {

	@Autowired
	@Qualifier("companionServiceImpl")
	private CompanionService companionService;
	
	
	/**
	 * 가이드 목록 조회
	 * /guide/companion/list
	 * /guide/companion/list?pageNum=1
	 * 
	 * @param pageNum
	 * @param model
	 * @return
	 */
	@GetMapping("/guide/companion/list")
	public String listCompanions(@RequestParam(defaultValue="1") int pageNum, Model model) {
		log.debug("pageNum : " + pageNum);
		
		pageNum = pageNum < 1 ? 0 : pageNum - 1;
		Pageable pageable = PageRequest.of(pageNum, Constants.FETCH_SIZE, 
											Sort.Direction.DESC, "regDate");
		
		Page<Companion> companionPage = companionService.getCompanionList(pageable);
		model.addAttribute("pageMaker", new PageMaker<Companion>(companionPage));
		
		return "guide/companion/list_companions";
	}
	
}
