package com.tastekorea.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tastekorea.webapp.common.service.FileUploader;
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
import com.tastekorea.webapp.guide.web.controller.LoginCompanionController;
import com.tastekorea.webapp.main.web.controller.MainIndexController;
import com.tastekorea.webapp.user.dao.TravelerDao;
import com.tastekorea.webapp.user.service.TravelerService;
import com.tastekorea.webapp.user.service.TravelerServiceImpl;
import com.tastekorea.webapp.user.web.controller.AddTravelerController;
import com.tastekorea.webapp.user.web.controller.LoginTravelerController;

@Configuration
@ComponentScan(basePackages = "com.tastekorea.webapp")
public class AppConfig {

	@Bean
	public MainIndexController mainIndexController() {
		return new MainIndexController();
	}

	@Bean
	public FileUploader FileUploader() {
		return new FileUploader();
	}

	// ---------------------------
	// guide packages
	// ---------------------------

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
	
	@Bean
	public LoginCompanionController loginCompanionController() {
		return new LoginCompanionController();
	}

	// ---------------------------
	// user packages
	// ---------------------------
	
	@Bean
	public TravelerDao travelerDao() {
		return new TravelerDao();
	}
	
	@Bean
	public TravelerService travelerService() {
		return new TravelerServiceImpl();
	}
	
	@Bean
	public AddTravelerController addTravelerController() {
		return new AddTravelerController();
	}
	
	@Bean
	public LoginTravelerController loginTravelerController( ) {
		return new LoginTravelerController();
	}

}
