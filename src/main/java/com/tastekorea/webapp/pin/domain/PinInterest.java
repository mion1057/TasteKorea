package com.tastekorea.webapp.pin.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.tastekorea.webapp.common.domain.CommonEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * [Pin]1 ------------ *[PinInterest]1 ------------ 1[PinCategory]
 * 
 * @author holdv
 *
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "pinCategory", callSuper = false)
public class PinInterest extends CommonEntity{
	
	@ManyToOne
	@JoinColumn(name="pinId")
	private Pin pin;
	
	@OneToOne
	@JoinColumn(name="categoryId")
	private PinCategory pinCategory;

	public PinInterest() {
		super();
	}

	public PinInterest(Pin pin, PinCategory pinCategory) {
		super();
		this.pin = pin;
		this.pinCategory = pinCategory;
	}

	@Override
	public String toString() {
		return "PinInterest [pin=" + pin.getId() + ", category=" + pinCategory.getId() + "]";
	}
	
	
	
}
