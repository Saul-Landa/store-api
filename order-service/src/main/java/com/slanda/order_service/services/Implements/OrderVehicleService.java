package com.slanda.order_service.services.Implements;

import com.slanda.order_service.models.Order;
import com.slanda.order_service.models.OrderVehicle;
import com.slanda.order_service.repositories.OrderVehicleRepository;
import com.slanda.order_service.services.IOrderService;
import com.slanda.order_service.services.IOrderVehicleService;
import org.springframework.stereotype.Service;

@Service
public class OrderVehicleService implements IOrderVehicleService {
    private final OrderVehicleRepository orderVehicleRepository;

    public OrderVehicleService(OrderVehicleRepository orderVehicleRepository) {
        this.orderVehicleRepository = orderVehicleRepository;
    }

    @Override
    public OrderVehicle save(OrderVehicle orderVehicle) {
        return orderVehicleRepository.save(orderVehicle);
    }

    @Override
    public OrderVehicle findByOrder(Order order) {
        return orderVehicleRepository.findByOrder(order);
    }
}
