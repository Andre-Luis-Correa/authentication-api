package com.menumaster.menumaster.customer.repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.menumaster.menumaster.customer.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
