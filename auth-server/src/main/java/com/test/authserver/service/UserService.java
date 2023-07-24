package com.test.authserver.service;

import com.test.authserver.dto.CreateUserDto;
import com.test.authserver.entity.User;

public interface UserService {
    public User createUser(CreateUserDto dto);
}
