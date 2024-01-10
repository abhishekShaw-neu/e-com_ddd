package com.example.customer.application.commands;

import com.example.customer.application.dtos.CustomerDTO;

import java.util.UUID;

public class UpdateCustomerCommand {

    private UUID customerId;
    private CustomerDTO customerDTO;

    public UpdateCustomerCommand(UUID customerId, CustomerDTO customerDTO) {
        this.customerId = customerId;
        this.customerDTO = customerDTO;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }
}
