package com.tmf.controller;

import com.tmf.entity.Product;
import com.tmf.service.IProductService;
import javax.annotation.Resource;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tangmf
 * @Date 2020/6/8 14:28
 * @Description
 */
@RestController
@RequestMapping("/product")
public class ProductController {
	@Resource
	private IProductService iProductService;
	@Resource
	private DiscoveryClient client; // 进行Eureka的发现服务

	@RequestMapping(value = "/get/{id}")
	public Object get(@PathVariable("id") long id) {
		return this.iProductService.get(id);
	}

	@RequestMapping(value = "/add")
	public Object add(@RequestBody Product product) {
		return this.iProductService.add(product);
	}

	@RequestMapping(value = "/list")
	public Object list() {
		return this.iProductService.list();
	}

	@RequestMapping("/discover")
	public Object discover() {
		return this.client; // 直接返回发现的服务信息
	}
}
