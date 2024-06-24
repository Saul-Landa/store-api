package com.slanda.user_service.services.Implements;

import com.slanda.user_commons.models.Role;
import com.slanda.user_service.repositories.RoleRepository;
import com.slanda.user_service.services.IRoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role save(String name) {
        Role role = Role.builder().name(name).build();
        return roleRepository.save(role);
    }
}
