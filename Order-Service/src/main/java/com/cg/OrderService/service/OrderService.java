package com.cg.OrderService.service;

import com.cg.OrderService.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public List<Order> getAllOrders();

    public Optional<Order> findOrderById(int id);

    public Order saveOrder(Order order);

    public void deleteOrderById(int id);
    public String placedOrder(Order order);

}
