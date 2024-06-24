package com.slanda.order_service.services;


import com.slanda.order_service.models.Order;
import com.slanda.order_service.models.OrderVehicle;

public interface IOrderVehicleService {
    OrderVehicle save(OrderVehicle orderVehicle);
    OrderVehicle findByOrder(Order order);
}
