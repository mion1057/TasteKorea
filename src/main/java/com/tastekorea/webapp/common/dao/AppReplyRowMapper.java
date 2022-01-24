package com.tastekorea.webapp.common.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.common.domain.AppReply;
import com.tastekorea.webapp.member.domain.TasteMember;

/**
 * 
 * @author "rohyh"
 *
 */
public class AppReplyRowMapper implements RowMapper<AppReply> {
   
   @Override
   public AppReply mapRow(ResultSet rs, int rowNum) throws SQLException {
      AppReply appReply = new AppReply();
      appReply.setId(rs.getLong("id"));
      appReply.setParentId(rs.getLong("parentId"));
      appReply.setMember(new TasteMember(rs.getLong("memberId")));
      appReply.setAppCode(rs.getInt("appCode"));
      appReply.setComment(rs.getString("comment"));
      appReply.setRecipient(rs.getString("recipient"));
      appReply.setPriority(rs.getInt("priority"));
      appReply.setLikeCount(rs.getInt("likeCount"));
      appReply.setDislikeCount(rs.getInt("dislikeCount"));
      appReply.setRegDate(rs.getTimestamp("regDate"));
      appReply.setUpdateDate(rs.getTimestamp("updateDate"));
      
      return appReply;
   }

}