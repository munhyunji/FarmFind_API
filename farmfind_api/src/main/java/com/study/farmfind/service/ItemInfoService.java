package com.study.farmfind.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.farmfind.mapper.ItemInfoMapper;
import com.study.farmfind.model.ItemInfoDto;
import com.study.farmfind.model.Pagination;
import com.study.farmfind.model.Paging;
import com.study.farmfind.model.PagingResponse;

@Service
public class ItemInfoService {
	
	@Autowired
	private ItemInfoMapper mapper;
	
	//개수조회
	/*
	 * public int itemInfoCount() throws Exception { return mapper.itemInfoCount();
	 * }
	 */
	
	//이름조회
	public PagingResponse<ItemInfoDto> getItemTitle(Paging page) throws Exception {
		
		// 데이터가 없는 경우 null 반환
		int total = mapper.itemInfoCount();
		if(total < 1) {
			return new PagingResponse<>(Collections.emptyList(), null );
		}
		
		//Pagination 페이지 정보 계산후 
		Pagination pagination = new Pagination(total, page);
		page.setPagination(pagination);
		
		List<ItemInfoDto> list = mapper.getItemTitle(page);
				
		return new PagingResponse<>(list, pagination);
	} 
	
	//상세조회
	public ItemInfoDto getItemInfo(int item_no) throws Exception {
		return mapper.getItemInfo(item_no);
	}
	
	
	
	
}
