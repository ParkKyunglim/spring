package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Order;
import com.ch07.repository.shop.custom.OrderRepositoryCustom;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepositoryCustom {

    @Override
    public List<Order> selectOrders() {
        return null;
    }

    @Override
    public Order selectOrder(String orderId) {
        return null;
    }
}