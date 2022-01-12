package com.tastekorea.webapp.guide.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;

import com.tastekorea.webapp.TasteTest;
import com.tastekorea.webapp.guide.domain.Companion;

public class CompanionDaoTest extends TasteTest{
	
	@Autowired
	private CompanionDao companionDao;
	
	
	@Test
	public void findByEmail() {
		start("findByEmail");
		
		Companion companion = companionDao.findByEmail("java");
		System.out.println(companion.getDetails());
		
		end();
	}
	
	
	@Test
	@Transactional
	public void add() {
		start("add");
		
		Companion companion = new Companion();
		companion.setEmail("spring@sun.com");
		companion.setPasswd("1111");
		companion.setName("관우");
		companion.setPhone("01022224444");
		companion.setSsn("878787");
		companion.setRegion("서울");
		companion.setIntroduction("소개");
		companion.setSex('M');
		
		long id = companionDao.add(companion);
		System.out.println("new generated id : " + id);
		
		end();
	}
	
	@Test
	@Transactional
	public void save() {
		start("save");
		
		Companion companion = new Companion();
		companion.setEmail("spring@sun.com");
		companion.setPasswd("1111");
		companion.setName("관우");
		companion.setPhone("01022224444");
		companion.setSsn("878787");
		companion.setRegion("서울");
		companion.setIntroduction("소개");
		companion.setSex('M');
		
		Companion dbCompanion = companionDao.save(companion);
		System.out.println("dbCompanion : " + dbCompanion.getId());
		
		end();
	}
	
	@Test
	public void findAll(){
		start("findAll");
		
		Pageable pageable = PageRequest.of(0, 2, Direction.DESC, "regDate");
		Page<Companion> page = companionDao.findAll(pageable);
		page.forEach(c -> System.out.println(c.getDetails()));
		
		end();
	}
}
