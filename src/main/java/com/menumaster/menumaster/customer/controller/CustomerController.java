package com.menumaster.menumaster.customer.controller;

import com.menumaster.menumaster.authentication.domain.entity.User;
import com.menumaster.menumaster.authentication.service.UserService;
import com.menumaster.menumaster.customer.domain.dto.CreateCustomerDTO;
import com.menumaster.menumaster.customer.domain.dto.DetailsCustomerDTO;
import com.menumaster.menumaster.customer.domain.dto.UpdateCustomerDTO;
import com.menumaster.menumaster.customer.domain.entity.Customer;
import com.menumaster.menumaster.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<DetailsCustomerDTO> findById(@PathVariable Long id) {
        Customer customer = customerService.getOrThrowException(id);
        DetailsCustomerDTO detailsCustomerDTO = customerService.convertoToDetailsCustomerDTO(customer);

        return ResponseEntity.ok(detailsCustomerDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DetailsCustomerDTO>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/all-pageable")
    public ResponseEntity<Page<DetailsCustomerDTO>> findAll(Pageable pageable) {
        Page<DetailsCustomerDTO> customers = customerService.findAll(pageable);
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailsCustomerDTO> update(@PathVariable Long id, @RequestBody UpdateCustomerDTO updateCustomerDTO) {
        Customer customer = customerService.getOrThrowException(id);
        DetailsCustomerDTO detailsCustomerDTO = customerService.convertoToDetailsCustomerDTO(customer);

        return ResponseEntity.ok(detailsCustomerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Customer customer = customerService.getOrThrowException(id);
        customerService.delete(customer);
        return ResponseEntity.noContent().build();
    }
}
