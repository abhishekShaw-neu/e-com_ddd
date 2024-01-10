package com.example.customer.domain;


import lombok.Data;

import java.util.Objects;

@Data
public class AddressValueObject {
    private String street;
    private String city;
    private String state;
    private String zipCode;
//    private void validateInputs(String street, String city, String state, String zipCode) {
//        if (Objects.isNull(street) || Objects.isNull(city) || Objects.isNull(state) || Objects.isNull(zipCode)
//                || street.isEmpty() || city.isEmpty() || state.isEmpty() || zipCode.isEmpty()) {
//            throw new IllegalArgumentException("Street, city, state, and zip code cannot be empty.");
//        }
//    }

}