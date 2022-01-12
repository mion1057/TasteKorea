package com.tastekorea.webapp.guide.domain;

import javax.persistence.Entity;

import com.tastekorea.webapp.common.domain.CommonEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * 가이드가 구사할 수 있는 언어
 * @author Sage R Lee
 *
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ForeignLanguage extends CommonEntity{
	private String lang;	//언어
	
	public ForeignLanguage() {
		super();
	}
	
	public ForeignLanguage(long id) {
		super.id = id;
	}
	
	public ForeignLanguage(String lang) {
		this.lang = lang;
	}

	@Override
	public String toString() {
		return lang + "(" + super.id + ")";
	}

	
}
