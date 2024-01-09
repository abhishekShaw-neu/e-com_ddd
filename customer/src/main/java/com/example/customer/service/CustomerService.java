package com.example.customer.service;
import com.example.customer.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(Long customerId);
    void addCustomer(CustomerDTO customerDTO);
}
