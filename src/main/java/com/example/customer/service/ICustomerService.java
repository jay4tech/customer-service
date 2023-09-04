package com.example.customer.service;

import com.example.customer.entity.Customer;

public interface ICustomerService {
    Customer getCustomer(Long id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long id);

    Customer updateCustomer(Customer customer);
}
