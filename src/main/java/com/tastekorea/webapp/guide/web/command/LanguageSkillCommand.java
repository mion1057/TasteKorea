package com.tastekorea.webapp.guide.web.command;

import com.tastekorea.webapp.guide.domain.ForeignLanguage;
import com.tastekorea.webapp.guide.domain.LanguageSkill;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LanguageSkillCommand {
	private long languageId;
	private String lang;
	private double skillLevel;
	
	public LanguageSkill build() {
		return new LanguageSkill(new ForeignLanguage(languageId), skillLevel);
	}
}
