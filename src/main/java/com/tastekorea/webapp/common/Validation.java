package com.tastekorea.webapp.common;

import org.springframework.stereotype.Component;

@Component("validation")
public class Validation {
	//input 값 비었을 때(문자열일 경우)
	public boolean isEmpty(Object obj) {
		if(obj == null || obj.equals("")) {
			return true;
		}
		return false;
	}
	//input 값 비었을 때(double일 경우)
	public boolean isEmpty(double d) {
		if(d == 0) {
			return true;
		}
		return false;
	}
	//input값 비었을 때(long인 경우 \)
	public boolean isEmpty(long l) {
		if(l == 0) {
			return true;
		}
		return false;
	}
	// 한글이 들어가야 하는데에에에 숫자가 들어갔을 때에에에에
	public boolean isNumber(String str) {
		char tmp = 0;
		for(int i = 0; i < str.length(); i++) {
			tmp = str.charAt(i);
		}
		if(tmp >= 0 && tmp <= 9) {
			return true;
		}
		
		return false;
	}
}
