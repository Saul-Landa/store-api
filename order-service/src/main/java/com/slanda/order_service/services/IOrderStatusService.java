package com.slanda.order_service.services;

import com.slanda.order_service.models.OrderStatus;

import java.util.List;

public interface IOrderStatusService {
    List<OrderStatus> findAll();
    OrderStatus findByName(String name);
    OrderStatus save(String name);
}
