package com.tastekorea.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tastekorea.webapp.auth.web.controller.LoginController;
import com.tastekorea.webapp.common.service.FileUploader;
import com.tastekorea.webapp.common.service.UploadResourceManager;
import com.tastekorea.webapp.guide.dao.CompanionDao;
import com.tastekorea.webapp.guide.dao.ForeignLanguageDao;
import com.tastekorea.webapp.guide.dao.LanguageSkillDao;
import com.tastekorea.webapp.guide.service.CompanionService;
import com.tastekorea.webapp.guide.service.CompanionServiceImpl;
import com.tastekorea.webapp.guide.service.ForeignLanguageService;
import com.tastekorea.webapp.guide.service.ForeignLanguageServiceImpl;
import com.tastekorea.webapp.guide.service.LanguageSkillServiceImpl;
import com.tastekorea.webapp.guide.web.controller.AddCompanionController;
import com.tastekorea.webapp.guide.web.controller.GetCompanionController;
import com.tastekorea.webapp.main.web.controller.MainIndexController;

@Configuration
@ComponentScan(basePackages="com.tastekorea.webapp")
public class AppConfig {

	@Bean
	public MainIndexController mainIndexController(){
		return new MainIndexController();
	}
	
	@Bean
	public FileUploader FileUploader() {
		return new FileUploader();
	}
	
	@Bean
	public UploadResourceManager uploadResourceManager() {
		return new UploadResourceManager();
	}
	
	//---------------------------
	//		guide packages
	//---------------------------
	
	@Bean
	public ForeignLanguageDao foreignLanguageDao() {
		return new ForeignLanguageDao();
	}
	
	@Bean
	public CompanionDao companionDao() {
		return new CompanionDao();
	}
	
	@Bean
	public LanguageSkillDao languageSkillDao() {
		return new LanguageSkillDao();
	}
	
	@Bean
	public ForeignLanguageService ForeignLanguageService() {
		return new ForeignLanguageServiceImpl();
	}
	
	@Bean
	public CompanionService companionService() {
		return new CompanionServiceImpl();
	}
	
	@Bean
	public LanguageSkillServiceImpl languageSkillServiceImpl() {
		return new LanguageSkillServiceImpl();
	}
	
	@Bean
	public AddCompanionController addCompanionController() {
		return new AddCompanionController();
	}
	
	@Bean
	public GetCompanionController getCompanionController() {
		return new GetCompanionController();
	}
<<<<<<< Updated upstream
=======
	
	@Bean
	public AddPinController addPinController() {
		return new AddPinController();
	}
	
	//---------------------------
	//		gallery module
	//---------------------------
	
	@Bean
	public LoginController loginController() {
		return new LoginController();
	}
>>>>>>> Stashed changes
}
