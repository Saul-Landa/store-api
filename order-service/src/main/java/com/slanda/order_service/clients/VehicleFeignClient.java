package com.slanda.order_service.clients;

import com.slanda.vehicle_commons.models.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vehicle-service")
public interface VehicleFeignClient {

    @GetMapping("/{id}")
    Vehicle findById(@PathVariable Long id);

}
