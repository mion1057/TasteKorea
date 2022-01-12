package com.tastekorea.webapp.guide.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.tastekorea.webapp.TasteTest;
import com.tastekorea.webapp.guide.domain.Companion;

public class CompanionServiceTest extends TasteTest{
	
	@Autowired
	private CompanionService companionService;
	
	
	@Test
	public void getCompanionList() {
		start("getCompanionList");
		
		int pageNum = 1;
		Pageable pageable = PageRequest.of(pageNum, 3, 
				Sort.Direction.DESC, "regDate");
		Page<Companion> page = companionService.getCompanionList(pageable);
		page.forEach(c -> System.out.println(c.getDetails()));
		
		end();
	}

}
