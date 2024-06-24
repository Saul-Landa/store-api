package com.slanda.vehicle_service.services;

import com.slanda.vehicle_commons.models.VehicleType;

import java.util.List;

public interface IVehicleTypeService {
    VehicleType findByName(String name);
    VehicleType save(String name);
}
