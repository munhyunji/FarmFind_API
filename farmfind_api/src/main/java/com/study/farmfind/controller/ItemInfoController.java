package com.study.farmfind.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.farmfind.model.ItemInfoDto;
import com.study.farmfind.model.Paging;
import com.study.farmfind.model.PagingResponse;
import com.study.farmfind.service.ItemInfoService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/item")
@RestController
public class ItemInfoController {
	
	//서비스 주입
	private ItemInfoService service;
	
	@Autowired
	public ItemInfoController(ItemInfoService service) {
		this.service = service;
	}
	
	// 리스트 개수 조회
	/*
	 * @GetMapping("/count") public int itemInfoCount() throws Exception { return
	 * service.itemInfoCount(); }
	 */
	
	// 리스트 타이틀 조회
	@GetMapping("/list")
	public PagingResponse<ItemInfoDto> itemInfoTitle(
			@RequestParam(value="page", defaultValue="1") int currentPage,
			@RequestParam(value="keyword", defaultValue="") String keyword,
			@RequestParam(value="category", defaultValue="") String category,
			@RequestParam(value="dyeYN", defaultValue="") String dyeYN,
			@RequestParam(value="getFrom", defaultValue="") String getFrom,
			@RequestParam(value="itemSize", defaultValue="") String itemSize
			) throws Exception {		
		
		Paging paging = new Paging();
		paging.setPage(currentPage);
		paging.setKeyword(keyword);
		paging.setCategory(category);
		paging.setDyeYN(dyeYN);
		paging.setGetFrom(getFrom);
		paging.setItemSize(itemSize);
		
		PagingResponse<ItemInfoDto> response = service.getItemTitle(paging);
		
		return response;
		
	}
	
	// 리스트 타이틀 조회(페이징없이 전체 조회)
		@GetMapping("/listAll")
		public List<ItemInfoDto> itemInfoTitleAll() throws Exception {					
			List<ItemInfoDto> response = service.getItemTitleAll();			
			return response;
			
		}
	
	// 상세정보 조회
	// PathVariable = url로부터 파라미터를 받음
	@GetMapping("/detail")
	public ItemInfoDto itemInfo(@RequestParam(value="itemNo") int itemNo) throws Exception {		
		return service.getItemInfo(itemNo);		
	} 
	
	// 정보 추가
	// 정보 수정	
	// 정보 삭제
	
	
	
	
	
	
	
}
