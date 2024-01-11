package com.example.customer.infrastructure.database;



import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID addressId;
    private String street;
    private String city;
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

}
