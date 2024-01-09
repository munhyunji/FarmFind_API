package com.study.farmfind.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.study.farmfind.mapper.S3Mapper;

import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;


@Service
public class S3Service {
	
	private final S3Client s3Client;
	private String bucketName;
	
	@Autowired
	private S3Mapper mapper;
	
	 @Autowired
    public S3Service(AwsCredentials awsCredentials, Region awsRegion, String bucketname) {
        this.s3Client = S3Client.builder()
                .region(awsRegion)
                .credentialsProvider(() -> awsCredentials)
                .build();
        this.bucketName = bucketname;
    }
	 
	  public String uploadFile(String key, MultipartFile file) throws Exception {
		  try {
	            // MultipartFile을 S3에 업로드
	            s3Client.putObject(PutObjectRequest.builder()
	                    .bucket(bucketName)
	                    .key(key)
	                    .contentType(file.getContentType())
	                    .build(),
	                    RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
	            

	            // 업로드 성공 로그 또는 추가 작업을 수행할 수 있습니다.
	            return key;

	        } catch (Exception e) {
	            // 업로드 실패 시 예외를 던지거나 로깅할 수 있습니다.
	            throw new IOException("파일 업로드 중 오류 발생: " + e.getMessage());
	        }
	    }

	public int setImgUrl(String imgUrl, String item_no, String imgId) throws Exception {
		return mapper.setImgUrl(imgUrl, item_no, imgId);
	}
	  
}
