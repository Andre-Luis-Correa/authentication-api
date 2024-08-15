package com.menumaster.menumaster.authentication.domain.dto;

import com.menumaster.menumaster.authentication.enums.RoleName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserDto(
        @NotBlank
        String email,

        @NotBlank
        String password,

        @NotBlank
        String name,

        @NotNull
        RoleName role
) { }
