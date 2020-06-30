package com.tmf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Author tangmf
 * @Date 2020/6/29 17:47
 * @Description
 */
@SpringBootApplication
@EnableTurbine // 集成turbine，去eureka中寻找
public class TurbineApp {
	public static void main(String[] args) {
		SpringApplication.run(TurbineApp.class, args);
	}
}
