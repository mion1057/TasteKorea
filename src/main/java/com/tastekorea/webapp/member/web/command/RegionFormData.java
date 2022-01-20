package com.tastekorea.webapp.member.web.command;

<<<<<<< HEAD
import com.tastekorea.webapp.member.domain.Region;

=======
>>>>>>> ef9369a398f2db785d7e7d7c8bd396aaa2cfba39
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionFormData {
	private long regionId;
	private String region;
	
<<<<<<< HEAD
=======
	
>>>>>>> ef9369a398f2db785d7e7d7c8bd396aaa2cfba39
	public RegionFormData(long regionId, String region) {
		super();
		this.regionId = regionId;
		this.region = region;
	}
	
	
}
