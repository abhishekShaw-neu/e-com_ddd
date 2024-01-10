package com.example.customer.infrastructure.database;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class CustomerEntity {
    @Id
    private UUID customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    private List<AddressEntity> addresses;

}