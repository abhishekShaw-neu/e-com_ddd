package com.example.customer.application.controllers;

import com.example.customer.application.CustomerApplicationService;
import com.example.customer.application.commands.CreateCustomerCommand;
import com.example.customer.application.commands.UpdateCustomerCommand;
import com.example.customer.application.dtos.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerApplicationService customerApplicationService;

    public CustomerController(CustomerApplicationService customerApplicationService) {
        this.customerApplicationService = customerApplicationService;
    }

    @PostMapping
    public ResponseEntity<UUID> createCustomer(@RequestBody CreateCustomerCommand command) {
        UUID customerId = customerApplicationService.createCustomer(command);
        return new ResponseEntity<>(customerId, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable UUID customerId, @RequestBody UpdateCustomerCommand command) {
        command.setCustomerId(customerId);
        customerApplicationService.updateCustomer(command);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID customerId) {
        customerApplicationService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable UUID customerId) {
        CustomerDTO customerDTO = customerApplicationService.getCustomer(customerId);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }


}
