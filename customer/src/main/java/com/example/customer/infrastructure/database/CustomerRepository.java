package com.example.customer.infrastructure.database;

import com.example.customer.domain.CustomerAggregate;

public interface CustomerRepository {
    void save(CustomerAggregate customer);
    void update(CustomerAggregate customer);
    void delete(String customerId);
    CustomerAggregate findById(String customerId);
}
