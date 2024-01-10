package com.example.customer.application;

import com.example.customer.application.commands.CreateCustomerCommand;
import com.example.customer.application.commands.UpdateCustomerCommand;
import com.example.customer.application.dtos.AddressDTO;
import com.example.customer.application.dtos.CustomerDTO;
import com.example.customer.domain.AddressValueObject;
import com.example.customer.domain.CustomerAggregate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerApplicationService {

    private final CustomerService customerService;

    public CustomerApplicationService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Transactional
    public UUID createCustomer(CreateCustomerCommand command) {
        return customerService.createCustomer(command);
    }

    @Transactional
    public void updateCustomer(UpdateCustomerCommand command) {
        customerService.updateCustomer(command);
    }

    @Transactional
    public void deleteCustomer(UUID customerId) {
        customerService.deleteCustomer(customerId);
    }

    @Transactional(readOnly = true)
    public CustomerDTO getCustomer(UUID customerId) {
        CustomerAggregate customerAggregate = customerService.getCustomer(customerId);
        return mapToCustomerDTO(customerAggregate);
    }



    // Helper method to map CustomerAggregate to CustomerDTO
    private CustomerDTO mapToCustomerDTO(CustomerAggregate customerAggregate) {
        return new CustomerDTO(
                customerAggregate.getCustomerId(),
                customerAggregate.getFirstName(),
                customerAggregate.getLastName(),
                customerAggregate.getEmail(),
                customerAggregate.getPhoneNumber(),
                mapToAddressDTOs(customerAggregate.getAddresses())
        );
    }

    // Helper method to map AddressValueObject list to AddressDTO list
    private List<AddressDTO> mapToAddressDTOs(List<AddressValueObject> addressValueObjects) {
        return addressValueObjects.stream()
                .map(addressValueObject -> new AddressDTO(
                        addressValueObject.getStreet(),
                        addressValueObject.getCity(),
                        addressValueObject.getZipCode()
                ))
                .collect(Collectors.toList());
    }
}
