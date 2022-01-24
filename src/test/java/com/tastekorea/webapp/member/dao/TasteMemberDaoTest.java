package com.tastekorea.webapp.member.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tastekorea.webapp.TasteTest;
import com.tastekorea.webapp.member.domain.Region;
import com.tastekorea.webapp.member.domain.TasteMember;

public class TasteMemberDaoTest extends TasteTest {
	
	@Autowired
	private TasteMemberDao tasteMemberDao;
	
	@Test
	@Transactional
	public void save() {
		TasteMember member = new TasteMember();
		member.setEmail("mion1057@naver.com");
		member.setPasswd("11112222");
		member.setGuide(true);
		member.setFirstName("성미");
		member.setLastName("임");
		member.setPhone("010-1111-2222");
		member.setSex('F');
		member.setSsn("111111");
		member.setProfileImage("eeeeeeeeeeee");
		member.setIntroduction("ddddddd");
		Region region = new Region();
		region.setId(10000001);
		member.setRegion(new Region(10000001));
		
		long id = tasteMemberDao.save(member);
		
		System.out.println("id =" + id);
	}
}
