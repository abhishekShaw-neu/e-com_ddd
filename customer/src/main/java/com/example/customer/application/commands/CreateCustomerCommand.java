package com.example.customer.application.commands;

import com.example.customer.application.dtos.AddressDTO;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CreateCustomerCommand {
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

//    @Size(min = 1, message = "At least one address is required")
//    @Valid
    private List<AddressDTO> addresses;

    // Constructors, getters, and setters

    public CreateCustomerCommand() {
    }

    public CreateCustomerCommand(String firstName, String lastName, String email, String phoneNumber, List<AddressDTO> addresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addresses = addresses;
    }

    // Additional validation or business rules as needed
}


