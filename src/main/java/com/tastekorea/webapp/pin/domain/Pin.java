package com.tastekorea.webapp.pin.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.tastekorea.webapp.common.domain.AppReply;
import com.tastekorea.webapp.common.domain.CommonEntity;
import com.tastekorea.webapp.member.domain.Region;
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
@Entity
public class Pin extends CommonEntity{
	   
	   @ManyToOne
	   @JoinColumn(name = "categoryId")
	   private PinCategory category;
	   
	   @ManyToOne
	   @JoinColumn(name = "memberId")
	   private TasteMember member;
	   
	   @ManyToOne
	   @JoinColumn(name = "regionId")
	   private Region region;
	   
	   @OneToMany(mappedBy = "masterId")
	   private List<AppReply> replyList;
	   
	   private String imagePath;
	   private String title;   
	   private String description;         //설명 (영어)
	   private String mapData;
	   
	   private int like;
	   private int dislike;
	   
	}


