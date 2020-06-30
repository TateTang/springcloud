package com.tmf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author tangmf
 * @Date 2020/6/29 16:11
 * @Description
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
public class UserApp {
	public static void main(String[] args) {
		SpringApplication.run(UserApp.class, args);
	}
}
