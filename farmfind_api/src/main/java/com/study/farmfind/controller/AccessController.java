package com.study.farmfind.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessController {
	
	@GetMapping("/")
	public String get() {
		System.out.println("메인입니다.");
		return "yahoo";
			
	}
}
