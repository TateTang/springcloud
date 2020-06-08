package com.tmf.controller;

import com.tmf.entity.Product;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {
	private static final String PRODUCT_GET_URL = "http://localhost:8080/prodcut/get/";
	private static final String PRODUCT_LIST_URL = "http://localhost:8080/product/list/";
	private static final String PRODUCT_ADD_URL = "http://localhost:8080/prodcut/add/";
	@Resource
	private RestTemplate restTemplate;

	@Resource
	private HttpHeaders httpHeaders;

	@RequestMapping("/product/get")
	public Object getProduct(long id) {
		return restTemplate.exchange(PRODUCT_GET_URL + id, HttpMethod.GET, new HttpEntity<>(httpHeaders), Product.class)
				.getBody();
	}

	@RequestMapping("/product/list")
	public Object listProduct() {
		return restTemplate.exchange(PRODUCT_LIST_URL, HttpMethod.GET, new HttpEntity<>(httpHeaders), List.class)
				.getBody();
	}

	@RequestMapping("/product/add")
	public Object addPorduct(Product product) {
		return restTemplate
				.exchange(PRODUCT_ADD_URL, HttpMethod.POST, new HttpEntity<Object>(product, httpHeaders), Boolean.class)
				.getBody();
	}
}
