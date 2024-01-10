package com.example.customer.infrastructure.database;

import com.example.customer.domain.AddressValueObject;
import com.example.customer.domain.CustomerAggregate;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class DatabaseEntityMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static CustomerEntity mapToEntity(CustomerAggregate customer) {
        CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
        customerEntity.setAddresses(mapToAddressEntities(customer.getAddresses()));
        return customerEntity;
    }

    public static CustomerAggregate mapToDomain(CustomerEntity entity) {
        CustomerAggregate customer = modelMapper.map(entity, CustomerAggregate.class);
        customer.setAddresses(mapToAddressValueObjects(entity.getAddresses()));
        return customer;
    }

    private static List<AddressEntity> mapToAddressEntities(List<AddressValueObject> addresses) {
        return addresses.stream()
                .map(address -> modelMapper.map(address, AddressEntity.class))
                .collect(Collectors.toList());
    }

    private static List<AddressValueObject> mapToAddressValueObjects(List<AddressEntity> addressEntities) {
        return addressEntities.stream()
                .map(addressEntity -> modelMapper.map(addressEntity, AddressValueObject.class))
                .collect(Collectors.toList());
    }

}
