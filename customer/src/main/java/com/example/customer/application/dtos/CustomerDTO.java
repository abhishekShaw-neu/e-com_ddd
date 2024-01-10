package com.example.customer.application.dtos;


import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CustomerDTO {
    private UUID customerId;

    public CustomerDTO(UUID customerId, String firstName, String lastName, String email, String phoneNumber, List<AddressDTO> addresses) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addresses = addresses;
    }

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<AddressDTO> addresses;


}
