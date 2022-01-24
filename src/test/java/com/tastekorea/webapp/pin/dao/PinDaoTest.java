package com.tastekorea.webapp.pin.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;

import com.tastekorea.webapp.TasteTest;
import com.tastekorea.webapp.member.domain.Region;
import com.tastekorea.webapp.member.domain.TasteMember;
import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.domain.PinCategory;

public class PinDaoTest extends TasteTest {

	@Autowired
	private PinDao pinDao;
	
	@Test
	@Transactional
	public void save() {
		Pin pin = new Pin();
		pin.setMember(new TasteMember(15000003));
		pin.setRegion(new Region(10000001));
		pin.setCategory(new PinCategory(6000001));
		pin.setTitle("ㅋㅋ");
		pin.setImagePath("테스트 되나?.png");
		pin.setDescription("핀 등록 확인중");
		pin.setMapData("이거 뭔가 위경도로 나눠야 할텐데....");
		pin.setLike(0);
		pin.setDislike(0);
		
		long id = pinDao.save(pin);
		System.out.println("id = " + id);
	}
	
	@Test
	public void findById() {
		Pin pin = new Pin();
		pin.setMember(new TasteMember(15000003));
		pin.setRegion(new Region(10000001));
		pin.setCategory(new PinCategory(6000001));
		pin.setTitle("ㅋㅋ");
		pin.setImagePath("테스트 되나?.png");
		pin.setDescription("핀 등록 확인중");
		pin.setMapData("이거 뭔가 위경도로 나눠야 할텐데....");
		pin.setLike(0);
		pin.setDislike(0);
		
		long id = pinDao.save(pin);
		
		pinDao.findById(id);
	}
}
