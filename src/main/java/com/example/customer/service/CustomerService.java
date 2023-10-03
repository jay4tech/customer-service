package com.example.customer.service;

import com.example.customer.entity.Customer;
import com.example.customer.repository.ICustomerRepository;
import com.example.customer.util.RabbitHelper;
import com.example.customer.util.UtilityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    ICustomerRepository customerRepository;

    @Autowired
    RabbitHelper rabbitHelper;
    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Customer customerResponse = customerRepository.save(customer);
        rabbitHelper.sendEmailNotification(UtilityMapper.modelToString(customerResponse));
        return customerResponse;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findById(customer.getId());
        if(customerOptional.isPresent()){
            Customer customerDb = customerOptional.get();
            customerDb.setId(customer.getId());
        }
        return customer;
    }
}
