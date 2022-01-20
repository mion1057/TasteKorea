package com.tastekorea.webapp.pin.web.command;

import org.springframework.web.multipart.MultipartFile;

import com.tastekorea.webapp.member.domain.TasteMember;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PinCommand{
	
	private TasteMember member;
	private MultipartFile imagePath;
	private String pinRegion;			//지역(ex: 서울, 대구)
	private String description;			//설명 (영어)
	private int like;
	private int dislike;
	private int readCount;
	
}
