package com.tastekorea.webapp.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tastekorea.webapp.common.domain.AppReply;
import com.tastekorea.webapp.main.web.command.AppReplyCommand;

public interface AppReplyService {

		Page<AppReply> findParentRepliesByAppCode(int appCode, Pageable pageable);

		AppReply saveReply(AppReply reply);
		
}
