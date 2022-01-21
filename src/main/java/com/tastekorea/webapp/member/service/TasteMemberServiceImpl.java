package com.tastekorea.webapp.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.auth.web.LoginFailException;
import com.tastekorea.webapp.auth.web.command.User;
import com.tastekorea.webapp.member.dao.TasteMemberDao;
import com.tastekorea.webapp.member.domain.LanguageSkill;
import com.tastekorea.webapp.member.domain.TasteMember;


/**
 * 
 * @author Sage R Lee
 *
 */
@Service
public class TasteMemberServiceImpl implements TasteMemberService {
	
	@Autowired
	private TasteMemberDao memberDao; 
	
	@Autowired
	private LanguageSkillService languageSkillService;
	
	/**
	 * Member정보 LanguageSkill 정보를 함께 저장
	 * 
	 * @param member
	 * @return
	 */
	@Override
	public TasteMember addMember(TasteMember member) {
		//1.TasteMember 저장
		long id = memberDao.save(member);
		member.setId(id);
		
		//2.LanguageSkill 목록 저장
		List<LanguageSkill> skillList = member.getLanguageSkillList();
		for(LanguageSkill ls : skillList) {
			ls.setMember(member);
			languageSkillService.addLanguageSkill(ls);
		}
		return member;
	}
	
	
	/**
	 * 가이드 상세보기
	 * @param id
	 * @return
	 */
	@Override
	public TasteMember getMember(long id) {
		TasteMember member = memberDao.findById(id);
		List<LanguageSkill> skillList = languageSkillService.
				getLanguageSkillListByMember(member);
		member.setLanguageSkillList(skillList);
		
		return member;
	}
	
	
	/**
	 * 가이드 목록 조회
	 * 
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<TasteMember> getMemberList(Pageable pageable){
		return memberDao.findAll(pageable);
	}
	
	
	/**
	 * 가이드 목록 조회
	 * 
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<TasteMember> getCompanionList(Pageable pageable){
		return memberDao.findAllCompanions(pageable);
	}
	
	
	/**
	 * 여행자 목록 조회
	 * 
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<TasteMember> getTravelerList(Pageable pageable){
		return memberDao.findAllTravelers(pageable);
	}

	/**
	 * 여행자 / 가이드 로그인 
	 * @throws LoginFailException 
	 */
	@Override
	public User loginMember(String email, String passwd) throws LoginFailException {
		return memberDao.loginMember(email, passwd);
	}

	
	@Override
	public void UpdateMemberInfo(TasteMember member, String email) {
		memberDao.UpdateTravelerInfo(member, email);
	}


	@Override
	public void UpdateCompanionInfo(TasteMember member, String email) {
		memberDao.UpdateCompanionInfo(member, email);
	}
}
