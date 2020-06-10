package com.tmf.service;

import com.tmf.entity.Product;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2020/6/8 14:28
 * @Description
 */
public interface IProductService {
    Product get(long id);
    boolean add(Product product);
    List<Product> list();
}
