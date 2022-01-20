package com.tastekorea.webapp.auth.web.command;

import com.tastekorea.webapp.common.domain.CommonEntity;
import com.tastekorea.webapp.member.domain.Region;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends CommonEntity {
	
	//------------------------
	//		기본 신상 공통 정보
	//------------------------
	private String email;
	private String firstName;
	private String lastName;
	private char sex;
	private Region region;
	
	//------------------------
	//		가이드 필수 정보
	//------------------------
	private String phone;
	private String ssn;
	private String profileImage;
	private String introduction;
}
