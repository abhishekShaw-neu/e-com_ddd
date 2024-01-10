package com.example.customer.application.queries;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class GetCustomerQuery {
    @NotNull(message = "Customer ID cannot be null")
    private UUID customerId;


    public GetCustomerQuery() {
    }

    public GetCustomerQuery(UUID customerId) {
        this.customerId = customerId;
    }

}

