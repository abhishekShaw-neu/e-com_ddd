package com.example.customer.application.dtos;


import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CustomerDTO {
    private UUID customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<AddressDTO> addresses;

}
