package com.slanda.order_service.services.Implements;

import com.slanda.order_service.models.Order;
import com.slanda.order_service.models.OrderStatus;
import com.slanda.order_service.models.OrderVehicle;
import com.slanda.order_service.repositories.OrderRepository;
import com.slanda.order_service.services.IOrderService;
import com.slanda.order_service.services.IOrderStatusService;
import com.slanda.order_service.services.IOrderVehicleService;
import com.slanda.order_service.services.IVehicleService;
import com.slanda.order_service.utils.GlobalVariables;
import com.slanda.vehicle_commons.models.Vehicle;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;
    private final IVehicleService vehicleService;
    private final IOrderStatusService orderStatusService;
    private final IOrderVehicleService orderVehicleService;

    public OrderService(OrderRepository orderRepository, IVehicleService vehicleService, IOrderStatusService orderStatusService, IOrderVehicleService orderVehicleService) {
        this.orderRepository = orderRepository;
        this.vehicleService = vehicleService;
        this.orderStatusService = orderStatusService;
        this.orderVehicleService = orderVehicleService;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order save(Order order, Long vehicleId) {
        OrderStatus orderStatus = orderStatusService.findByName(GlobalVariables.PENDING_STATUS);
        order.setOrderStatus(orderStatus);
        order.setDateCreated(new Date());
        order = orderRepository.save(order);

        Vehicle vehicle = vehicleService.findById(vehicleId);
        OrderVehicle orderVehicle = OrderVehicle.builder()
                                            .order(order)
                                            .vehicle(vehicle)
                                            .quantity(GlobalVariables.DEFAULT_QUANTITY)
                                            .build();

        orderVehicleService.save(orderVehicle);

        return order;
    }

    @Override
    public Order updateStatus(OrderStatus orderStatus, Long id) {
        try {
            Order order = findById(id);
            if ( order == null ) throw new Exception("Order not found");

            if ( !canChangeStatus(order, orderStatus.getName()) ) return null;

            order.setOrderStatus(orderStatus);
            return orderRepository.save(order);
        } catch (Exception exception) {
            return null;
        }
    }

    public boolean canChangeStatus(Order order, String statusName) {
        try {
            if ( statusName.equals(GlobalVariables.DELIVERED_STATUS) ) return true;

            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime creationTime = order.getDateCreated().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            Duration duration = Duration.between(creationTime, currentTime);
            long minutesPassed = duration.toMinutes();

            if ( minutesPassed > 10 ) throw new Exception("More than 10 minutes have already passed.");

            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
