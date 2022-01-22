package com.tastekorea.webapp.common.web.command;

import com.tastekorea.webapp.common.domain.AppReply;
import com.tastekorea.webapp.member.domain.TasteMember;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppReplyCommand {
	private long replyId;
	private String comment;				//코멘트
	private int appCode;
	
	//작성자 정보 (get from userContainer)
	private long memberId;				//작성자 
	private String alias;				//작성자 별명
	
	//수신자 정보
	private String recipient;			//댓글 수신자
	private long parentId;				//댓글인 경우 0, 대댓글인 경우 부모 댓글id
	private long masterId;				//댓글의 콘텐츠 리소스 id
	
	public AppReply buildAppReply() {
		AppReply r = new AppReply();
		r.setAppCode(appCode);
		r.setComment(comment);
		r.setId(replyId);
		r.setMasterId(masterId);
		r.setMember(new TasteMember(masterId, alias, null));
		if(parentId == 0) {
			r.setParentId(null);
		}else {
			r.setParentId(parentId);
		}
		r.setRecipient(recipient);

		return r;
	}
	
}
