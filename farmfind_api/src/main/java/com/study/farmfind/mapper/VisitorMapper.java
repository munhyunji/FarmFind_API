package com.study.farmfind.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VisitorMapper {
	
	//오늘 방문자 count
	int setVisitTodayCount(String sessionId) throws Exception;

	int getVisitorIdToday(String sessionId);
	
	//방문자 수 가져오기
	int getVisitTodayTotalCount();
}
