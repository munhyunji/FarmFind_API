package com.study.farmfind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.farmfind.mapper.VisitorMapper;

@Service
public class VisitorService {
	
	@Autowired
	private VisitorMapper mapper;

	public int setVisitTodayCount(String sessionId) throws Exception {
		
		int total = mapper.getVisitorIdToday(sessionId);
		
		//이전에 방문한 경험이 없는 경우
		if( total < 1 ) {
			return mapper.setVisitTodayCount(sessionId);			
		} 
	
		return 0;
	}
	
	public int getVisitTodayTotalCount() throws Exception {
		
		return mapper.getVisitTodayTotalCount();
	}

}
