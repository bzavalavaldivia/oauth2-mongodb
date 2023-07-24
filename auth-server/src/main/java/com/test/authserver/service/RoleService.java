package com.test.authserver.service;

import com.test.authserver.dto.CreateRoleDto;
import com.test.authserver.entity.Role;

public interface RoleService {
    public Role createRole(CreateRoleDto dto);
}
