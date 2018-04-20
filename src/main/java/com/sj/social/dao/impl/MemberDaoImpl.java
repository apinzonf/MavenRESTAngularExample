package com.sj.social.dao.impl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.sj.social.dao.MemberDao;
import com.sj.social.model.Member;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDaoImpl extends HibernateDaoSupport implements MemberDao {
	
	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}

	public void save(Member member) {
		getHibernateTemplate().save(member);
	}

	public void update(Member member) {
		getHibernateTemplate().update(member);
	}

	public void delete(Member member) {
		getHibernateTemplate().delete(member);
		
	}

	public Member findByEmail(String email) {
		List<Member> list = (List<Member>) getHibernateTemplate().find("from Member where email=?",email);
		return list.isEmpty() ? null : (Member)list.get(0);
	}
	
	public List<Member> findAllMembers() {
		List<Member> list = (List<Member>)getHibernateTemplate().find("from Member");
		return list;
	}

}
