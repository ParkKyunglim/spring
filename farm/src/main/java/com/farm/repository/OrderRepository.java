package com.farm.repository;

import com.farm.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // 유저 ID(uid)로 주문 찾기
    Optional<Order> findByUid(String uid);

    // 주문을 ID 순으로 내림차순 정렬하여 조회
    List<Order> findAllByOrderByIdDesc();
}
