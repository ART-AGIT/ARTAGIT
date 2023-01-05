package com.artagit.web.entity;

import java.util.Date;

public class Member {
   private int id;
   private String loginId;
   private String password;
   private String name;
   private String phone;
   private String nickname;
   private String email;
   private Date regDate;
   private int roleId;
   private String image;
   private String useYN;
   private String tmpPassword;
   

public Member() {
	
   }

   public Member(int id, String loginId, String password, String name, String phone, String nickname, String email,
         Date regDate, int roleId, String image, String tmpPassword) {
      this.id = id;
      this.loginId = loginId;
      this.password = password;
      this.name = name;
      this.phone = phone;
      this.nickname = nickname;
      this.email = email;
      this.regDate = regDate;
      this.roleId = roleId;
      this.image = image;
      this.tmpPassword = tmpPassword;
   }
   

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getLoginId() {
      return loginId;
   }

   public void setLoginId(String loginId) {
      this.loginId = loginId;
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

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }
   
   public String getUseYN() {
	   return useYN;
   }

   public void setUseYN(String useYN) {
	   this.useYN = useYN;
   }

   public String getTmpPassword() {
	   return tmpPassword;
   }

	public void setTmpPassword(String tmpPassword) {
		this.tmpPassword = tmpPassword;
	}

@Override
   public String toString() {
      	return "Member [id=" + id + ", loginId=" + loginId + ", password=" + password + ", name=" + name + ", phone="
            + phone + ", nickname=" + nickname + ", email=" + email + ", regDate=" + regDate + ", roleId=" + roleId
            + ", image=" + image + "]";
   }
   
}