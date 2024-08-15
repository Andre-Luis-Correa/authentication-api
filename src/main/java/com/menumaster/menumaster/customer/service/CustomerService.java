package com.menumaster.menumaster.customer.service;

import com.menumaster.menumaster.authentication.domain.dto.CreateUserDto;
import com.menumaster.menumaster.authentication.domain.entity.User;
import com.menumaster.menumaster.authentication.service.UserService;
import com.menumaster.menumaster.customer.domain.dto.CreateCustomerDTO;
import com.menumaster.menumaster.customer.domain.dto.DetailsCustomerDTO;
import com.menumaster.menumaster.customer.domain.entity.Customer;
import com.menumaster.menumaster.customer.mapper.CustomerMapper;
import com.menumaster.menumaster.customer.repository.CustomerRepository;
import com.menumaster.menumaster.exception.type.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public Customer getOrThrowException(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer", id.toString()));
    }

    public DetailsCustomerDTO convertoToDetailsCustomerDTO(Customer customer) {
        return customerMapper.convertToDetailsCustomerDTO(customer);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public CreateUserDto convertToCreateUserDTO(CreateCustomerDTO createCustomerDTO) {
        return customerMapper.convertToCreateUserDTO(createCustomerDTO);
    }

    public Customer convertToCustomer(CreateCustomerDTO createCustomerDTO, User user) {
        return customerMapper.convertToCustomer(createCustomerDTO, user);
    }
}
