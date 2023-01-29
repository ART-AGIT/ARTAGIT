package com.artagit.web.entity;

import java.util.Map;

import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

//사용자의 정보를 담는 껍데기 클래스
public class ArtagitOidcUser extends ArtagitUserDetails implements OidcUser {

	// 사용자의 기본정보를 생성자를 통해 넘겨 받는다.
	public ArtagitOidcUser() {
		// TODO Auto-generated constructor stub
	}
	
	public ArtagitOidcUser(OidcUser oidcUser) {
		
	}
	
	@Override
	public String getName() {
		return null;
	}
	
	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getClaims() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OidcUserInfo getUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OidcIdToken getIdToken() {
		// TODO Auto-generated method stub
		return null;
	}

}