package com.study.farmfind.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.farmfind.model.ItemInfoDto;
import com.study.farmfind.model.Paging;

@Mapper
public interface ItemInfoMapper {
	
	//아이템 개수 조회
	int itemInfoCount(Paging page) throws Exception;
	//아이템 타이틀 조회
	List<ItemInfoDto> getItemTitle(Paging page) throws Exception;
	//아이템 상세정보 조회
	ItemInfoDto getItemInfo(int item_no) throws Exception;
	
}
