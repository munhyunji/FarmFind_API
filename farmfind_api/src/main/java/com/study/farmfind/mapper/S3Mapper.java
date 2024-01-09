package com.study.farmfind.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface S3Mapper {
	
	//이미지 Url 저장
	int setImgUrl(String imgUrl, String item_no, String imgId) throws Exception;

}
