package com.example.customer.repository;
import com.example.customer.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAll();

    boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);

}