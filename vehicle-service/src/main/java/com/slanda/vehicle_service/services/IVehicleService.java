package com.slanda.vehicle_service.services;

import com.slanda.vehicle_commons.models.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<Vehicle> findAll();
    Vehicle findById(Long id);
    Vehicle save(Vehicle vehicle);
    Vehicle update(Vehicle vehicle, Long id);
    boolean delete(Long id);
}
