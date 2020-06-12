package com.tmf.service;

import com.tmf.entity.Product;
import com.tmf.feign.FeignClientConfig;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 服务提供方接口的编写，通过这个可以调用eureka的服务
 * @Author tangmf
 */
//配置Eureka的名字，配置文件的所在
@FeignClient(name = "SPRINGCLOUD-PROVIDER", configuration = FeignClientConfig.class)
public interface IProductClientService {
	@RequestMapping("/prodcut/get/{id}")
	public Product getProduct(@PathVariable("id") long id);

	@RequestMapping("/prodcut/list")
	public List<Product> listProduct();

	@RequestMapping("/prodcut/add")
	public boolean addPorduct(Product product);

}
