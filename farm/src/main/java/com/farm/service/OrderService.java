package com.farm.service;

import com.farm.entity.Order;
import com.farm.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // 장바구니에 있는 모든 주문 조회
    public List<Order> getAllOrders() {
        return orderRepository.findAllByOrderByIdDesc();
    }

    // 주문 추가
    @Transactional
    public Order addOrder(Order order) {
        order.setTotalPrice(order.getPrice() * order.getQuantity());
        return orderRepository.save(order);
    }

    // 주문 삭제
    @Transactional
    public void deleteOrder(String uid) {
        Optional<Order> order = orderRepository.findByUid(uid);
        order.ifPresent(orderRepository::delete);
    }

    // 수량 업데이트
    @Transactional
    public Order updateOrderQuantity(String uid, int newQuantity) {
        Order order = orderRepository.findByUid(uid)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문 ID"));

        order.setQuantity(newQuantity);
        order.setTotalPrice(order.getPrice() * newQuantity);

        return orderRepository.save(order);
    }
}
