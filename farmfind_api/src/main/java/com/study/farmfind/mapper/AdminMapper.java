package com.study.farmfind.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.study.farmfind.model.AdminDto;

@Mapper
public interface AdminMapper {
	
	//관리자 로그인
	String adminLogin(String adminId);
	
	int adminSave(AdminDto dto);

	
}
