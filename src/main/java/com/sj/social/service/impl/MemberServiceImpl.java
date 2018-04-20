package com.sj.social.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sj.social.dao.MemberDao;
import com.sj.social.model.Member;
import com.sj.social.service.MemberService;

@Service("memberService")
@Transactional(readOnly = false)
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void save(Member member) {
		memberDao.save(member);
	}

	public void update(Member member) {
		memberDao.update(member);
	}

	public void delete(Member member) {
		memberDao.delete(member);
	}

	public Member findByEmail(String email) {
		return memberDao.findByEmail(email);
	}
	
	public List<Member> findAllMembers() {
		return memberDao.findAllMembers();
	}

}
