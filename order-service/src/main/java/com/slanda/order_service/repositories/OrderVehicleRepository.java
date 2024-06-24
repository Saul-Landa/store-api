package com.slanda.order_service.repositories;

import com.slanda.order_service.models.Order;
import com.slanda.order_service.models.OrderVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderVehicleRepository extends JpaRepository<OrderVehicle, Long> {
    OrderVehicle findByOrder(Order order);
}
