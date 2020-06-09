package com.tmf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //Eureka注册中心，服务端，提供注册和发现功能
public class EurekaApp3 {
	public static void main(String[] args) {
		SpringApplication.run(EurekaApp3.class, args);
	}
}
