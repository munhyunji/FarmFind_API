package com.study.farmfind.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.farmfind.model.HousingInfoDto;
import com.study.farmfind.model.Paging;

@Mapper
public interface HousingInfoMapper {

	//아이템 개수 조회
	int housingInfoCount(Paging page) throws Exception;
	//아이템 타이틀 조회
	List<HousingInfoDto> getHousingTitle(Paging page) throws Exception;
	//아이템 상세정보 조회
	HousingInfoDto getHousingInfo(int housing_no) throws Exception;
	
}
