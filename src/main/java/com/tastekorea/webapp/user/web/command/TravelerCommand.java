package com.tastekorea.webapp.user.web.command;

import com.tastekorea.webapp.user.domain.Traveler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TravelerCommand {
	// ------------------------
	// 로그인 정보
	// ------------------------
	private String email;
	private String passwd;

	// ------------------------
	// 기본 신상 정보
	// ------------------------
	private String name;

	public Traveler buildTraveler() {
		Traveler t = new Traveler();
		t.setEmail(this.email);
		t.setPasswd(this.passwd);
		t.setName(name);

		return t;
	}
}
