package com.menumaster.menumaster.customer.domain.dto;

import com.menumaster.menumaster.authentication.domain.dto.CreateUserDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCustomerDTO(

        @NotNull
        CreateUserDto createUserDto,

        @NotBlank
        String cpf
) { }
