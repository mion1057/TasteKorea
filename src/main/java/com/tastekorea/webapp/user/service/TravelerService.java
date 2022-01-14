package com.tastekorea.webapp.user.service;

import java.util.List;

import com.tastekorea.webapp.user.domain.Traveler;

public interface TravelerService {
	
	Traveler addTraveler(Traveler traveler);
	
	List<Traveler> getAllTravelers(Traveler traveler);
	
	Traveler getTravelerByEmail(String email);
	
	boolean isEmailCheck(String email);

	Traveler loginUser(String email);

	boolean isTraveler(String email, String passwd);
	
}
