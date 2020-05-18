package com.capgemini.OTMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Integer userId;

	@Column(unique = true, name = "userName")
	@NotBlank
	private String userName;

	@Column(name = "password")
	@Min(value = 8)
	private String password;

	private Boolean IsAdmin;

	public Boolean getIsAdmin() {
		return IsAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		IsAdmin = isAdmin;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(Integer userId, @NotBlank String userName, @Min(8) String password, Boolean isAdmin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		IsAdmin = isAdmin;
	}
	
	
}
