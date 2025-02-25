package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
public class DatabaseConfig {
	@Value("${spring.datasource.first.url}")
	private String url;

	@Value("${spring.datasource.first.username}")
	private String username;

	@Value("${spring.datasource.first.password}")
	private String password;
	
    @Value("${spring.datasource.first.driver-class-name}")
    private String driverClassName;
    
	@Value("${spring.datasource.second.url}")
	private String secondUrl;

	@Value("${spring.datasource.second.username}")
	private String secondUsername;

	@Value("${spring.datasource.second.password}")
	private String secondPassword;
	
    @Value("${spring.datasource.second.driver-class-name}")
    private String secondDriverClassName;
	
}
