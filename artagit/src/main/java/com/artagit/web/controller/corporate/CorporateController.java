package com.artagit.web.controller.corporate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Member;
import com.artagit.web.service.CorporateService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
//@ResponseBody
@RequestMapping("/corp")
public class CorporateController {

	@Autowired
	private CorporateService corpService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	//===================My page===================
	//===================회원수정===================
		@GetMapping("/mypage/account-edit")
		public String update(@AuthenticationPrincipal ArtagitUserDetails user, Model model, Corporate corporate) {
			//회원수정페이지불러올때 회원가입할때정보불러오기 user쓰기
			System.out.println("마이페이지~~~~~~~!!!!!!!"+user);
			model.addAttribute("user",user);
//			model.addAttribute(corporate.getName());
			return "corporator/mypage/account-edit";
		}
		
		@PostMapping("/mypage/account-edit")
		public String modify(MultipartFile imgFile,HttpServletRequest request, 
				@AuthenticationPrincipal ArtagitUserDetails user, Model model,  Corporate corporate) throws IOException {
			System.out.println("정보 수정 하자~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			// 정보 수정 - 비밀번호 수정 안했을 때 유지코드
			if (!corporate.getPassword().isEmpty()) {
				String password = corporate.getPassword();
				String encPassword = passwordEncoder.encode(password);
				
				corporate.setPassword(encPassword);
				
				user.setPassword(corporate.getPassword());
				System.out.println(user.getPassword());
			}
			user.setRoleId(corporate.getRoleId());
//			System.out.println("user"+user);
			
			// 이미지
//			user.setImage(corporate.getImage());
			MultipartFile img = imgFile;
			System.out.println("이미지%%%%%%%%%%%%%%%%%%%%"+imgFile);
			
			if (!img.isEmpty()) {
				corporate.setImg(img.getOriginalFilename());
				user.setImg(corporate.getImg());
				String path = "/image"; // 어디에서 돌아갈지 모르니 운영되고 있는 home directory에서 생각 앞쪽은 어케될지 모름
				String realPath = request.getServletContext().getRealPath(path);
				System.out.println(realPath);

				File pathFile = new File(realPath);
				if (!pathFile.exists())
					pathFile.mkdirs();

				String fullPath = realPath + File.separator + img.getOriginalFilename();
				InputStream fis = img.getInputStream();
				OutputStream fos = new FileOutputStream(fullPath);
				byte[] buf = new byte[1024];
				int size = 0;
				while ((size = fis.read(buf)) >= 0)
					fos.write(buf, 0, size);

				fos.close();
				fis.close();
			}
			
			// 사업자 정보
			user.setCeoName(corporate.getCeoName());
			user.setName(corporate.getName());
			user.setPhone(corporate.getPhone());
			user.setBusinessNum(corporate.getBusinessNum());
			user.setCorpAddress(corporate.getCorpAddress());
			user.setAddressDetail(corporate.getAddressDetail());
			// 담당자 정보
					
			user.setManager(corporate.getManager());
			user.setEmail(corporate.getEmail());
			user.setManagerPhone(corporate.getManagerPhone());	
			
			
			model.addAttribute("user",user);
//			model.addAttribute("corporate",corporate);
			corpService.updateAccount(user);
			System.out.println("user~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+user);
			
			return "corporator/mypage/account-edit";
		}
		
		//===== 회원 탈퇴 (useYN 변경) ==================================		
		@GetMapping("/mypage/account-edit/delete")
		public String deleteUseYN(
				@AuthenticationPrincipal ArtagitUserDetails user){
			corpService.deleteUseYN(user.getId());
			System.out.println("탈퇴하자!!!!!~~~~~~~~~~~~~~~~~~~~~~~~");
			return "redirect:/user/logout";
		}
	
	
	
}
