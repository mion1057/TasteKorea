package com.tastekorea.webapp.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tastekorea.webapp.common.dao.AppReplyDao;
import com.tastekorea.webapp.common.domain.AppReply;


public class AppReplyServiceImpl implements AppReplyService {

	@Autowired
	private AppReplyDao appReplyDao;
	
	@Override
	public AppReply saveReply(AppReply reply) {
		long id = appReplyDao.saveReply(reply);
		reply.setId(id);
		
		return reply;
	}

	@Override
	public Page<AppReply> findParentRepliesByAppCode(int appCode, Pageable pageable) {
		// TODO Auto-generated method stub
		return appReplyDao.findParentRepliesByAppCode(appCode, pageable);
	}

}
