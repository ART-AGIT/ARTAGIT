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

/**********
 * 스프링 시큐리티가 들고 있는 세션 정보에는 Authentication 타입의 객체만 들어갈 수 있다.
 * 여기서, Authentication 객체가 가진 필드는 2개가 있다. 1. OAuth2User 타입 과 2. UserDetails 타입
 * 일반 로그인을 하면 UserDetails 타입의 객체가 Authentication에 들어가고,
 * 소셜 로그인을 하면 OAuth2User 타입의 객체가 Authentication에 들어간다.
 * 스프링 시큐리티가 사용자의 세션 정보를 찾을 때, 일반 로그인과 소셜 로그인 두 가지의 경우를 처리해야 하므로 
 * ArtagitUserDetails 타입으로 UserDetails, OAuth2User를 묶는다. => 스프링 시큐리티가 회원을 처리할 때, 로그인 경로에 상관없이 무조건 ArtagitUserDetails 타입만 찾을 수 있도록 설계.
 *
 * @author hojung
 ******************/
public class ArtagitUserDetails implements UserDetails {

//	private Member member;
	private int id; 
	private String loginId; // 로그인 아이디.
	private String username; // 회원 이름
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
	private static final long serialVersionUID = 1L;
//	private Map<String, Object> attributes;
//    private String provider;
//    private String providerId;
	
    // 일반로그인용 생성자
    public ArtagitUserDetails() {
    }
    
    // OAuth 로그인용 생성자
//    public ArtagitUserDetails(Member member, Map<String, Object> attributes) {
//    	this.member = member;
//    	this.attributes = attributes;
//	}

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
	
	public String getMemName() {
		System.out.println("hihi");
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
	
	public String getCorpAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
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
	}

	public void setRefuseReason(String refuseReason) {
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
	
//	public String getProvider() {
//		return provider;
//	}
//
//	public void setProvider(String provider) {
//		this.provider = provider;
//	}
//
//	public String getProviderId() {
//		return providerId;
//	}
//
//	public void setProviderId(String providerId) {
//		this.providerId = providerId;
//	}

//	@Override
//	public Map<String, Object> getAttributes() {
//		return attributes;
//	}
	
//	@Override
//	public String getName() {
//		return null;
//	}

	@Override
	public String toString() {
		return "ArtagitUserDetails [id=" + id + ", loginId=" + loginId + ", password="
				+ password + ", name=" + name + ", phone=" + phone + ", nickname=" + nickname + ", email=" + email
				+ ", img=" + img + ", authorities=" + authorities + ", ceoName=" + ceoName + ", businessNum="
				+ businessNum + ", manager=" + manager + ", managerPhone=" + managerPhone + ", museumName=" + museumName
				+ ", address=" + address + ", roleId=" + "]";
	}


//	public Member getMember() {
//		return member;
//	}
//
//	public void setMember(Member member) {
//		this.member = member;
//	}
}
