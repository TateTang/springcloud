package com.tmf.controller;

import com.tmf.entity.Product;
import com.tmf.service.IProductClientService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {
	@Resource
	private IProductClientService productClientService;

	@RequestMapping("/product/get")
	public Object getProduct(long id) {
		return productClientService.getProduct(id);
	}

	@RequestMapping("/product/list")
	public Object listProduct() {
		return productClientService.listProduct();
	}

	@RequestMapping("/product/add")
	public Object addPorduct(Product product) {
		return productClientService.addPorduct(product);
	}
}
