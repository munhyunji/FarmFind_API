package com.study.farmfind.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.farmfind.mapper.HousingInfoMapper;
import com.study.farmfind.model.HousingInfoDto;
import com.study.farmfind.model.ItemInfoDto;
import com.study.farmfind.model.Pagination;
import com.study.farmfind.model.Paging;
import com.study.farmfind.model.PagingResponse;

@Service
public class HousingInfoService {

	@Autowired
	private HousingInfoMapper mapper;
	
	public PagingResponse<HousingInfoDto> getHousingTitle(Paging page) throws Exception {

		// 데이터가 없는 경우 null 반환
		int total = mapper.housingInfoCount(page);
		if(total < 1) {
			return new PagingResponse<>(Collections.emptyList(), null );
		}
		
		//Pagination 페이지 정보 계산후 
		Pagination pagination = new Pagination(total, page);
		page.setPagination(pagination);
		
		List<HousingInfoDto> list = mapper.getHousingTitle(page);
				
		return new PagingResponse<>(list, pagination);
	}
	
	//아이템 상세정보
	public HousingInfoDto getHousingInfo(int housingNo) throws Exception {
		return mapper.getHousingInfo(housingNo);
	}

}
