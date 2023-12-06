package com.study.farmfind.model;

import lombok.Data;

@Data //getter,setter,constructor
public class ItemInfoDto {
	
	private String item_no;					//아이템 
	private String item_main_category_cd;	//메인 카테고리
	private String item_mid_category_cd;	//중간 카테고리
	private String item_nm;					//이름
	private String item_size;				//사이즈
	private String item_dye_yn;				//염색여부
	private String item_get_from_cd;		//획득처코드
	private String item_get_from_nm;		//획득처이름
	private String item_get_from_dt;		//획득날짜
	private String item_img_aft;			//이미지(낮)
	private String item_img_nig;			//이미지(밤)
	private String item_img_gif;			//이미지(움직)
	private String item_dscption;			//아이템 설명
	private String item_etc;				//아이템 비고
	private String rgst_dt;					//등록날짜
	private String updt_dt;					//수정날짜
	
}
