package com.tmf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tmf.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tangmf
 * @Date 2020/6/29 16:11
 * @Description
 */
@RestController
@RequestMapping("/users")
public class UserController {
	@RequestMapping("/get/{name}")
	@HystrixCommand //dashboard监控的是hystrix的断路器
	public Object get(@PathVariable("name") String name) {
		User user = new User();
		user.setName(name);
		user.setAge(18);
		user.setSex("F");
		return user;
	}
}
