package com.tastekorea.webapp.guide.web.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Region {
	private String eng;
	private String kor;
	
	
	public Region(String eng, String kor) {
		super();
		this.eng = eng;
		this.kor = kor;
	}
	
	
}
