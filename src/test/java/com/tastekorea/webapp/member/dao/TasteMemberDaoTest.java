package com.tastekorea.webapp.member.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.tastekorea.webapp.TasteTest;
import com.tastekorea.webapp.member.domain.Region;
import com.tastekorea.webapp.member.domain.TasteMember;

public class TasteMemberDaoTest extends TasteTest{
	
	@Autowired
	private TasteMemberDao memberDao;
	
	
	@Test
	public void findByEmail() {
		start("findByEmail");
		
		TasteMember member = memberDao.findByEmail("java@sun.com");
		System.out.println(member.getDetails());
		
		end();
	}
	
	
	@Test
	@Transactional
	public void add() {
		start("add");
		
		TasteMember member = new TasteMember();
		member.setEmail("spring@sun.com");
		member.setPasswd("1111");
		member.setFirstName("관");
		member.setLastName("우");
		member.setPhone("01022224444");
		member.setSsn("878787");
		member.setRegion(new Region(10000001));
		member.setIntroduction("소개");
		member.setSex('M');
		
		long id = memberDao.save(member);
		System.out.println("new generated id : " + id);
		
		end();
	}
	
	@Test
	@Transactional
	@Commit
	public void save() {
		start("save");
		
		TasteMember member = new TasteMember();
		member.setEmail("java@sun.com");
		member.setPasswd("1111");
		member.setGuide(true);
		member.setFirstName("유");
		member.setLastName("비");
		member.setPhone("01022224444");
		member.setSsn("901103");
		member.setSex('M');
		member.setIntroduction("소개");
		member.setRegion(new Region(10000001));
		
		long id = memberDao.save(member);
		System.out.println("dbTasteMember : " + id);
		
		end();
	}
	
	@Test
	public void findAll(){
		start("findAll");
		
		Pageable pageable = PageRequest.of(0, 2, Direction.DESC, "regDate");
		Page<TasteMember> page = memberDao.findAll(pageable);
		page.forEach(c -> System.out.println(c.getDetails()));
		
		end();
	}
}
