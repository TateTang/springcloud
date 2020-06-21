package com.tmf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "getFallback")//调用出错调用方法进行服务降级，服务提供方降级
    public Object get(@PathVariable("id") long id) {
        Product product = this.iProductService.get(id);
        if (product == null) {
            throw new RuntimeException("该产品已下架！");
        }
        return product;
    }

    //服务熔断 降级的方法，参数需要和调用的地方的参数保持一致
    public Object getFallback(@PathVariable("id") long id) {
        Product product = new Product();
        product.setProductName("HystrixName");
        product.setProductDesc("HystrixDesc");
        product.setProductId(0L);
        return product;
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
