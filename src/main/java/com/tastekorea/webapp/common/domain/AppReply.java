package com.tastekorea.webapp.common.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tastekorea.webapp.member.domain.TasteMember;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppReply extends CommonEntity{
   
   @ManyToOne
   @JoinColumn(name="memberId")
   private TasteMember member;            //작성자      
   
   private String comment;               //댓글내용
   private String recipient;            //댓글 수신자 별명
   private int priority;
   private String alias;
   private int likeCount;               //좋아요, 추천 수
   private int dislikeCount;            //싫어요
   
   //부모 댓글 id
   //댓글과 대댓글의 구분을 부모 댓글 id 존재 유무로 판단한다.
   // NULL값을 가질 수 있는 FK이어야 한다.
   private Long parentId;
   private Long masterId;
   private int appCode;
}