package com.tastekorea.webapp.tour.domain;

import javax.persistence.Entity;

import com.tastekorea.webapp.common.domain.CommonEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * Pin에 관련된 속성, 특성들을 미리 나열하여
 * 정렬, 조회, 구분등을 용이하게 하려고 함 
 * 
 * 
 * [Pin]1 ------------ *[PinInterest]1 ------------ 1[PinCategory]
 * 
 * 
 * ---------------
 * 카테고리 삽입 항목 *
 * ---------------
 * nature
 * city tour
 * snow activities
 * camping
 * hotel reserved
 * food
 * drinking
 * music
 * TV show / movies
 * history
 * activities for children
 * activities for couple
 * pets allowed
 * etc..
 *  
 *  
 * @author holdv
 *
 */
@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = true)
public class PinCategory extends CommonEntity {
	private String category;

	public PinCategory() {
		super();
	}
	
	public PinCategory(long id) {
		this.id = id;
	}
	
	public PinCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return category + "(" + super.id + ")";
	}	
}

