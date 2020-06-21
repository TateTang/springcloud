package com.tmf.service.fallback;


import com.tmf.entity.Product;
import com.tmf.service.IProductClientService;
import feign.hystrix.FallbackFactory;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @Author tangmf
 * @Date 2020/6/8 14:28
 * @Description fallbackFactory工厂，服务消费者降级
 */
@Component
public class IProductClientServiceFallbackFactory implements
        FallbackFactory<IProductClientService> {

    @Override
    public IProductClientService create(Throwable throwable) {
        return new IProductClientService() {
            @Override
            public Product getProduct(long id) {
                Product product = new Product();
                product.setProductId(999999L);
                product.setProductName("feign-hystrixName");
                product.setProductDesc("feign-hystrixDesc");
                return product;
            }

            @Override
            public List<Product> listProduct() {
                return null;
            }

            @Override
            public boolean addPorduct(Product product) {
                return false;
            }
        };
    }
}