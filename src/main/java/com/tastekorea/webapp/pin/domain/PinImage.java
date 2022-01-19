package com.tastekorea.webapp.pin.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.tastekorea.webapp.common.domain.CommonEntity;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * pin 상세정보에 들어갈 사진들
 * 
 * @author "rohyh"
 *
 */

@Getter
@Setter
@Entity
public class PinImage extends CommonEntity {
	
	@ManyToOne
	private Pin pin;
	
	private String photo;

	public PinImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PinImage(long id) {
		this.id = id;
	}
	
	public PinImage(Pin pin, String photo) {
		super();
		this.pin = pin;
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "PinImages [pin=" + pin.getId() + ", photo=" + photo + "]";
	}
	
	
}
