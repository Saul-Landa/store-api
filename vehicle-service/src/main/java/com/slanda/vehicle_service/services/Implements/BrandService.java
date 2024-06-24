package com.slanda.vehicle_service.services.Implements;

import com.slanda.vehicle_commons.models.Brand;
import com.slanda.vehicle_service.repositories.BrandRepository;
import com.slanda.vehicle_service.services.IBrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService implements IBrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findByName(String name) {
        return brandRepository.findByName(name);
    }

    @Override
    public Brand save(String name) {
        Brand brand = Brand.builder().name(name).build();
        return brandRepository.save(brand);
    }
}
