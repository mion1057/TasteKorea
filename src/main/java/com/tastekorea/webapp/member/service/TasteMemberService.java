package com.tastekorea.webapp.member.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

<<<<<<< HEAD
import com.tastekorea.webapp.auth.web.command.User;
=======
>>>>>>> ef9369a398f2db785d7e7d7c8bd396aaa2cfba39
import com.tastekorea.webapp.member.domain.TasteMember;

public interface TasteMemberService {

	/**
	 * Member정보 LanguageSkill 정보를 함께 저장
	 * 
	 * @param member
	 * @return
	 */
	TasteMember addMember(TasteMember member);

	/**
	 * 가이드 상세보기
	 * @param id
	 * @return
	 */
	TasteMember getMember(long id);

	/**
	 * 가이드 목록 조회
	 * 
	 * @param pageable
	 * @return
	 */
	Page<TasteMember> getMemberList(Pageable pageable);

	/**
	 * 가이드 목록 조회
	 * 
	 * @param pageable
	 * @return
	 */
	Page<TasteMember> getCompanionList(Pageable pageable);

	/**
	 * 여행자 목록 조회
	 * 
	 * @param pageable
	 * @return
	 */
	Page<TasteMember> getTravelerList(Pageable pageable);
<<<<<<< HEAD
	
	/**
	 * 회원 / 가이드 로그인 
	 */
	User loginMember(String email);
=======
>>>>>>> ef9369a398f2db785d7e7d7c8bd396aaa2cfba39

}