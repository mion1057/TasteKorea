package com.tastekorea.webapp.pin.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.tastekorea.webapp.common.domain.CommonEntity;
import com.tastekorea.webapp.member.domain.TasteMember;

import lombok.Getter;
import lombok.Setter;

/**
 * traveler가 경험한 pin에 대한 review 등록
 * 
 * [Traveler]* ------------ 1[Review]* ------------ 1[Pin]
 * 	
 * 
 * @author holdv
 *
 */

@Entity
@Getter
@Setter
public class PinReview extends CommonEntity{
	
	// ------------------------
	//	FK
	// ------------------------
	@OneToMany
	@JoinColumn(name="pinId")
	private Pin pin;
	
	@ManyToOne
	@JoinColumn(name="travelerId")
	private TasteMember tasteMember;
	
	// ------------------------
	//	별점 및 후기글
	// ------------------------
	private double rating;	
	private String review;
	
	public PinReview() {
		super();
	}

	@Override
	public String toString() {
		return "PinReview [pin=" + pin.getId() + ", tasteMember=" + tasteMember .getId()
				+ ", ratings=" + rating + ", review=" + review
				+ "]";
	}
	
	
}
