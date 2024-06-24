package com.slanda.user_service.services;

import com.slanda.user_commons.models.Role;

public interface IRoleService {
    Role findByName(String name);
    Role save(String name);
}
