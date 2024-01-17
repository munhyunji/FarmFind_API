package com.study.farmfind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.farmfind.mapper.AdminMapper;
import com.study.farmfind.model.AdminDto;

@Service
public class AdminService {
	
	@Autowired
	private AdminMapper mapper;

	public String adminLogin(String adminId) {		
		return mapper.adminLogin(adminId);
	}

	public int adminSave(AdminDto dto) {
		return mapper.adminSave(dto);
	}
	
	
}
