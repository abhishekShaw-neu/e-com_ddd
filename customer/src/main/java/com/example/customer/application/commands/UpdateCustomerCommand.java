package com.example.customer.application.commands;


import com.example.customer.application.dtos.AddressDTO;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.UUID;


@Data
public class UpdateCustomerCommand {
    @NotNull(message = "Customer ID cannot be null")
    private UUID customerId;

    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @NotBlank(message = "Email cannot be blank")
    @Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$", message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Valid
    private List<AddressDTO> addresses;


    public UpdateCustomerCommand() {
    }

    public UpdateCustomerCommand(UUID customerId, String firstName, String lastName, String email, String phoneNumber, List<AddressDTO> addresses) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addresses = addresses;
    }

}

