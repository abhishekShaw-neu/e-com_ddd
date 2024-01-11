package com.example.customer.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
}
