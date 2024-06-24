package com.slanda.order_service.services.Implements;

import com.slanda.order_service.models.OrderStatus;
import com.slanda.order_service.repositories.OrderStatusRepository;
import com.slanda.order_service.services.IOrderStatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusService implements IOrderStatusService {
    private final OrderStatusRepository orderStatusRepository;

    public OrderStatusService(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @Override
    public List<OrderStatus> findAll() {
        return orderStatusRepository.findAll();
    }

    @Override
    public OrderStatus findByName(String name) {
        return orderStatusRepository.findByName(name);
    }

    @Override
    public OrderStatus save(String name) {
        OrderStatus orderStatus = OrderStatus.builder().name(name).build();
        return orderStatusRepository.save(orderStatus);
    }
}
