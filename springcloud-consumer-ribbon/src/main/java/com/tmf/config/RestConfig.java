package com.tmf.config;

import java.nio.charset.Charset;
import java.util.Base64;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
	@Bean
//	@LoadBalanced // 可以让客户端拥有负载均衡的能力
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

//	@Bean
//	public IRule ribbonRule() { // 其中IRule就是所有规则的标准
//		return new com.netflix.loadbalancer.RandomRule(); // Ribbon负载均衡算法随机的访问策略
//	}
}
