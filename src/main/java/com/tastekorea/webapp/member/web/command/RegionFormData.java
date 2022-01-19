package com.tastekorea.webapp.member.web.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionFormData {
	private long regionId;
	private String region;
	private String eng;
	private String kor;

	public RegionFormData(long regionId, String region) {
		super();
		this.regionId = regionId;
		this.region = region;
	}
	
	
}
