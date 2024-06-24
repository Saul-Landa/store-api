package com.slanda.vehicle_service.repositories;

import com.slanda.vehicle_commons.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findAllByActiveIsTrue();
}
