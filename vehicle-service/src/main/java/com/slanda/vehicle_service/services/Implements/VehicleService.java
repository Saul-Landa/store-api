package com.slanda.vehicle_service.services.Implements;

import com.slanda.vehicle_commons.models.Vehicle;
import com.slanda.vehicle_service.repositories.VehicleRepository;
import com.slanda.vehicle_service.services.IVehicleService;
import com.slanda.vehicle_service.services.IVehicleTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VehicleService implements IVehicleService {

    private final VehicleRepository vehicleRepository;
    private final IVehicleTypeService vehicleTypeService;

    public VehicleService(VehicleRepository vehicleRepository, IVehicleTypeService vehicleTypeService) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleTypeService = vehicleTypeService;
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAllByActiveIsTrue();
    }

    @Override
    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicle.setVehicleType(vehicleTypeService.findByName("Van"));
        vehicle.setHawa(UUID.randomUUID().toString());
        vehicle.setActive(true);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle update(Vehicle vehicle, Long id) {
        try {
            Vehicle vehicleDB = findById(id);
            if ( vehicle == null ) throw new Exception("Vehicle not found");

            vehicleDB.setActive(vehicle.isActive());
            vehicleDB.setColor(vehicle.getColor());
            vehicleDB.setModel(vehicle.getModel());
            vehicleDB.setPrice(vehicle.getPrice());
            vehicleDB.setDiscount(vehicle.getDiscount());
            vehicleDB.setStock(vehicle.getStock());
            vehicleDB.setDescription(vehicle.getDescription());
            vehicleDB.setBrand(vehicle.getBrand());

            return vehicleRepository.save(vehicleDB);
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            Vehicle vehicle = findById(id);
            if ( vehicle == null ) throw new Exception("Vehicle not found");

            vehicle.setActive(false);
            vehicleRepository.save(vehicle);

            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
