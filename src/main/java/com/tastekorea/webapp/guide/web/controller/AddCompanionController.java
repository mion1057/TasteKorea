package com.tastekorea.webapp.guide.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tastekorea.webapp.common.service.FileUploader;
import com.tastekorea.webapp.guide.domain.Companion;
import com.tastekorea.webapp.guide.domain.ForeignLanguage;
import com.tastekorea.webapp.guide.service.CompanionService;
import com.tastekorea.webapp.guide.service.ForeignLanguageService;
import com.tastekorea.webapp.guide.web.command.CompanionCommand;
import com.tastekorea.webapp.guide.web.command.Language;
import com.tastekorea.webapp.guide.web.command.LanguageSkillCommand;
import com.tastekorea.webapp.guide.web.command.Region;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AddCompanionController {
	
	@Autowired
	@Qualifier("companionServiceImpl")
	private CompanionService companionService;
	
	@Autowired
	@Qualifier("foreignLanguageServiceImpl")
	private ForeignLanguageService languageService;
	
	@Autowired
	private FileUploader fileUploader;
	
	/**
	 * 
	 * @param companionCommand
	 * @return
	 */
	@GetMapping("/guide/companion/add")
	public String addCompanion(CompanionCommand companionCommand) {
		return "guide/companion/add_companion";
	}
	
	
	/**
	 * 
	 * @param companionCommand
	 * @param model
	 * @return
	 */
	@PostMapping("/guide/companion/add")
	public String addCompanion(CompanionCommand companionCommand, Model model) {
		//1. Companion 기본값 등록
		Companion c = new Companion();
		c.setEmail(companionCommand.getEmail());
		c.setPasswd(companionCommand.getPasswd());
		c.setName(companionCommand.getName());
		c.setPhone(companionCommand.getPhone());
		c.setSsn(companionCommand.getSsn());
		c.setSex(companionCommand.getSex());
		c.setRegion(companionCommand.getRegion());
		//c.setProvision(companionCommand.getProvision());
		c.setIntroduction(companionCommand.getIntroduction());
		
		//2. Companion의 LangugeSkill 목록 등록
		List<LanguageSkillCommand> lsList = companionCommand.getLanguageSkillCommandList();
		for(LanguageSkillCommand ls : lsList) {
			if(ls.getLanguageId() != 0) {
				c.addLanguageSkill(ls.build());
			}
		}
		//3. Companion의 이미지 등록
		log.debug("companionCommand.getPhotoFile(): " + companionCommand.getPhotoFile());
		System.out.println("companionCommand.getPhotoFile(): " + companionCommand.getPhotoFile());
		c.setPhoto(fileUploader.fileUpload(companionCommand.getPhotoFile()));
		
		c = companionService.addCompanion(c);
		model.addAttribute("companion", c);
		
		return "guide/companion/welcome_companion";
	}
	
	
	/**
	 * 
	 * @return
	 */
	@ModelAttribute("foreignLanguageList")
	public List<Language> getAllLanguages(){
		List<Language> list = new ArrayList<>();
		List<ForeignLanguage> langList = languageService.getAll();
		for(ForeignLanguage fl : langList) {
			list.add(new Language(fl.getId(), fl.getLang()));
		}
		
		return list;
	}
	
	
	/**
	 * 
	 * @return
	 */
	@ModelAttribute("languageLevelList")
	public List<String> getAllLevels(){
		List<String> list = new ArrayList<>();
		list.add("5");
		list.add("4.5");
		list.add("4");
		list.add("3.5");
		list.add("3");
		list.add("2.5");
		list.add("2");
		list.add("1.5");
		list.add("1");
		return list;
	}	
	
	
	/**
	 * 
	 * @return
	 */
	@ModelAttribute("regionList")
	public List<Region> getAllRegions(){
		List<Region> list = new ArrayList<>();
		list.add(new Region("Seoul", "서울"));
		list.add(new Region("Busan", "부산"));
		list.add(new Region("Daegu", "대구"));
		list.add(new Region("Gwangju", "광주"));
		list.add(new Region("Jeju", "제주"));
		list.add(new Region("Incheon", "인천"));
		list.add(new Region("Chuncheon", "춘천"));
		list.add(new Region("Pyungyang", "평양"));
		
		return list;
	}
	
	
	
}
