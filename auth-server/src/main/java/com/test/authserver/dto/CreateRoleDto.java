package com.test.authserver.dto;

import com.test.authserver.enums.RoleEnum;
import lombok.Builder;
import lombok.Data;

@Data
public class CreateRoleDto {
    private RoleEnum name;
}
