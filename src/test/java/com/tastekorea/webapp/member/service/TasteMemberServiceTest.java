package com.tastekorea.webapp.member.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.tastekorea.webapp.TasteTest;
import com.tastekorea.webapp.member.domain.TasteMember;

public class TasteMemberServiceTest extends TasteTest{
	
	@Autowired
	private TasteMemberService memberService;
	
	
	@Test
	public void getCompanionList() {
		start("getCompanionList");
		
		int pageNum = 1;
		Pageable pageable = PageRequest.of(pageNum, 3, 
				Sort.Direction.DESC, "regDate");
		Page<TasteMember> page = memberService.getMemberList(pageable);
		page.forEach(c -> System.out.println(c.getDetails()));
		
		end();
	}

}
