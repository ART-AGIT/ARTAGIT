package com.artagit.web.controller.corporate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Member;
import com.artagit.web.service.CorporateService;

@Controller
//@ResponseBody
@RequestMapping("/corp")
public class CorporateController {

	@Autowired
	private CorporateService corpService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// 회원가입
	@GetMapping("signup")
	public String signUp() {
		return "signup-corp";
	}
	
	@PostMapping("signup")
	public String reg(Corporate corp){

		int result = corpService.signUp(corp);
//		System.out.println("insert 결과 => " + result);
//		System.out.println("가입된 corporate => " + corp);
		return "redirect:/";
		
	}
	

	//===================My page===================
	//===================회원수정===================
		@GetMapping("/account-edit")
		public String update(@AuthenticationPrincipal ArtagitUserDetails user, Model model, Corporate corporate) {
			//회원수정페이지불러올때 회원가입할때정보불러오기 user쓰기
			model.addAttribute("user",user);
			System.out.println("마이페이지~~~~~~~!!!!!!!"+user);
			return "corporator/mypage/account-edit";
		}
		
		@PostMapping("/account-edit")
		public String modify(@AuthenticationPrincipal ArtagitUserDetails user, Model model,  Corporate corporate) {
			System.out.println("정보 수정 하자~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			String password = corporate.getPassword();
			String encPassword = passwordEncoder.encode(password);
			
			corporate.setPassword(encPassword);
			
			user.setPassword(corporate.getPassword());
			System.out.println(user.getPassword());
			
			user.setRoleId(corporate.getRoleId());
//			System.out.println("user"+user);
			// 사업자 정보
			user.setCeoName(corporate.getCeoName());
			user.setName(corporate.getName());
			user.setPhone(corporate.getPhone());
			user.setBusinessNum(corporate.getBusinessNum());
			user.setAddress(corporate.getAddress());
			// 담당자 정보
			user.setManager(corporate.getManager());
			user.setEmail(corporate.getEmail());
			user.setManagerPhone(corporate.getManagerPhone());
			
			model.addAttribute("user",user);
			corpService.updateAccount(user);
			System.out.println("user~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+user);
			
			return "corporator/mypage/account-edit";
		}
		
		//===== 회원 탈퇴 (useYN 변경) ==================================		
		@GetMapping("account-edit/delete")
		public String deleteUseYN(
				@AuthenticationPrincipal ArtagitUserDetails user){
			corpService.deleteUseYN(user.getId());
			System.out.println("탈퇴하자!!!!!~~~~~~~~~~~~~~~~~~~~~~~~");
			return "redirect:/user/logout";
		}
	
	
	
}
