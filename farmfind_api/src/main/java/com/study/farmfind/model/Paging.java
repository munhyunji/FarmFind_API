package com.study.farmfind.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {
	
	  	private int page;             // 현재 페이지 번호
	    private int recordSize;       // 페이지당 출력할 데이터 개수
	    private int pageSize;         // 화면 하단에 출력할 페이지 사이즈
	    private String keyword;       // 검색 키워드
	    private String category;    // 검색 유형
	    private String dyeYN;    // 염색 여부
	    private String getFrom;    // 획득처
	    private String itemSize;    // 아이템 사이즈
	    private Pagination pagination; // 페이지네이션 정보

	    public Paging() {
	        this.recordSize = 9; //화면에 출력할 아이템 개수
	        this.pageSize = 10; //페이지네이션 길이 
	    }
	
}
