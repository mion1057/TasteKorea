package com.tastekorea.webapp.user.domain;

import javax.persistence.Entity;

import com.tastekorea.webapp.common.domain.CommonEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Traveler extends CommonEntity {
	private long id;
	private String email;
	private String passwd;
	private String name;
	
	public Traveler() {
		super();
	}
	
	
}

