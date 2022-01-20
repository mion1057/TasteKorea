package com.tastekorea.webapp.pin.domain;

import javax.persistence.ManyToOne;

import com.tastekorea.webapp.common.domain.CommonEntity;
import com.tastekorea.webapp.member.domain.TasteMember;

import lombok.Getter;
import lombok.Setter;


/**
 * 사진에 대한 설명, 지역, 날짜, 댓글, 좋아요
 * 
 * @author Kaminish
 *
 */
@Getter
@Setter
public class Pin extends CommonEntity{
	
	@ManyToOne
	private TasteMember member;
	private String imagePath;
	private String pinRegion;			//지역(ex: 서울, 대구)
	private String description;			//설명 (영어)
	private int like;
	private int dislike;
<<<<<<< HEAD
	private int readCount;
=======
>>>>>>> ef9369a398f2db785d7e7d7c8bd396aaa2cfba39
	
}
