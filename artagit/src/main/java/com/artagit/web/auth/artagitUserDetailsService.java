package com.artagit.web.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.artagit.web.dao.MemberDao;
import com.artagit.web.dao.RoleDao;
import com.artagit.web.entity.ArtagitUserDetails;
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

		Member member = memDao.getByUserName(username); // loginId 에 대한 회원의 모든 정보가 member에 담긴다.
		Role role = roleDao.getListByUserName(username); // 사용자가 입력한 id 에 대한 회원의 id와 권한(ROLE_***)이 roles에 담긴다.
		
		System.out.println("담겨진 member ====> "+member);
		System.out.println("담겨진 role ====> "+role);
		
		List<GrantedAuthority> authorities = new ArrayList<>(); // 사용자의 권한을 담기 위해 authorities 객체 생성 (초기엔 아무 권한도 담겨있지 않음.. maybe..)
		
		authorities.add(new SimpleGrantedAuthority(role.getName())); // authorities에 추가한다. 회원의 id에서 얻어온 권한의 이름을..
		
		ArtagitUserDetails user = new ArtagitUserDetails(); // 회원이 로그인해 있는 동안에, id/pw/권한 외에 더 많은 정보에 접근할 수 있도록 필요한 회원 컬럼(속성)들을 담는 객체 생성
		user.setId(member.getId());
		user.setUsername(username);
		user.setPassword(member.getPassword());
		user.setName(member.getName());
		user.setPhone(member.getPhone());
		user.setNickname(member.getNickname());
		user.setEmail(member.getEmail());
		user.setImg(member.getImage());
		user.setAuthorities(authorities);
		
		return user;
	}
}