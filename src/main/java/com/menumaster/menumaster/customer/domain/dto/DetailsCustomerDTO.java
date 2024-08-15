package com.menumaster.menumaster.customer.domain.dto;

import com.menumaster.menumaster.authentication.enums.RoleName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DetailsCustomerDTO(
        @NotBlank
        String email,

        @NotBlank
        String name,

        @NotNull
        RoleName role,

        @NotBlank
        String cpf
) { }
