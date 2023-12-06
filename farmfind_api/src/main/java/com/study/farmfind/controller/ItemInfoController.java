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
	public PagingResponse<ItemInfoDto> itemInfoTitle(@RequestParam(value="page", defaultValue="1") int currentPage) throws Exception {		
		
		Paging paging = new Paging();
		paging.setPage(currentPage);
		
		PagingResponse<ItemInfoDto> response = service.getItemTitle(paging);
		
		return response;
		
	}
	
	// 상세정보 조회
	// PathVariable = url로부터 파라미터를 받음
	@GetMapping("/detail/{item_no}")
	public ItemInfoDto itemInfo(HttpServletRequest request, @PathVariable int item_no) throws Exception {		
		
		log.info("itemInfo 메서드 : [{}] ", request.toString());
		
		return service.getItemInfo(item_no);		
	} 
	
	// 정보 추가
	// 정보 수정
	
	// 정보 삭제
	
	
	
	
	
	
	
}
