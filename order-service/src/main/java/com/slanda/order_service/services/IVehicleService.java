package com.slanda.order_service.services;

import com.slanda.vehicle_commons.models.Vehicle;

public interface IVehicleService {
    Vehicle findById(Long id);
}
