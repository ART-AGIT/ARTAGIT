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
	private String password;
	private String name;
	private String phone;
	private String nickname;
	private String email;
	private String img;
	private List<GrantedAuthority> authorities; // 권한(ROLE_XXX) 

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities; 
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
