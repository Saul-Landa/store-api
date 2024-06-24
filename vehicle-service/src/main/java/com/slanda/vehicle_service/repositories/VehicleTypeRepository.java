package com.slanda.vehicle_service.repositories;

import com.slanda.vehicle_commons.models.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
    VehicleType findByName(String name);
}
