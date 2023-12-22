package com.study.farmfind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.farmfind.service.VisitorService;

@RestController
@RequestMapping("visitor")
public class VisitorController {

	private VisitorService service;
	
	@Autowired
	public VisitorController(VisitorService service) {
		this.service = service;
	}
	
	//오늘 방문자 insert
	@GetMapping("/today")
	public int setVisitTodayCount(@RequestParam(value="sessionId") String sessionId) throws Exception {
		
		return service.setVisitTodayCount(sessionId);
	}
	
	//오늘 방문자 가져오기
	@GetMapping("/todayCount")
	public int getVisitTodayTotalCount() throws Exception {
		
		return service.getVisitTodayTotalCount();
	}
		
}
