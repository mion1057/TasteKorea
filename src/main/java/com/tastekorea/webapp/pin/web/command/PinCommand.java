package com.tastekorea.webapp.pin.web.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tastekorea.webapp.common.domain.AppReply;
import com.tastekorea.webapp.member.domain.Region;
import com.tastekorea.webapp.member.domain.TasteMember;
import com.tastekorea.webapp.pin.domain.PinCategory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PinCommand{
	
	private TasteMember member;
	private Region region;
	private String title;
	private PinCategory category;
	private List<AppReply> replyList;
	private MultipartFile imagePath;
	private String pinRegion;			//지역(ex: 서울, 대구)
	private String description;			//설명 (영어)
	private int like;
	private int dislike;
	private int readCount;
	
}
