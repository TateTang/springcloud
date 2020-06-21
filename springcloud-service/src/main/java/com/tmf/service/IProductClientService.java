package com.tmf.service;

import com.tmf.entity.Product;
import com.tmf.feign.FeignClientConfig;
import com.tmf.service.fallback.IProductClientServiceFallbackFactory;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 服务提供方接口的编写，通过这个可以调用eureka的服务
 * @Author tangmf
 */
// 配置Eureka的名字，配置文件的所在，添加fallback工厂类，出现问题调用
@FeignClient(name = "SPRINGCLOUD-PROVIDER", configuration = FeignClientConfig.class, fallbackFactory = IProductClientServiceFallbackFactory.class)
public interface IProductClientService {

    @RequestMapping("/product/get/{id}")
    Product getProduct(@PathVariable("id") long id);

    @RequestMapping("/product/list")
    List<Product> listProduct();

    @RequestMapping("/product/add")
    boolean addPorduct(Product product);

}
