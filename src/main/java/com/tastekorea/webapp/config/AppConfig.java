package com.tastekorea.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tastekorea.webapp.auth.web.controller.LoginController;
import com.tastekorea.webapp.common.service.FileUploader;
import com.tastekorea.webapp.common.service.UploadResourceManager;
import com.tastekorea.webapp.common.web.controller.AppReplyController;
import com.tastekorea.webapp.main.web.controller.MainIndexController;
<<<<<<< HEAD
=======
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
>>>>>>> ef9369a398f2db785d7e7d7c8bd396aaa2cfba39
import com.tastekorea.webapp.pin.web.controller.AddPinController;


/**
 * 
 * @author Sage R Lee
 *
 */
@Configuration
@ComponentScan(basePackages="com.tastekorea.webapp")
public class AppConfig {

	@Bean
	public MainIndexController mainIndexController(){
		return new MainIndexController();
	}
	
	//---------------------------
	//	 common module
	//---------------------------
	
	@Bean
	public AppReplyController appReplyController() {
		return new AppReplyController();
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
<<<<<<< HEAD

=======
	
>>>>>>> ef9369a398f2db785d7e7d7c8bd396aaa2cfba39
	@Bean
	public AddPinController addPinController() {
		return new AddPinController();
	}
	
<<<<<<< HEAD
	//---------------------------
	//		gallery module
	//---------------------------
	
	@Bean
	public LoginController loginController() {
		return new LoginController();
	}

=======
>>>>>>> ef9369a398f2db785d7e7d7c8bd396aaa2cfba39
}
