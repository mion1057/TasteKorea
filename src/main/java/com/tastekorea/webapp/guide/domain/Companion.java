package com.tastekorea.webapp.guide.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.tastekorea.webapp.common.domain.CommonEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * tastekorea에 등록하여 여행 가이드 역할을 하는 사람
 * 
 * [Companion]1 ------------ *[LanguageSkill]1 ----------- 1[Language]
 * 
 * @author Sage R Lee
 *
 */

@Entity
@Getter
@Setter
public class Companion extends CommonEntity{
	
	
	//------------------------
	//		로그인 정보
	//------------------------
	private String email;
	private String passwd;
	
	//------------------------
	//		기본 신상 정보
	//------------------------	
	private String name;
	private String phone;
	private String ssn;
	private char sex;
	private String region;
	private String photo;
	
	//------------------------
	//		가능한 언어 정보
	//------------------------
	@OneToMany(mappedBy = "companion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<LanguageSkill> languageSkillList = new ArrayList<>();
	

	//------------------------
	//		제공가능한 서비스
	//------------------------
	private String provision;	//ex) 운전가능
	
	//------------------------
	//		기타
	//------------------------
	private String introduction;	//자기 소개 및 PR;
	
	public Companion() {
		super();
	}
	
	public Companion(long id) {
		this.id = id;
	}
	
	
	/**
	 * 
	 * @param skill
	 */
	public void addLanguageSkill(LanguageSkill skill) {
		if(!languageSkillList.contains(skill)) {
			skill.setCompanion(this);
			languageSkillList.add(skill);
		}
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getDetails() {
		return "Companion [email=" + email + ", passwd=" + passwd 
				+ ", name=" + name + ", phone=" + phone + ", ssn=" + ssn 
				+ ", sex=" + sex + ", photo=" + photo //+ ", provision=" + provision 
				+ ", introduction=" + introduction 
				+ ", languageSkillList=" + languageSkillList + "]";
	}
	
	
}
