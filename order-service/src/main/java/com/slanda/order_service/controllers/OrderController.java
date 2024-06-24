package com.slanda.order_service.controllers;

import com.slanda.order_service.models.Order;
import com.slanda.order_service.models.OrderStatus;
import com.slanda.order_service.models.OrderVehicle;
import com.slanda.order_service.services.IOrderService;
import com.slanda.order_service.services.IOrderStatusService;
import com.slanda.order_service.services.IOrderVehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class OrderController {
    private final IOrderService orderService;
    private final IOrderStatusService orderStatusService;
    private final IOrderVehicleService orderVehicleService;

    public OrderController(IOrderService orderService, IOrderStatusService orderStatusService, IOrderVehicleService orderVehicleService) {
        this.orderService = orderService;
        this.orderStatusService = orderStatusService;
        this.orderVehicleService = orderVehicleService;
    }

    @GetMapping("/")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable("id") Long id) {
        return orderService.findById(id);
    }

    @GetMapping("/details/{orderId}")
    public OrderVehicle findOrderArticle(@PathVariable("orderId") Long orderId) {
        return orderVehicleService.findByOrder(orderService.findById(orderId));
    }

    @PostMapping("/{vehicleId}")
    public Order save(@RequestBody Order order, @PathVariable("vehicleId") Long vehicleId, HttpServletRequest httpRequest) {
        order.setIpAddress(httpRequest.getRemoteAddr());
        return orderService.save(order, vehicleId);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Object> updateStatus(@RequestBody OrderStatus orderStatus, @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok( orderService.updateStatus(orderStatus, id) );
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

    @GetMapping("/status")
    public List<OrderStatus> getAllStatus() {
        return orderStatusService.findAll();
    }
}
