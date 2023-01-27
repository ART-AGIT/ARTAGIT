package com.artagit.web.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.artagit.web.dao.CorporateDao;
import com.artagit.web.dao.MemberDao;
import com.artagit.web.dao.RoleDao;
import com.artagit.web.entity.ArtagitOidcUser;
import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Member;
import com.artagit.web.entity.Role;

//개발자가 직접 커스텀해서 사용자 정보를 불러오기 위한 서비스.
public class artagitUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberDao memDao; // 멤버 데이터를 이용해야 하므로 MemberDao 가져오기.
	
	@Autowired
	private CorporateDao corpDao;
	
	@Autowired
	private RoleDao roleDao;
	
	
	@Override
	// 사용자 로그인 시, 해당 계정의 접근 권한을 확인하기 위해 사용자가 입력한 id (=username)을 로드해오는 것
	// Spring Security가 자동으로 처리해준다.
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Role role;
		//Role role = roleDao.getListByUserName(username); // 사용자가 입력한 id 에 대한 회원의 id와 권한(ROLE_***)이 roles에 담긴다.
		//System.out.println("담겨진 role ====> "+role);

		List<GrantedAuthority> authorities = new ArrayList<>(); // 사용자의 권한을 담기 위해 authorities 객체 생성 (초기엔 아무 권한도 담겨있지 않음.. maybe..)
		ArtagitUserDetails user = new ArtagitUserDetails(); // 회원이 로그인해 있는 동안에, id/pw/권한 외에 더 많은 정보에 접근할 수 있도록 필요한 회원 컬럼(속성)들을 담는 객체 생성
//		ArtagitOidcUser user = new ArtagitOidcUser(); // 회원이 로그인해 있는 동안에, id/pw/권한 외에 더 많은 정보에 접근할 수 있도록 필요한 회원 컬럼(속성)들을 담는 객체 생성
		
		Corporate corp;
		
		Member member = memDao.getByUserName(username);
		
		System.out.println("member"+member);
		if(member==null)
			corp = corpDao.getByUserName(username);
		
		// member의 경우
		if(member!=null) {
			role = roleDao.getMemberByUserName(username);
			//member = memDao.getByUserName(username); // loginId 에 대한 회원의 모든 정보가 member에 담긴다.
			
			System.out.println("담겨진 member ====> "+member);
			if(member.getUseYN().equals("N")) {
				System.out.println("멤버 탈퇴 로그인 불가");
				return user;
			}
			
			authorities.add(new SimpleGrantedAuthority(role.getName())); // authorities에 추가한다. 회원의 id에서 얻어온 권한의 이름을..
			
			user.setUsername(username);
			user.setId(member.getId());
			user.setPassword(member.getPassword());
			user.setName(member.getName());
			user.setPhone(member.getPhone());
			user.setNickname(member.getNickname());
			user.setEmail(member.getEmail());
			user.setImg(member.getImage());
			user.setRoleId(member.getRoleId());
			user.setAuthorities(authorities);
			
			System.out.println("담겨진 user ====> "+user);
		} 
		else {
			role = roleDao.getCorpByUserName(username);
			corp = corpDao.getByUserName(username); // loginId 에 대한 회원의 모든 정보가 member에 담긴다.
			
			System.out.println("담겨진 corp ====> "+corp);
			
			if(corp.getUseYN().equals("N")) {
				System.out.println("주최자 탈퇴 로그인 불가");
				return user;
			}
			
			authorities.add(new SimpleGrantedAuthority(role.getName()));
			
			user.setUsername(username);
			user.setId(corp.getId());
			user.setPassword(corp.getPassword());
			user.setName(corp.getName());
			user.setCeoName(corp.getCeoName());
			user.setEmail(corp.getEmail());
			user.setBusinessNum(corp.getBusinessNum());
			user.setManager(corp.getManager());
			user.setPhone(corp.getPhone());
//			user.setEmail(corp.getEmail());
			user.setAddress(corp.getAddress());
			user.setAddressDetail(corp.getAddressDetail());
			user.setRegState(corp.getRegState());
			user.setProcessDate(corp.getProcessDate());
			user.setRefuseReason(corp.getRefuseReason());
			user.setManagerPhone(corp.getManagerPhone());
			user.setMuseumName(corp.getMuseumName());
			user.setLocalId(corp.getLocalId());
			user.setRoleId(corp.getRoleId());
			user.setImg(corp.getImg());
//			user.setImg(corp.getImg());
			user.setAuthorities(authorities);
			user.setImg(corp.getImage());
			System.out.println("업체회원!==> "+user);
		}
		System.out.println(username + "회원의 권한 ====> "+authorities);
		System.out.println(user.getAddress());
		return user;
	}
}
