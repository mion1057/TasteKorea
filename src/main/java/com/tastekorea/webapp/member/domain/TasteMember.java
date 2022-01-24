package com.tastekorea.webapp.member.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.tastekorea.webapp.common.domain.CommonEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 회원은 크게 가이드 회원과 여행자 회원으로 구분된다.
 * 
 * @author Sage R Lee
 *
 */
@Entity
@Getter
@Setter
@ToString
public class TasteMember extends CommonEntity{
	
	private Region region;			//지역(가이드), 국적(여행자)
	
	//------------------------
	//		로그인 정보
	//------------------------
	private String email;
	private String passwd;
	private boolean guide;			//가이드 여부
	
	//------------------------
	//		기본 신상 공통 정보
	//------------------------
	private String firstName;
	private String lastName;
	private char sex;				//필수정보(안전성)
	
	//------------------------
	//		가능한 언어 정보
	//------------------------
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<LanguageSkill> languageSkillList = new ArrayList<>();
	
	//------------------------
	//		가이드 필수 정보
	//------------------------
	private String phone;			//default null but (가이드 필수)
	private String ssn;				//default null but (가이드 필수)
	
	
	//------------------------
	//		기타 정보
	//------------------------
	private String profileImage;	//프로필 사진		(가이드 필수)
	private String introduction;	//자기 소개 및 PR	(가이드 필수)
	private String alias;			//별명
	
	
	public TasteMember() {
		super();
	}
	
	public TasteMember(long id) {
		super.id = id;
	}
	
	
	public TasteMember(long long1, String string) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 전달된 LanguageSkill을 회원의 사용가능 언어 목록에 추가
	 * 
	 * @param skill
	 */
	public void addLanguageSkill(LanguageSkill skill) {
		if(!languageSkillList.contains(skill)) {
			skill.setMember(this);
			languageSkillList.add(skill);
		}
	}
	
	
	/**
	 * 회원 타입에 맞는 이름 리턴
	 * 
	 * @return
	 */
	public String getName() {
		String name = null;
		if(firstName != null && lastName != null) {
			if(guide) {
				name = firstName + lastName;
			}else {
				name = lastName + " " + firstName;
			}
		}
		return name;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDetails() {
		return "TasteMember [email=" + email + ", passwd=" + passwd 
				+ ", name=" + getName() + ", phone=" + phone + ", ssn=" + ssn 
				+ ", sex=" + sex + ", profileImage=" + profileImage //+ ", provision=" + provision 
				+ ", introduction=" + introduction 
				+ ", languageSkillList=" + languageSkillList + "]";
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	public int getAge() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int birthYear = Integer.parseInt(ssn);
		
		return year - birthYear;
	}
}
