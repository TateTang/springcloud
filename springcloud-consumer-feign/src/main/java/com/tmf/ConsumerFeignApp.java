package com.tmf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.tmf.*")
@EnableEurekaClient // 代表是一个Eureka的客户端
// @RibbonClient(name = "SPRINGCLOUD-PROVIDER" ,configuration =
// RibbonConfig.class)
// 扫描feign服务包
@EnableFeignClients("com.tmf.service")
public class ConsumerFeignApp {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignApp.class, args);
	}
}
