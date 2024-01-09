package com.study.farmfind;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.regions.Region;

@Configuration
public class AWSConfig {
	
	 @Value("${aws.accessKey}")
	    private String accessKey;

	    @Value("${aws.secretKey}")
	    private String secretKey;

	    @Value("${aws.region}")
	    private String region;
	    
	    @Value("${aws.bucketname}")
	    private String bucketname;
	    
	    //권한
	    @Bean
	    public AwsCredentials awsCredentials() {
	        return AwsBasicCredentials.create(accessKey, secretKey);
	    }
	    
	    //지역설정(서울)
	    @Bean
	    public Region awsRegion() {
	        return Region.of(region);
	    }
	    
	    @Bean
	    public String bucketName() {
	    	return bucketname;
	    }

	    

}
