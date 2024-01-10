package com.example.customer.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Data
public class CustomerAggregate {
    private UUID customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<AddressValueObject> addresses;

    public CustomerAggregate(UUID customerId, String firstName, String lastName, String email, String phoneNumber) {
        validateInputs(firstName, lastName, email, phoneNumber);
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addresses = new ArrayList<>();
    }

    public void addAddress(AddressValueObject address) {
        addresses.add(address);
    }

    public void updateDetails(String firstName, String lastName, String email, String phoneNumber) {
        validateInputs(firstName, lastName, email, phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    private void validateInputs(String firstName, String lastName, String email, String phoneNumber) {
        if (Objects.isNull(firstName) || Objects.isNull(lastName) || Objects.isNull(email) || Objects.isNull(phoneNumber)
                || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("First name, last name, email, and phone number cannot be empty.");
        }
    }

}
