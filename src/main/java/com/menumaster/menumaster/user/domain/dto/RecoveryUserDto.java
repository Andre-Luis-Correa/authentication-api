package com.menumaster.menumaster.user.domain.dto;

import com.menumaster.menumaster.user.domain.entity.Role;

import java.util.List;

public record RecoveryUserDto(

        Long id,
        String email,
        List<Role> roles

) {
}
