package com.tastekorea.webapp.guide.domain;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * 언어를 제외한 가이드가 제공할 수 있는 서비스를 기술한다.
 * ex) 운전가능
 * 
 * @author Sage R Lee
 *
 */
@Getter
@Setter
public class Provision {
	private long pid;
	private Companion companion;
	private Map<String, Boolean> map;
}
