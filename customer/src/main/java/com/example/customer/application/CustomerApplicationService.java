package com.example.customer.application;

import com.example.customer.application.commands.CreateCustomerCommand;
import com.example.customer.application.commands.UpdateCustomerCommand;
import com.example.customer.application.dtos.CustomerDTO;
import com.example.customer.application.queries.GetCustomerQuery;
import com.example.customer.domain.CustomerAggregate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerApplicationService {

    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerApplicationService(CustomerService customerService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    public void createCustomer(CreateCustomerCommand command) {
        CustomerDTO customerDTO = command.getCustomerDTO();
        CustomerAggregate customer = modelMapper.map(customerDTO, CustomerAggregate.class);
        customerService.createCustomer(customer);
    }

    public void updateCustomer(UpdateCustomerCommand command) {
        CustomerDTO customerDTO = command.getCustomerDTO();
        CustomerAggregate customer = modelMapper.map(customerDTO, CustomerAggregate.class);
        customerService.updateCustomer(command.getCustomerId(), customer);
    }

    public CustomerDTO getCustomer(GetCustomerQuery query) {
        CustomerAggregate customer = customerService.getCustomer(query.getCustomerId());
        return modelMapper.map(customer, CustomerDTO.class);
    }



}
