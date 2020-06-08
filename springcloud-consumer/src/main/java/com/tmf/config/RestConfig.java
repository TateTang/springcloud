package com.tmf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

@Configuration
public class RestConfig {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public HttpHeaders getHeaders() { // 要进行一个Http头信息配置
		HttpHeaders headers = new HttpHeaders(); // 定义一个HTTP的头信息
		String auth = "admin:tmf"; // 认证的原始信息
		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
		String authHeader = "Basic " + new String(encodedAuth);
		headers.set("Authorization", authHeader);
		return headers;
	}
}
