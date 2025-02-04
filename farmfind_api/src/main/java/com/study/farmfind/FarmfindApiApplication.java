package com.study.farmfind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages="com.study.farmfind")
public class FarmfindApiApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(FarmfindApiApplication.class);

	
	public static void main(String[] args) {
		logger.info("Application starting...");
		SpringApplication.run(FarmfindApiApplication.class, args);
	}
	
	//API CORS 설정 Bean
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(
                		"http://localhost:8090",
                		"http://farmfind.store:8080",
                		"https://farmfind.store:8080",
                		"http://farmfind.store",
                		"https://farmfind.store",
						//2025
						"https://farmfind.shop",
						"https://farmfind.shop:8090"
                		);
            }
        };
    }

}
