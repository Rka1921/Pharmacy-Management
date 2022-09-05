package com.cg.OrderService.service.implementation;

import com.cg.OrderService.model.Order;
import com.cg.OrderService.repository.OrderRepository;
import com.cg.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImplementation implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findOrderById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public String placedOrder(Order order) {
        orderRepository.placedOrder(order);
        return "";

    }
}
