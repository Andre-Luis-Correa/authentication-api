package com.menumaster.menumaster.customer.controller;

import com.menumaster.menumaster.authentication.domain.entity.User;
import com.menumaster.menumaster.authentication.service.UserService;
import com.menumaster.menumaster.customer.domain.dto.CreateCustomerDTO;
import com.menumaster.menumaster.customer.domain.dto.DetailsCustomerDTO;
import com.menumaster.menumaster.customer.domain.entity.Customer;
import com.menumaster.menumaster.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<DetailsCustomerDTO> create(@RequestBody @Valid CreateCustomerDTO createCustomerDTO) {
        User user = userService.createUser(createCustomerDTO.createUserDto());

        Customer customer = customerService.convertToCustomer(createCustomerDTO, user);
        Customer savedCustomer = customerService.save(customer);

        DetailsCustomerDTO detailsCustomerDTO = customerService.convertoToDetailsCustomerDTO(savedCustomer);

        return ResponseEntity.ok(detailsCustomerDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetailsCustomerDTO> findById(@PathVariable Long id) {
        Customer customer = customerService.getOrThrowException(id);
        DetailsCustomerDTO detailsCustomerDTO = customerService.convertoToDetailsCustomerDTO(customer);

        return ResponseEntity.ok(detailsCustomerDTO);
    }
}
