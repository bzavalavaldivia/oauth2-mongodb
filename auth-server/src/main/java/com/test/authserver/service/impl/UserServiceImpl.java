package com.test.authserver.service.impl;

import com.test.authserver.dto.CreateUserDto;
import com.test.authserver.entity.Role;
import com.test.authserver.entity.User;
import com.test.authserver.repository.RoleRepository;
import com.test.authserver.repository.UserRepository;
import com.test.authserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(CreateUserDto dto) {
        User user = User.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();

        Set<Role> roles = new HashSet<>();
        dto.getRoles().forEach(roleName -> {
            Role role = roleRepository.findByName(roleName)
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            roles.add(role);
        });

        user.setRoles(roles);

        return userRepository.save(user);
    }
}
