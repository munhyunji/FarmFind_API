package com.study.farmfind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.farmfind.model.HousingInfoDto;
import com.study.farmfind.model.ItemInfoDto;
import com.study.farmfind.model.Paging;
import com.study.farmfind.model.PagingResponse;
import com.study.farmfind.service.HousingInfoService;

@RequestMapping("/housing")
@RestController
public class HousingInfoController {
	
	//서비스 주입
		private HousingInfoService service;
		
		@Autowired
		public HousingInfoController(HousingInfoService service) {
			this.service = service;
		}
		
		// 리스트 개수 조회
		/*
		 * @GetMapping("/count") public int itemInfoCount() throws Exception { return
		 * service.itemInfoCount(); }
		 */
		
		// 리스트 타이틀 조회
		@GetMapping("/list")
		public PagingResponse<HousingInfoDto> housingInfoTitle(
				@RequestParam(value="page", defaultValue="1") int currentPage,
				@RequestParam(value="keyword", defaultValue="") String keyword) throws Exception {		
			
			Paging paging = new Paging();
			paging.setPage(currentPage);
			paging.setKeyword(keyword);
			
			PagingResponse<HousingInfoDto> response = service.getHousingTitle(paging);
			
			return response;
			
		}
		
		// 상세정보 조회
		// PathVariable = url로부터 파라미터를 받음
		@GetMapping("/detail")
		public HousingInfoDto housingInfo(@RequestParam(value="no") int housingNo) throws Exception {		
			return service.getHousingInfo(housingNo);		
		} 
}
