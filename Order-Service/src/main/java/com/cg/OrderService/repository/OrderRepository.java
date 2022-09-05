package com.cg.OrderService.repository;

import com.cg.OrderService.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order,Integer> {
    public String placedOrder(Order order);
}
