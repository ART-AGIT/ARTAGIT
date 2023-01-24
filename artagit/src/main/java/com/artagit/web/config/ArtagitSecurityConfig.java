package com.artagit.web.config;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.security.web.SecurityFilterChain;

import com.artagit.web.auth.artagitUserDetailsService;
import com.artagit.web.dao.MemberDao;
//import com.artagit.web.entity.ArtagitOidcUser;
import com.artagit.web.entity.Member;

@Configuration
public class ArtagitSecurityConfig {
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private MemberDao memberDao;
	
	@Bean // 생성하면서 생성자를 넘기는 것. 
	// 필터를 직접 만들지 않고 스프링에서 제공하는 것을 사용하는 것.
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.authorizeHttpRequests(authorize->authorize // 인가 요청이 오면! return값(authorize)을 authorize 에 담아서 사용?
				.requestMatchers("/admin/**").hasAnyRole("ADMIN") // ADMIN 권한이 있는 계정만 들어갈 수 있는 경로
				.requestMatchers("/corp/**").hasAnyRole("CORP", "ADMIN") // ADMIN, CORP 권한이 있는 계정만 접근할 수 있는 경로
				.requestMatchers("/member/**", "").hasAnyRole("MEMBER","ADMIN") // MEMBER, ADMIN 권한이 있는 계정만 접근 가능한 경로
				.anyRequest().permitAll()) // 그 외의 나머지 (비회원) 권한을 가진 계정이 접근할 수 있는 경로
				.formLogin(form->form.loginPage("/user/login") // 로그인 폼으로는, /login.html 를 로그인 페이지로 등록한다.
									 .defaultSuccessUrl("/")) // loginPage("/user/login") 경로를 통해 로그인을 했을 때 로그인 성공 시 보내줄 페이지. 
				.exceptionHandling(exp->exp.accessDeniedPage("/denied")) // 권한이 없는 페이지를 접근했을 때 보여줄 화면?
				.logout()
				.logoutUrl("/user/logout") // 로그아웃을 위한 url 설정
				.logoutSuccessUrl("/") // 로그아웃이 되면 어디로 보낼건지.
//				.and()
//				.oauth2Login(oauth2->oauth2
//						.userInfoEndpoint()
//						.oidcUserService(oidcUserService())) // 유저정보를 얻어서 그 유저정보를 member에 저장하고 다음에 다시 왔을 때 member 정보로 확인하도록..
				;
			return http.build(); // 위에서 설정한 정보들을 하나의 데이터 포맷(객체)으로 만들어서 반환						
	}
	
	// 유저정보를 얻어서 그 유저정보를 member에 저장하고 다음에 다시 왔을 때 member 정보로 확인하도록..
//	private OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
//		
//		// 자식 클래스를 정의해서 객체로 만들어서 반환하는 코드... (OAuth2UserService 는 인터페이스 이기 때문에 구현체가 필요)
//		return (oidcUserRequest) -> { // Request 정보를 받으면, 그걸로 
//	
//			OidcUserService oidcUserService = new OidcUserService();
//			OidcUser oidcUser = oidcUserService.loadUser(oidcUserRequest);
//	
//			System.out.println("======= user info ======");
//			System.out.println(oidcUser);
//			System.out.println("======= user attributes ======");
//			System.out.println(oidcUser.getAttributes());
//			
//			// OidcUser (아무것도 없는 맨땅 사용자 정보) 를 -> ArtagitOidcUser(우리가 원하는 사용자 정보 객체로 반환)
//			Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
//			
//			ArtagitOidcUser user = new ArtagitOidcUser(oidcUser);
//			
//			// memberDao를 통해 member를 얻어와서.
//			Member member = memberDao.getByOAuthIdWithIss(
//											oidcUser.getName(),
//											oidcUser.getAttribute("iss")); // oidcUser 에서 반환되는 name(사용자아이디)와 iss를 가지고 사용자를 확인하기.
//			
//			// Db에 해당 사용자의 정보가 없을 경우 ==> 신규 회원
//			if(member == null) {
//				Member temp = memberDao.getByUserName(oidcUser.getAttribute("Name"));
//				
//				String username = oidcUser.getAttribute("Name");
//				
//				if(temp != null) // 현재 로그인한 사용자와 동일한 이름을 가진 기존 유저가 존재하다면
//					username += "_1"; // 중복을 피하기 위해 이름 뒤에 표시를 위한 문자열을 붙여서 저장해주기.
//				
//				// 넘어온 해당 유저의 정보들을 담아서
//				temp = new Member();
//				temp.setEmail(oidcUser.getEmail());
//				temp.setLoginId(username); // id와 pw는 저장할 필요 없다.
//				temp.setOAuthId(oidcUser.getName());
//				temp.setOAuthIss(oidcUser.getAttribute("iss"));
//				
//				memberDao.insert(temp); // 새로 추가(insert) 해준다.
//			}
//			
//			return user;
//		};
//	}
	
	// 소셜(구글, 카카오, 네이버) 로그인 시, 회원의 권한을 부여해주는 메서드
	private GrantedAuthoritiesMapper userAuthoritiesMapper() {
		return (authorities) -> {
			Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
			
			authorities.forEach(authority -> {
	        	 // id를 사용하는 오픈어스 (ex. google)
	            if (OidcUserAuthority.class.isInstance(authority)) {
	               OidcUserAuthority oidcUserAuthority = (OidcUserAuthority)authority;
	               
	               OidcIdToken idToken = oidcUserAuthority.getIdToken();
	               OidcUserInfo userInfo = oidcUserAuthority.getUserInfo();
	               System.out.println(idToken);
	               System.out.println(userInfo);
	               
	               // Map the claims found in idToken and/or userInfo
	               // to one or more GrantedAuthority's and add it to mappedAuthorities (원한다면 사용자에 대한 정보를 이부분에서 추가할 수 있다.)
	               System.out.println("========= Oidc User authorities =========");
	               
	               mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	               
	            // user를 사용하는 오픈어스 (ex. facebook)
	            } else if (OAuth2UserAuthority.class.isInstance(authority)) {
	               OAuth2UserAuthority oauth2UserAuthority = (OAuth2UserAuthority)authority;

	               Map<String, Object> userAttributes = oauth2UserAuthority.getAttributes();

	               // Map the attributes found in userAttributes
	               // to one or more GrantedAuthority's and add it to mappedAuthorities
	               System.out.println("========= OAuth2 User authorities =========");

	            }
	         });

	         return mappedAuthorities;
	      };
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() { // 비밀번호 암호화해주는 메서드
											   // 비밀번호 암호화를 위해 사용. 시큐리티는 비밀번호가 암호화 되어 있어야 사용가능하다
		return new BCryptPasswordEncoder();    // 회원가입할때 쓰면된다.
	}
	
	@Bean // 내가 커스텀한 클래스
	public UserDetailsService artagitUserDetailsService() {
		return new artagitUserDetailsService();
	}
}

//스프링부트 3.0 버전에 스프링 시큐리티 6.0 버전 사용!