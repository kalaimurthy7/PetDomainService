package com.hcl.pp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pet_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private long userId;
	@Column(name = "USER_NAME")
	private String username;
	@Column(name = "USER_PASSWD")
	//@Transient
	private String password;
	//private String confirmPassword;
	@JsonIgnore 
	@OneToMany(mappedBy = "owner", cascade = {CascadeType.ALL})
	private Set<Pet> pets;
	
	public User() {}

	public User(String username, String password, /* String confirmPassword, */ Set<Pet> pets) {
		this.username = username;
		this.password = password;
		/* this.confirmPassword = confirmPassword; */
		this.pets = pets;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}*/

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", username=" + username + ", password=" + password + ", confirmPassword="
				+ /* confirmPassword + */ ", pets=" + pets + "]";
	}
	
	
}
