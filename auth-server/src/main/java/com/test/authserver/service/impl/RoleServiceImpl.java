package com.test.authserver.service.impl;

import com.test.authserver.dto.CreateRoleDto;
import com.test.authserver.entity.Role;
import com.test.authserver.repository.RoleRepository;
import com.test.authserver.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createRole(CreateRoleDto dto) {
        Role role = Role.builder()
                .name(dto.getName())
                .build();
        return roleRepository.save(role);
    }
}
