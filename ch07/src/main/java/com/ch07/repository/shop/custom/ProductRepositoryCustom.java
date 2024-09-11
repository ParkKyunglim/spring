package com.ch07.repository.shop.custom;

import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.Product;

import java.util.List;

public interface ProductRepositoryCustom {

    public List<Product> selectProducts();
    public Product selectProduct(String productId);
}