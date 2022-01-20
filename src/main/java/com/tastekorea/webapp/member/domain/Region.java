<<<<<<< HEAD
package com.tastekorea.webapp.member.domain;

import com.tastekorea.webapp.common.domain.CommonEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Region extends CommonEntity{
	private String kor;
	private String eng;
	private boolean guide;
	
	public Region() {
		super();
	}
	
	public Region(long id) {
		super.id = id;
	}
	
	
	public Region(String kor, String eng, boolean guide) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.guide = guide;
	}
	
	
}
=======
package com.tastekorea.webapp.member.domain;

import com.tastekorea.webapp.common.domain.CommonEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Region extends CommonEntity{
	private String kor;
	private String eng;
	private boolean guide;
	
	public Region() {
		super();
	}
	
	public Region(long id) {
		super.id = id;
	}
	
	
	public Region(String kor, String eng, boolean guide) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.guide = guide;
	}
	
	
}
>>>>>>> ef9369a398f2db785d7e7d7c8bd396aaa2cfba39
