package com.tastekorea.webapp.pin.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.tastekorea.webapp.common.domain.CommonEntity;
import com.tastekorea.webapp.member.domain.TasteMember;

import lombok.Getter;
import lombok.Setter;

/**
 * companion이 등록하는 여행 프로그램
 * 
 * 
 * 
 * 				     		[PinImages]
 * 							   *|
 * 								|
 * 							   1|
 * [Companion]1 ------------ *[Pin]1 ------------ *[PinInterest]1 ------------ 1[PinCategory]
 * 		|1						|1
 * 		|						|
 * 		|*						|*	
 * [LanguageSkills]		    [PinReviews]
 * 
 * 
 * 
 * @author 'rohyh'
 *
 */

@Getter
@Setter
@Entity
public class Pin extends CommonEntity {

	// ------------------------
	//	Pin을 등록한 가이드 정보
	// ------------------------
	@ManyToOne
	@JoinColumn(name = "companionId")
	private TasteMember member;

	// ------------------------
	//	제목, 상세정보
	// ------------------------
	private String title;	
	private String details;
	
	// ------------------------
	//	지도 정보
	// ------------------------
	//@OneToOne
	//private PinMapData mapData;
	private String mapData;
	
	// ------------------------
	//	Pin에 등록된 사진들
	// ------------------------
	@OneToMany
	private List<PinImage> imageList = new ArrayList<>();

	// ------------------------
	//	미리 정의된 관련 특성,속성등을 선택하여
	//	정렬, 구분에 용이성
	// ------------------------
	@OneToMany
	private List<PinInterest> interestList = new ArrayList<>();

	// ------------------------
	//	리뷰
	// ------------------------
	@OneToMany
	private List<PinReview> reviewList = new ArrayList<>();
	
	public Pin() {
		super();
	}
	
	public Pin(long id) {
		this.id = id;
	}
	
	public Pin(String mapData) {
		this.mapData = mapData;
	}
	
	/**
	 * 전달된 PinImages를 Pin의 사진목록에 추가
	 * 
	 * @param image
	 */
	public void addPinImages(PinImage image) {
		if(!imageList.contains(image)) {
			image.setPin(this);
			imageList.add(image);
		}
	}
	
	/**
	 * 전달된 PinInterest를 Pin의 interest목록에 추가
	 * 
	 * @param image
	 */
	public void addPinInterest(PinInterest interest) {
		if(!interestList.contains(interest)) {
			interest.setPin(this);
			interestList.add(interest);
		}
	}
	
	/**
	 * 전달된 PinReview를 Pin의 review목록에 추가
	 * 
	 * @param image
	 */
	public void addReview(PinReview review) {
		if(!reviewList.contains(review)) {
			review.setPin(this);
			reviewList.add(review);
		}
	}
	
	/**
	 * getDetails
	 * 
	 * @return
	 */
	public String getDetails() {
		return "Pin [member=" + member.getId() + ", title=" + title 
				+ ", mapData=" + mapData + ", details=" + details + ", interestList=" + interestList 
				+ ", reviewList=" + reviewList + ", imageList=" + imageList + "]";
	}
	

}
