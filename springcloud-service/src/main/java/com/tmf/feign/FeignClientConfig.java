package com.tmf.feign;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @Description  feign接口服务daunt相关配置，包括了请求接口密码
 * @Author tangmf
 */
@Configuration
public class FeignClientConfig {
	@Bean
	public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("admin", "tmf");
	}

//	@Bean
//	public Logger.Level getFeignLoggerLevel() {
//		return Logger.Level.FULL;
//	}
}
