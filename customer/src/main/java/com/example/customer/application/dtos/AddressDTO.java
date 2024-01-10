package com.example.customer.application.dtos;


import lombok.Data;

@Data
public class AddressDTO {
    private String street;

    public AddressDTO(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    private String city;
    private String zipCode;


}
