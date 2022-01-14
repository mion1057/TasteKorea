package com.tastekorea.webapp.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.user.dao.TravelerDao;
import com.tastekorea.webapp.user.domain.Traveler;

import lombok.extern.slf4j.Slf4j;

@Service("travelerServiceImpl")
@Slf4j
public class TravelerServiceImpl implements TravelerService {

	@Autowired
	private TravelerDao travelerDao;
	
	@Override
	public Traveler addTraveler(Traveler traveler) {
		
		return travelerDao.add(traveler);
	}
	
	@Override
	public List<Traveler> getAllTravelers(Traveler traveler) {
		return travelerDao.findAll(traveler);
	}
	
	@Override
	public Traveler getTravelerByEmail(String email) {
		return travelerDao.findByEmail(email);
	}
	
	/**
	 * email 중복검사
	 */
	@Override
	public boolean isEmailCheck(String email) {
		System.out.println("이메일체크 서비스 들어오나요?");
		return travelerDao.isEmailCheck(email);
	}

	@Override
	public Traveler loginUser(String email) {
		return travelerDao.findByEmail(email);
	}

	@Override
	public boolean isTraveler(String email, String passwd) {
		if(email.equals(null) && passwd.equals(null)) {
			return false;
		}
		return true;
	}
	

	
}
