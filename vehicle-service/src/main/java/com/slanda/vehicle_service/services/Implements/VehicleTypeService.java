package com.slanda.vehicle_service.services.Implements;

import com.slanda.vehicle_commons.models.VehicleType;
import com.slanda.vehicle_service.repositories.VehicleTypeRepository;
import com.slanda.vehicle_service.services.IVehicleTypeService;
import org.springframework.stereotype.Service;

@Service
public class VehicleTypeService implements IVehicleTypeService {

    private final VehicleTypeRepository vehicleTypeRepository;

    public VehicleTypeService(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    @Override
    public VehicleType findByName(String name) {
        return vehicleTypeRepository.findByName(name);
    }

    @Override
    public VehicleType save(String name) {
        VehicleType vehicleType = VehicleType.builder().name(name).build();
        return vehicleTypeRepository.save(vehicleType);
    }
}
