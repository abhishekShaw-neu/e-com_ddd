package com.example.customer.application.queries;

import java.util.UUID;

public class GetCustomerQuery {

    private UUID customerId;

    public GetCustomerQuery(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getCustomerId() {
        return customerId;
    }
}
