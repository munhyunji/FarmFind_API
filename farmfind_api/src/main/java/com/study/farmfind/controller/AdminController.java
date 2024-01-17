package com.study.farmfind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.farmfind.model.AdminDto;
import com.study.farmfind.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RequestMapping("admin")
@RestController
public class AdminController {
	
	//서비스 주입
	private AdminService service;
	
	@Autowired
	public AdminController(AdminService service) {
		this.service = service;
	}
	
	@Autowired
	PasswordEncoder passwordEncoder; //Bean DI 
	
	@PostMapping("/login")
	public String adminLogin(@RequestParam("adminId") String adminId, @RequestParam("adminPw") String adminPw, HttpServletRequest request) {
		String encodedPw = service.adminLogin(adminId);
		
		if(passwordEncoder.matches(adminPw, encodedPw)) {
			// 세션 생성
	        System.out.println("세션 생성");
	        HttpSession session = request.getSession();
	        System.out.println("HttpSession 객체: " + session);
	        
	        // 세션 속성 설정
	        session.setAttribute("adminId", adminId);
	        System.out.println("세션 속성 adminId: " + session.getAttribute("adminId"));

			return "Ok";
		} else {
			return "No";
		}
	}
	

	/*@GetMapping("/firstsave")
	public int adminRegister(@RequestParam("adminId") String adminId, @RequestParam("adminPw") String admiPw) {
		
		String enCodePw = passwordEncoder.encode(admiPw);
		System.out.println("암호화할 번호" +enCodePw);
		
		AdminDto dto = new AdminDto();
		
		dto.setAdminId(adminId);
		dto.setAdminPw(enCodePw);
		
		return service.adminSave(dto);
	}*/
}
