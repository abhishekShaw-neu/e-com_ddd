package com.example.customer.application.commands;

import java.util.UUID;

public class DeleteCustomerCommand {

    private UUID customerId;

    public DeleteCustomerCommand(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getCustomerId() {
        return customerId;
    }
}
