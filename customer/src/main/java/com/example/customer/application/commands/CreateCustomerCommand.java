package com.example.customer.application.commands;

import com.example.customer.application.dtos.CustomerDTO;

public class CreateCustomerCommand {

    private CustomerDTO customerDTO;

    public CreateCustomerCommand(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }
}
