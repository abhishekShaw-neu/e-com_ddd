package com.example.customer.application.controllers;
import com.example.customer.application.CustomerApplicationService;
import com.example.customer.application.commands.CreateCustomerCommand;
import com.example.customer.application.commands.UpdateCustomerCommand;
import com.example.customer.application.dtos.CustomerDTO;
import com.example.customer.application.queries.GetCustomerQuery;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerApplicationService customerApplicationService;

    @Autowired
    public CustomerController(CustomerApplicationService customerApplicationService) {
        this.customerApplicationService = customerApplicationService;
    }

    @PostMapping
    public void createCustomer(@RequestBody CustomerDTO customerDTO) {
        CreateCustomerCommand command = new CreateCustomerCommand(customerDTO);
        customerApplicationService.createCustomer(command);
    }

    @PutMapping("/{customerId}")
    public void updateCustomer(@PathVariable UUID customerId, @RequestBody CustomerDTO customerDTO) {
        UpdateCustomerCommand command = new UpdateCustomerCommand(customerId, customerDTO);
        customerApplicationService.updateCustomer(command);
    }

    @GetMapping("/{customerId}")
    public CustomerDTO getCustomer(@PathVariable UUID customerId) {
        GetCustomerQuery query = new GetCustomerQuery(customerId);
        return customerApplicationService.getCustomer(query);
    }

}