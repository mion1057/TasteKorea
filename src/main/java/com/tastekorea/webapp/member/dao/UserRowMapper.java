package com.tastekorea.webapp.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.auth.web.command.User;
import com.tastekorea.webapp.guide.web.command.Region;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setEmail(rs.getString("email"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setSex(rs.getString("sex").charAt(0));
		user.setPhone(rs.getString("phone"));
		user.setProfileImage(rs.getString("profileImage"));
		user.setIntroduction(rs.getString("introduction"));
		user.setRegion(new Region(rs.getString("kor"), rs.getString("eng"),
				rs.getBoolean("r_guide")));
		return user;
	}

}
