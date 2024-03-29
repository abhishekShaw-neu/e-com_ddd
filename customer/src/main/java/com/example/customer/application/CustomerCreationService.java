package com.example.customer.application;

import com.example.customer.application.commands.CreateCustomerCommand;
import com.example.customer.domain.CustomerAggregate;
import org.springframework.stereotype.Service;

@Service
public class CustomerCreationService {

    public CustomerAggregate createCustomerFromCommand(CreateCustomerCommand command) {
        return new CustomerAggregate(
                command.getFirstName(),
                command.getLastName(),
                command.getEmail(),
                command.getPhoneNumber(),
                command.getAddresses()
        );
    }
}
