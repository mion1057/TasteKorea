package com.tastekorea.webapp.common.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.tastekorea.webapp.common.dao.TasteDao;
import com.tastekorea.webapp.common.domain.AppReply;




public class AppReplyDao extends TasteDao{
   
   private static final String SELECT = "";
   
   @Autowired
   private JdbcTemplate jdbcTemplate;
   
   
   /**
    * 
    * @param reply
    * @return
    */
   public long saveReply(AppReply reply) {
      String sql = "INSERT INTO AppReply(parentId, memberId, appCode, comment, recipient, "
            + "priority, likeCount, dislikeCount) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

      KeyHolder keyHolder = new GeneratedKeyHolder();
      PreparedStatementCreator preparedStatementCreator = (connection) -> {
         PreparedStatement pstmt = connection.prepareStatement(sql, new String[] { "id" });
         System.out.println("pstmt: " + pstmt);
         System.out.println("reply: " + reply);
         pstmt.setLong(1, reply.getParentId());
         pstmt.setLong(2, reply.getMember().getId());
         pstmt.setInt(3, reply.getAppCode());
         pstmt.setString(4, reply.getComment());
         pstmt.setString(5, reply.getRecipient());
         pstmt.setInt(6, reply.getPriority());
         pstmt.setInt(7, reply.getLikeCount());
         pstmt.setInt(8, reply.getDislikeCount());
         return pstmt;
      };
      jdbcTemplate.update(preparedStatementCreator, keyHolder);
      return keyHolder.getKey().longValue();

   }
   
   
   /**
    * 
    * @param appCode
    * @param pageable
    * @return
    */
   public Page<AppReply> findParentRepliesByAppCode(int appCode, Pageable pageable){
      String sql = pagingQuery(SELECT + " WHERE r.appCode=? AND r.parentId IS NULL", pageable);
      List<AppReply> list = jdbcTemplate.query(sql, new AppReplyRowMapper());

      return new PageImpl<AppReply>(list, pageable, count("AppReply"));
   }
}

