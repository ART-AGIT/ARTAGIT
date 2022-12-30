package com.artagit.web.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.artagit.web.dao.MemberDao;
import com.artagit.web.dao.RoleDao;
import com.artagit.web.entity.Member;
import com.artagit.web.entity.Role;

//개발자가 직접 커스텀해서 사용자 정보를 불러오기 위한 서비스.
public class artagitUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberDao memDao;
	
	@Autowired
	private RoleDao roleDao;
	
	
	@Override
	// 사용자 로그인 시, 해당 계정의 접근 권한을 확인하기 위해 사용자가 입력한 id (=username)을 로드해오는 것
	// Spring Security가 자동으로 처리해준다.
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Member member = memDao.getByUserName(username); // loginId 가 member에 담긴다.
		List<Role> roles = roleDao.getListByUserName(username); // 회원의 권한(ROLE_***)이 roles에 담긴다.
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		return null;
	}

}
