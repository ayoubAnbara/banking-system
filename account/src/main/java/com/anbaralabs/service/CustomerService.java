package com.anbaralabs.service;

import com.anbaralabs.dto.CustomerRequestDto;
import com.anbaralabs.dto.CustomerResponseDto;
import com.anbaralabs.entities.Customer;

import java.util.List;

/**
 * @author Ayoub Anbara
 */
public interface CustomerService {

   // Page<CustomerResponseDto> getCustomers();
    List<CustomerResponseDto> getCustomers();

    CustomerResponseDto getCustomerById(Long id);

    CustomerResponseDto addCustomer(CustomerRequestDto CustomerDto);

    void deleteCustomer(Long id);

    CustomerResponseDto updateCustomer(Long id, CustomerRequestDto CustomerRequestDto);
    Customer findEntityById(Long id);
}

