package com.test.authserver.controller;

import com.test.authserver.dto.CreateRoleDto;
import com.test.authserver.dto.CreateUserDto;
import com.test.authserver.entity.Role;
import com.test.authserver.entity.User;
import com.test.authserver.service.RoleService;
import com.test.authserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto dto) {
        User user = userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/roles")
    public ResponseEntity<Role> createRole(@RequestBody CreateRoleDto dto) {
        Role role = roleService.createRole(dto);
        return ResponseEntity.status(HttpStatus.OK).body(role);
    }
}
