package com.artagit.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.artagit.web.auth.artagitUserDetailsService;

@Configuration
public class ArtagitSecurityConfig {
	
	@Bean // 생성하면서 생성자를 넘기는 것. 
	// 필터를 직접 만들지 않고 스프링에서 제공하는 것을 사용하는 것.
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.authorizeHttpRequests(authorize->authorize // 인가 요청이 오면! return값(authorize)을 authorize 에 담아서 사용?
				.requestMatchers("/admin/**").hasAnyRole("ADMIN") // ADMIN 권한이 있는 계정만 들어갈 수 있는 경로
				.requestMatchers("/corp/**").hasAnyRole("CORP", "ADMIN") // ADMIN, CORP 권한이 있는 계정만 접근할 수 있는 경로
				.requestMatchers("/member/**").hasAnyRole("MEMBER","ADMIN") // MEMBER, ADMIN 권한이 있는 계정만 접근 가능한 경로
				.anyRequest().permitAll()) // 그 외의 나머지 (비회원) 권한을 가진 계정이 접근할 수 있는 경로
				.formLogin(form->form.loginPage("/user/login") // 로그인 폼으로는, /login.html 를 로그인 페이지로 등록한다.
									 .defaultSuccessUrl("/")) // loginPage("/user/login") 경로를 통해 로그인을 했을 때 로그인 성공 시 보내줄 페이지. 
				.exceptionHandling(exp->exp.accessDeniedPage("/denied")) // 권한이 없는 페이지를 접근했을 때 보여줄 화면?
				.logout()
				.logoutUrl("/user/logout") // 로그아웃을 위한 url 설정
				.logoutSuccessUrl("/"); // 로그아웃이 되면 어디로 보낼건지.
		
			return http.build(); // 위에서 설정한 정보들을 하나의 데이터 포맷(객체)으로 만들어서 반환						
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