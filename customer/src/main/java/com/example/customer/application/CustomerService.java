package com.example.customer.application;


import com.example.customer.application.commands.CreateCustomerCommand;
import com.example.customer.application.commands.UpdateCustomerCommand;
import com.example.customer.domain.CustomerAggregate;
import com.example.customer.infrastructure.database.CustomerRepository;
import com.example.customer.infrastructure.database.DatabaseEntityMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerCreationService customerCreationService;

    public CustomerService(CustomerRepository customerRepository, CustomerCreationService customerCreationService) {
        this.customerRepository = customerRepository;
        this.customerCreationService = customerCreationService;
    }

    @Transactional
    public UUID createCustomer(CreateCustomerCommand command) {
        CustomerAggregate customerAggregate = customerCreationService.createCustomerFromCommand(command);
        customerRepository.save(DatabaseEntityMapper.mapToEntity(customerAggregate));
        return customerAggregate.getCustomerId();
    }

    @Transactional
    public void updateCustomer(UpdateCustomerCommand command) {
        CustomerAggregate existingCustomer = getExistingCustomer(command.getCustomerId());

        String newFirstName = command.getFirstName();
        String newLastName = command.getLastName();
        String newEmail = command.getEmail();
        String newPhoneNumber = command.getPhoneNumber();

        existingCustomer.update(newFirstName, newLastName, newEmail, newPhoneNumber);

        customerRepository.save(DatabaseEntityMapper.mapToEntity(existingCustomer));
    }

    @Transactional
    public void deleteCustomer(UUID customerId) {
        CustomerAggregate existingCustomer = getExistingCustomer(customerId);
        customerRepository.delete(DatabaseEntityMapper.mapToEntity(existingCustomer));
    }

    @Transactional(readOnly = true)
    public CustomerAggregate getCustomer(UUID customerId) {
        return getExistingCustomer(customerId);
    }

    private CustomerAggregate getExistingCustomer(UUID customerId) {
        return DatabaseEntityMapper.mapToDomain(customerRepository.getReferenceById(customerId))
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));
    }

}
