package com.sj.social.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "member", schema = "public")
public class Member  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "friends", schema = "public",
		joinColumns = { @JoinColumn(name = "member", referencedColumnName="email",  nullable = false, updatable = false) }, 
		inverseJoinColumns = {@JoinColumn(name = "friend", referencedColumnName="email", nullable = false, updatable = false) })
	private Set<Member> friends = new HashSet<Member>(0);

	public Member() {
	}

	public Member(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Member> getFriends() {
		return this.friends;
	}

	public void setFriends(Set<Member> friends) {
		this.friends = friends;
	}

}
