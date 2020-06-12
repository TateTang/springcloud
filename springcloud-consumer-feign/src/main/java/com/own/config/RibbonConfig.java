package com.own.config;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

/**
 * 单个Ribbon负载均衡算法 配置，只对单个服务有效
 */
public class RibbonConfig {
    @Bean
    public IRule ribbonRule() { // 其中IRule就是所有规则的标准
        return new com.netflix.loadbalancer.RandomRule(); // 随机的访问策略
    }
}
