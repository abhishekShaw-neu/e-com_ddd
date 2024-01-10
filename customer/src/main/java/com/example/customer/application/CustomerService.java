package com.example.customer.application;

import com.example.customer.domain.CustomerAggregate;

import java.util.UUID;

public interface CustomerService {

    void createCustomer(CustomerAggregate customer);
    void updateCustomer(UUID customerId, CustomerAggregate customer);
    void deleteCustomer(UUID customerId);
    CustomerAggregate getCustomer(UUID customerId);
}
