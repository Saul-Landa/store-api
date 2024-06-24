package com.slanda.order_service.services.Implements;

import com.slanda.order_service.clients.VehicleFeignClient;
import com.slanda.order_service.services.IVehicleService;
import com.slanda.vehicle_commons.models.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class VehicleService implements IVehicleService {

    private final VehicleFeignClient vehicleFeignClient;

    public VehicleService(VehicleFeignClient vehicleFeignClient) {
        this.vehicleFeignClient = vehicleFeignClient;
    }

    @Override
    public Vehicle findById(Long id) {
        return vehicleFeignClient.findById(id);
    }
}
