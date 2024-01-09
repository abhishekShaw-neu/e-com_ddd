package com.example.customer.service;

import com.example.customer.dto.CustomerDTO;
import com.example.customer.model.entity.Customer;
import com.example.customer.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        return optionalCustomer.map(this::convertToDTO).orElse(null);
    }


    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        if (customerDTO.getId() == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }

        // Check if a customer with the same email or phone number already exists
        if (customerRepository.existsByEmailOrPhoneNumber(customerDTO.getEmail(), customerDTO.getPhoneNumber())) {
            throw new IllegalArgumentException("Customer with the same email or phone number already exists");
        }

        Customer customer = convertToEntity(customerDTO);
        customerRepository.save(customer);
    }

    private CustomerDTO convertToDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    private Customer convertToEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, Customer.class);
    }
}
