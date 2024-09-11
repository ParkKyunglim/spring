package com.farm.controller;

import com.farm.entity.Order;
import com.farm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/market/cart")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 장바구니 페이지로 이동
    @GetMapping
    public String showCart(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "cart";  // cart.html (Thymeleaf 템플릿)
    }

    // 상품 추가 처리
    @PostMapping("/add")
    public String addOrder(@ModelAttribute Order order) {
        orderService.addOrder(order);
        return "redirect:/market/cart";
    }

    // 주문 삭제 처리
    @PostMapping("/delete")
    public String deleteOrder(@RequestParam String uid) {
        orderService.deleteOrder(uid);
        return "redirect:/market/cart";
    }

    // 수량 업데이트 처리
    @PostMapping("/update")
    public String updateOrderQuantity(@RequestParam String uid, @RequestParam int quantity) {
        orderService.updateOrderQuantity(uid, quantity);
        return "redirect:/market/cart";
    }
}
