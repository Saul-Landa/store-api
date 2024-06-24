package com.slanda.vehicle_service.services;

import com.slanda.vehicle_commons.models.Brand;

import java.util.List;

public interface IBrandService {
    List<Brand> findAll();
    Brand findByName(String name);
    Brand save(String name);
}
