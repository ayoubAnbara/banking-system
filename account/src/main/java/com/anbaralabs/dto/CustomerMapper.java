package com.anbaralabs.dto;

import com.anbaralabs.entities.Customer;
import org.mapstruct.Mapper;

/**
 * @author Ayoub Anbara
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDto customerToCustomerResponseDto(Customer customer);
    Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto );
}
