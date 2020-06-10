package com.tmf.controller;

import java.net.URI;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {

	private static final String PRODUCT_TOPIC = "SPRINGCLOUD-PROVIDER";

	@Resource
	private RestTemplate restTemplate;

	@Resource
	private HttpHeaders httpHeaders;

	@Resource
	private LoadBalancerClient loadBalancerClient;

	@RequestMapping("/product/list")
	public Object listProduct() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose(PRODUCT_TOPIC);
		System.out.println("【*** ServiceInstance ***】host = " + serviceInstance.getHost() + "、port = "
				+ serviceInstance.getPort() + "、serviceId = " + serviceInstance.getServiceId());

		URI uri = URI.create(
				String.format("http://%s:%s/product/list", serviceInstance.getHost(), serviceInstance.getPort()));

		return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(httpHeaders), List.class).getBody();
	}
}
