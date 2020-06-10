package com.tmf;

import com.own.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication(scanBasePackages = "com.tmf.*")
//@EnableEurekaClient// 代表是一个Eureka的客户端
@RibbonClient(name = "SPRINGCLOUD-PROVIDER" ,configuration = RibbonConfig.class)
public class ConsumerRibbonApp {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerRibbonApp.class, args);
	}
}
