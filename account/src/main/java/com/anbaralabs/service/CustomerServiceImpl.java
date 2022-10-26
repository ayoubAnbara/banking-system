package com.anbaralabs.service;

import com.anbaralabs.dto.CustomerRequestDto;
import com.anbaralabs.dto.CustomerResponseDto;
import com.anbaralabs.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ayoub Anbara
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Override
    public List<CustomerResponseDto> getCustomers() {
        return null;
    }

    @Override
    public CustomerResponseDto getCustomerById(Long id) {
        return null;
    }

    @Override
    public CustomerResponseDto addCustomer(CustomerRequestDto CustomerDto) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }

    @Override
    public CustomerResponseDto updateCustomer(Long id, CustomerRequestDto CustomerRequestDto) {
        return null;
    }

    @Override
    public Customer findEntityById(Long id) {
        return null;
    }
}
