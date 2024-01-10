package com.example.customer.application.commands;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class DeleteCustomerCommand {
    @NotNull(message = "Customer ID cannot be null")
    private UUID customerId;


    public DeleteCustomerCommand() {
    }

    public DeleteCustomerCommand(UUID customerId) {
        this.customerId = customerId;
    }

}
