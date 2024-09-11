package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Product;
import com.ch07.repository.shop.ProductRepository;
import com.ch07.repository.shop.custom.ProductRepositoryCustom;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @Override
    public List<Product> selectProducts(){
        return null;
    }

    @Override
    public Product selectProduct(String productId){
        return null;
    }
}