package com.tastekorea.webapp.pin.domain;

import javax.persistence.Entity;

import com.tastekorea.webapp.common.domain.CommonEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class PinCategory extends CommonEntity {

	private String kor;
	private String eng;

	public PinCategory() {
		super();
	}

	public PinCategory(long id) {
		this.id = id;
	}

	public PinCategory(String kor, String eng) {
		super();
		this.kor = kor;
		this.eng = eng;
	}

}
