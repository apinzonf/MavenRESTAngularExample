package com.sj.social.dao;

import java.util.List;

import com.sj.social.model.Member;

public interface MemberDao {
	
	void save(Member member);
	
	void update(Member member);
	
	void delete(Member member);
	
	Member findByEmail(String email);
	
	List<Member> findAllMembers();

}
