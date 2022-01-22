package com.tastekorea.webapp.common.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tastekorea.webapp.common.domain.AppReply;
import com.tastekorea.webapp.common.service.AppReplyManager;
import com.tastekorea.webapp.common.web.command.AppReplyCommand;

/**
 * 댓글처리
 * 
 * @author Kaminish
 *
 */
@Controller
public class AppReplyController {
	
	@Autowired
	private AppReplyManager appReplyManager;
	
	/**
	 * PinAlbum에 대한 댓글 추가
	 * 
	 * @param masterId
	 * @param rc
	 * @param request
	 * @return
	 */
	@PostMapping("/reply/{appDomain}/add/{masterId}")
	public ResponseEntity<?> addReply(@PathVariable String masterId, 
			@RequestBody AppReplyCommand rc, HttpServletRequest request){
		
		
		AppReply reply = rc.buildAppReply();
		AppReply dbReply = appReplyManager.addAppReply(reply);

		request.setAttribute("targetReply", dbReply);

		return ResponseEntity.status(HttpStatus.CREATED).body(dbReply);
	}
}
