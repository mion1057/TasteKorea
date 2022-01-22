package com.tastekorea.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tastekorea.webapp.board.dao.ArticleDao;
import com.tastekorea.webapp.board.service.ArticleService;
import com.tastekorea.webapp.board.service.ArticleServiceImpl;
import com.tastekorea.webapp.board.web.controller.AddArticleController;
import com.tastekorea.webapp.board.web.controller.ListArticleController;
import com.tastekorea.webapp.common.dao.AppHitDao;
import com.tastekorea.webapp.common.dao.AppReplyDao;
import com.tastekorea.webapp.common.service.AppReplyManager;
import com.tastekorea.webapp.common.service.FileUploader;
import com.tastekorea.webapp.common.service.UploadResourceManager;
import com.tastekorea.webapp.common.web.controller.AppReplyController;
import com.tastekorea.webapp.main.web.controller.MainIndexController;
import com.tastekorea.webapp.member.dao.ForeignLanguageDao;
import com.tastekorea.webapp.member.dao.LanguageSkillDao;
import com.tastekorea.webapp.member.dao.RegionDao;
import com.tastekorea.webapp.member.dao.TasteMemberDao;
import com.tastekorea.webapp.member.service.ForeignLanguageService;
import com.tastekorea.webapp.member.service.ForeignLanguageServiceImpl;
import com.tastekorea.webapp.member.service.LanguageSkillServiceImpl;
import com.tastekorea.webapp.member.service.RegionService;
import com.tastekorea.webapp.member.service.RegionServiceImpl;
import com.tastekorea.webapp.member.service.TasteMemberService;
import com.tastekorea.webapp.member.service.TasteMemberServiceImpl;
import com.tastekorea.webapp.member.web.controller.AddMemberController;
import com.tastekorea.webapp.member.web.controller.GetMemberController;
import com.tastekorea.webapp.pin.service.PinService;
import com.tastekorea.webapp.pin.service.PinServiceImpl;
import com.tastekorea.webapp.pin.web.controller.AddPinController;


/**
 * 
 * @author Sage R Lee
 *
 */
@Configuration
@ComponentScan(basePackages="com.tastekorea.webapp")
public class AppConfig {
	
	//---------------------------
	//	 common module
	//---------------------------
	
	@Bean
	public AppReplyDao appReplyDao() {
		return new AppReplyDao();
	}
	
	@Bean
	public AppReplyManager appReplyManager() {
		return new AppReplyManager();
	}
	
	@Bean
	public AppReplyController appReplyController() {
		return new AppReplyController();
	}
	
	@Bean
	public AppHitDao appHitDao() {
		return new AppHitDao();
	}

	@Bean
	public MainIndexController mainIndexController(){
		return new MainIndexController();
	}

	
	//---------------------------
	//	 file upload module
	//---------------------------
	
	@Bean
	public FileUploader fileUploader() {
		return new FileUploader();
	}
	
	@Bean
	public UploadResourceManager uploadResourceManager() {
		return new UploadResourceManager();
	}
	

	
	//---------------------------
	//		member module
	//---------------------------
	
	@Bean
	public RegionDao regionDao() {
		return new RegionDao();
	}
	
	@Bean
	public RegionService regionServiceImpl() {
		return new RegionServiceImpl();
	}
	
	
	@Bean
	public ForeignLanguageDao foreignLanguageDao() {
		return new ForeignLanguageDao();
	}
	
	@Bean
	public TasteMemberDao tasteMemberDao() {
		return new TasteMemberDao();
	}
	
	@Bean
	public LanguageSkillDao languageSkillDao() {
		return new LanguageSkillDao();
	}
	
	@Bean
	public ForeignLanguageService foreignLanguageServiceImpl() {
		return new ForeignLanguageServiceImpl();
	}
	
	@Bean
	public TasteMemberService tasteMemberServiceImpl() {
		return new TasteMemberServiceImpl();
	}
	
	@Bean
	public LanguageSkillServiceImpl languageSkillServiceImpl() {
		return new LanguageSkillServiceImpl();
	}
	
	@Bean
	public AddMemberController addMemberController() {
		return new AddMemberController();
	}
	
	@Bean
	public GetMemberController getMemberController() {
		return new GetMemberController();
	}
	
	//---------------------------
	//		pin module
	//---------------------------
	
	@Bean
	public PinService pinServiceImpl() {
		return new PinServiceImpl();
	}
	
	@Bean
	public AddPinController addPinController() {
		return new AddPinController();
	}
	
	//---------------------------
	//		 Board module
	//---------------------------
	
	@Bean
	public ArticleDao articleDao() {
		return new ArticleDao();
	}
	
	@Bean
	public ArticleService articleServiceImpl() {
		return new ArticleServiceImpl();
	}
	
	@Bean 
	public AddArticleController addArticleController() {
		return new AddArticleController();
	}
	
	@Bean 
	public ListArticleController listArticleController() {
		return new ListArticleController();
	}
	
	
}
