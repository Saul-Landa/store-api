package com.slanda.vehicle_service.utils;

import com.slanda.vehicle_service.services.IBrandService;
import com.slanda.vehicle_service.services.IVehicleTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class InitialData implements CommandLineRunner {

    private final IVehicleTypeService vehicleTypeService;
    private final IBrandService brandService;

    public InitialData(IVehicleTypeService vehicleTypeService, IBrandService brandService) {
        this.vehicleTypeService = vehicleTypeService;
        this.brandService = brandService;
    }

    @Override
    public void run(String... args) {
        try {
            List<String> brands = Arrays.asList("Audi", "Hyundai", "Kia", "Mazda", "Honda");
            brands.forEach( name -> {
                if ( brandService.findByName(name) == null ) {
                    brandService.save(name);
                }
            });

            String vehicleTypeName = "Van";
            if ( vehicleTypeService.findByName(vehicleTypeName)  == null ) {
                vehicleTypeService.save(vehicleTypeName);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
