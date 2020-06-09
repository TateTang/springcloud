package com.tmf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author tangmf
 * @Date 2020/6/9 16:23
 * @Description Eureka安全配置类 关闭csrf劫持，当eureka配置了用户名和密码的时候需要使用
 */
@Configuration
@EnableWebSecurity
public class EurekaSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		super.configure(http);
	}
}
