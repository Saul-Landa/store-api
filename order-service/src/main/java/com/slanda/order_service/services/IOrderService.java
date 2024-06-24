package com.slanda.order_service.services;

import com.slanda.order_service.models.Order;
import com.slanda.order_service.models.OrderStatus;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();
    Order findById(Long id);
    Order save(Order order, Long vehicleId);
    Order updateStatus(OrderStatus orderStatus, Long id);

}
