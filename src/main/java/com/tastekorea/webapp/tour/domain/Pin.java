package com.tastekorea.webapp.tour.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.tastekorea.webapp.common.domain.CommonEntity;
import com.tastekorea.webapp.guide.domain.Companion;

import lombok.Getter;
import lombok.Setter;

/**
 * companion이 등록하는 여행 프로그램
 * 
 * 
 * [Companion]1 ------------ *[Pin]1 ------------ *[PinInterest]1 ------------ 1[PinCategory]
 * 								|1
 * 								|
 * 								|	
 * 								----------------- *[PinReviews]
 * 
 * 
 * 
 * @author holdv
 *
 */

@Getter
@Setter
@Entity
public class Pin extends CommonEntity {

	@ManyToOne
	@JoinColumn(name = "companionId")
	private Companion companion;

	// ------------------------
	//	주요 정보
	// ------------------------
	private String title;
	private String photo;
	private Double price;

	// ------------------------
	//	관련 특성,속성등을 미리 나열하여
	//	정렬, 구분에 용이성
	// ------------------------
	@OneToMany
	private PinInterest PinInterest;

	// ------------------------
	//	상세 정보
	// ------------------------
	private Double duration;
	private String location;
	private String details;

	// ------------------------
	//	리뷰
	// ------------------------
	@OneToMany
	private List<PinReview> pinReview = new ArrayList<>();
	
	public Pin() {
		super();
	}
	
	public Pin(long id) {
		this.id = id;
	}
}
