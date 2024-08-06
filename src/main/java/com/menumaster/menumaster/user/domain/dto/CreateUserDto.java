package com.menumaster.menumaster.user.domain.dto;

import com.menumaster.menumaster.enums.RoleName;

public record CreateUserDto(

        String email,
        String password,
        RoleName role

) {
}
