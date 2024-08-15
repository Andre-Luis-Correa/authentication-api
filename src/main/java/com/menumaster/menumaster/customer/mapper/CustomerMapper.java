package com.menumaster.menumaster.customer.mapper;

import com.menumaster.menumaster.authentication.domain.dto.CreateUserDto;
import com.menumaster.menumaster.authentication.domain.entity.User;
import com.menumaster.menumaster.customer.domain.dto.CreateCustomerDTO;
import com.menumaster.menumaster.customer.domain.dto.DetailsCustomerDTO;
import com.menumaster.menumaster.customer.domain.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "email", source = "customer.user.email")
    @Mapping(target = "name", source = "customer.user.name")
    @Mapping(target = "role", source = "customer.user.role.name")
    DetailsCustomerDTO convertToDetailsCustomerDTO(Customer customer);

    CreateUserDto convertToCreateUserDTO(CreateCustomerDTO createCustomerDTO);

    @Mapping(target = "user", source = "user")
    Customer convertToCustomer(CreateCustomerDTO createCustomerDTO, User user);
}
