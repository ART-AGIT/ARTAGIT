package com.artagit.web.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// 기존의 UserDetails 은 id/pwd/권한 만 가져올 수 있다.
// 그렇기 때문에 회원이 로그인해 있는 동안에, 그 3가지 외에 더 많은 정보를 편하게 접근할 수 있도록 필요한 회원 컬럼(속성)들을 추가해놓는 클래스

// 스프링 시큐리티는 세션/쿠키를 사용해서 로그인한 사용자의 정보들을 시큐리티 컨텍스트에 가지고 있게 된다.
// 그래서 회원이 로그인을 해 있는 동안 컨텍스트에 담겨있는 정보를 이용하게 되고..
// 로그아웃을 하면 시큐리티가 알아서 회원 객체(UserDetails)를 해제해준다.
public class ArtagitUserDetails implements UserDetails {
	
	private int id; 
	private String loginId;
	private String username;
	private String password;

	private String name;
	private String phone;
	private String nickname;
	private String email;
	private String img;
	private List<GrantedAuthority> authorities; // 권한(ROLE_XXX) 
	
	private String ceoName;
	private int businessNum;
	private String manager;
	private String managerPhone;
	private String museumName;
	private String address;
	private String addressDetail;
	



	private int roleId;
	
	
	
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
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

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	// 스프링의 UserDetails가 제공해주는 데이터
	// 회원에게 권한을 줄 때, 스프링이 사용하게 될 메서드
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities; 
	}
	
	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMuseumName() {
		return museumName;
	}

	public void setMuseumName(String museumName) {
		this.museumName = museumName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}

	public void setBusinessNum(int businessNum) {
		this.businessNum = businessNum;
	}

	public String getManager() {
		return manager;
	}
	
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setRegState(String regState) {
//		this.regState = regState;
	}

	public void setProcessDate(String processDate) {
		// TODO Auto-generated method stub
	}

	public void setRefuseReason(String refuseReason) {
		// TODO Auto-generated method stub
	}

	public void setLocalId(int localId) {
//		this.setLocalId = localId;	
	}

	public String getCeoName() {
		return ceoName;
	}

	public int getBusinessNum() {
		return businessNum;
	}
	
	@Override
	public String toString() {
		return "ArtagitUserDetails [id=" + id + ", loginId=" + loginId + ", username=" + username + ", password="
				+ password + ", name=" + name + ", phone=" + phone + ", nickname=" + nickname + ", email=" + email
				+ ", img=" + img + ", authorities=" + authorities + ", ceoName=" + ceoName + ", businessNum="
				+ businessNum + ", manager=" + manager + ", managerPhone=" + managerPhone + ", museumName=" + museumName
				+ ", address=" + address + ", roleId=" + roleId + "]";
	}

}
