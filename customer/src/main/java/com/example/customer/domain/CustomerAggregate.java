package com.example.customer.domain;

import com.example.customer.application.dtos.AddressDTO;
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
    private List<AddressValueObject> addresses;
    private String phoneNumber;
    private String email;

    public CustomerAggregate(UUID customerId, String firstName, String lastName,
                             List<AddressValueObject> addresses, String phoneNumber, String email) {
        // Validation
        if (phoneNumber == null || email == null) {
            throw new IllegalArgumentException("Phone number and email cannot be null.");
        }

        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = addresses != null ? addresses : new ArrayList<>();
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public CustomerAggregate(String firstName, String lastName, String email, String phoneNumber, List<AddressDTO> addresses) {

    }
    public void update(String newFirstName, String newLastName, String newEmail, String newPhoneNumber) {
        if (newFirstName != null) {
            this.firstName = newFirstName;
        }

        if (newLastName != null) {
            this.lastName = newLastName;
        }

        if (newEmail != null) {
            this.email = newEmail;
        }

        if (newPhoneNumber != null) {
            this.phoneNumber = newPhoneNumber;
        }

    }


    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CustomerAggregate that = (CustomerAggregate) obj;
        return Objects.equals(customerId, that.customerId);
    }



    private void validateInputs(String firstName, String lastName, String email, String phoneNumber) {
        if (Objects.isNull(firstName) || Objects.isNull(lastName) || Objects.isNull(email) || Objects.isNull(phoneNumber)
                || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("First name, last name, email, and phone number cannot be empty.");
        }
    }

}
