package com.tmf.service.impl;

import com.tmf.entity.Product;
import com.tmf.mapper.ProductMapper;
import com.tmf.service.IProductService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author tangmf
 * @Date 2020/6/8 14:31
 * @Description
 */
@Service
public class ProductServiceImpl implements IProductService {
	@Resource
	private ProductMapper productMapper;

	@Override
	public Product get(long id) {
        return productMapper.findById(id);
	}

	@Override
	public boolean add(Product product) {
        return productMapper.create(product);
	}

	@Override
	public List<Product> list() {
        return productMapper.findAll();
	}
}
