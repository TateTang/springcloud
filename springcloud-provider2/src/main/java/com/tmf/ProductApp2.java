package com.tmf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.tmf.*")
@MapperScan("com.tmf.mapper")
@EnableEurekaClient // 代表是一个Eureka的客户端
@EnableDiscoveryClient // 启用DiscoveryClient实现。
public class ProductApp2 {
	public static void main(String[] args) {
		SpringApplication.run(ProductApp2.class, args);
	}
}
