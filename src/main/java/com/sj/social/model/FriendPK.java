package com.sj.social.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Embeddable
public class FriendPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "member")
	private String member;

	@Column(name = "friend")
	private String friend;

	public FriendPK() {
	}
	public String getMember() {
		return this.member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getFriend() {
		return this.friend;
	}
	public void setFriend(String friend) {
		this.friend = friend;
	}

}