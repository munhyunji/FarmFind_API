package com.study.farmfind.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.study.farmfind.service.S3Service;

@RestController
@RequestMapping("img")
public class S3Controller {

	private final S3Service s3Service;
	
	@Autowired
    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }
	
	@PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadFile(
    		@RequestParam(value="itemAft", required = false) MultipartFile Aftfile,
    		@RequestParam(value="itemNig", required = false) MultipartFile Nigfile,
    		@RequestParam("item_no") String item_no) {
        try {

        	String ImgUrl = "";
        	
        	//낮사진
        	if(Aftfile != null) {
        		String key = item_no + "_" + Aftfile.getOriginalFilename();
        		ImgUrl = s3Service.uploadFile(key, Aftfile);                    		
        	}
        	//밤사진
        	if(Nigfile != null) {
        		 String key = item_no + "_" + Nigfile.getOriginalFilename();
        		 ImgUrl = s3Service.uploadFile(key, Nigfile);
        	}

        	 // 업로드 성공 시 메시지 반환
            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "File uploaded successfully.");
            response.put("filename", ImgUrl);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // 업로드 실패 시 에러 메시지 반환
            Map<String, String> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", "Error uploading file: " + e.getMessage());

            return ResponseEntity.status(500).body(response);
        }
    }
	
	@GetMapping("/url")
	public int imgUrl(@RequestParam("imgUrl") String imgUrl, @RequestParam("item_no") String item_no, @RequestParam("imgId") String imgId) throws Exception {
		System.out.println("itemno3###########################"+item_no);
		return s3Service.setImgUrl(imgUrl, item_no, imgId);
		
	}
}
