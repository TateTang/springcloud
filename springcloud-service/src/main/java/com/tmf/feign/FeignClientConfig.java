package com.tmf.feign;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description feign接口服务daunt相关配置，包括了请求接口密码
 * @Author tangmf
 */
@Configuration
public class FeignClientConfig {
	@Bean
	public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("admin", "tmf");
	}

	// 新增Feign日志级别，因为默认的级别是null,所以如果没有这个配置即使在yml中有配置也不出来
	@Bean
	public Logger.Level getFeignLoggerLevel() {
		return Logger.Level.FULL;
	}

}
