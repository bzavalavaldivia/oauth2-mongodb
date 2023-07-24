package com.test.authserver.entity;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.test.authserver.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role implements GrantedAuthority {
    @MongoId
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;

    private RoleEnum name;

    @DBRef
    private List<User> users;

    @Override
    public String getAuthority() {
        return name.name();
    }
}
