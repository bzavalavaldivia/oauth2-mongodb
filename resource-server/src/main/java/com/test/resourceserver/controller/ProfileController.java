package com.test.resourceserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {
    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<Map<String, Object>> user(Authentication authentication) {
        Map<String, Object> details = new HashMap<>();
        details.put("username", authentication.getName());
        details.put("authorities", authentication.getAuthorities());
        return ResponseEntity.ok(details);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<Map<String, Object>> admin(Authentication authentication) {
        Map<String, Object> details = new HashMap<>();
        details.put("username", authentication.getName());
        details.put("authorities", authentication.getAuthorities());
        return ResponseEntity.ok(details);
    }
}
