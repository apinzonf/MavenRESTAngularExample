package com.sj.social.service;

import java.util.List;

import com.sj.social.model.Member;

public interface MemberService {
	
	void save(Member member);
	
	void update(Member member);
	
	void delete(Member member);
	
	Member findByEmail(String email);
	
	List<Member> findAllMembers() ;

}