package com.slanda.vehicle_service.controllers;

import com.slanda.vehicle_commons.models.Brand;
import com.slanda.vehicle_commons.models.Vehicle;
import com.slanda.vehicle_service.services.IBrandService;
import com.slanda.vehicle_service.services.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {
    private final IBrandService brandService;
    private final IVehicleService vehicleService;

    public VehicleController(IBrandService brandService, IVehicleService vehicleService) {
        this.brandService = brandService;
        this.vehicleService = vehicleService;
    }

    @GetMapping("/")
    public List<Vehicle> findAll() {
        return vehicleService.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle findById(@PathVariable("id") Long id) {
        return vehicleService.findById(id);
    }

    @PostMapping("/")
    public Vehicle save(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle update(@PathVariable("id") Long id, @RequestBody Vehicle vehicle) {
        return vehicleService.update(vehicle, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return vehicleService.delete(id)
                ? new ResponseEntity<>("Delete successfully", HttpStatus.OK)
                : new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/brands")
    public List<Brand> findAllBrands() {
        return brandService.findAll();
    }
}
