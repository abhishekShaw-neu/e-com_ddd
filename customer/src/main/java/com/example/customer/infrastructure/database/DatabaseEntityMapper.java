package com.example.customer.infrastructure.database;

import com.example.customer.domain.AddressValueObject;
import com.example.customer.domain.CustomerAggregate;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DatabaseEntityMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private DatabaseEntityMapper() {
        // Private constructor to prevent instantiation
    }

    public static CustomerEntity mapToEntity(CustomerAggregate customer) {
        CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
        customerEntity.setAddresses(mapToAddressEntities(customer.getAddresses()));
        return customerEntity;
    }

    public static Optional<CustomerAggregate> mapToDomain(CustomerEntity entity) {
        if (entity == null) {
            return Optional.empty();
        }

        CustomerAggregate customer = modelMapper.map(entity, CustomerAggregate.class);
        customer.setAddresses(mapToAddressValueObjects(entity.getAddresses()));
        return Optional.of(customer);
    }

    public static List<AddressEntity> mapToAddressEntities(List<AddressValueObject> addresses) {
        if (addresses == null) {
            return Collections.emptyList();
        }

        return addresses.stream()
                .map(address -> {
                    AddressEntity addressEntity = new AddressEntity();
                    // Mapping logic here
                    return addressEntity;
                })
                .collect(Collectors.toList());
    }

    private static List<AddressValueObject> mapToAddressValueObjects(List<AddressEntity> addressEntities) {
        return addressEntities.stream()
                .map(addressEntity -> modelMapper.map(addressEntity, AddressValueObject.class))
                .collect(Collectors.toList());
    }
}
