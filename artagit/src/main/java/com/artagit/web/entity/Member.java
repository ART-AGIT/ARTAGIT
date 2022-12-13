package com.artagit.web.entity;

import java.util.Date;

public class Member {
	private int id;
	private String LoginId;
	private String password;
	private String name;
	private String phone;
	private String nickname;
	private String email;
	private Date regDate;
	private int roleId;
	private String img;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int id, String loginId, String password, String name, String phone, String nickname, String email,
			Date regDate, int roleId, String img) {
		this.id = id;
		LoginId = loginId;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.nickname = nickname;
		this.email = email;
		this.regDate = regDate;
		this.roleId = roleId;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return LoginId;
	}

	public void setLoginId(String loginId) {
		LoginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", LoginId=" + LoginId + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", nickname=" + nickname + ", email=" + email + ", regDate=" + regDate + ", roleId=" + roleId
				+ ", img=" + img + "]";
	}
}
