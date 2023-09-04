package com.example.customer.controller;

import com.example.customer.entity.Customer;
import com.example.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  @Autowired
  ICustomerService customerService;
  @GetMapping("/{id}")
  public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
    return ResponseEntity.ok(customerService.getCustomer(id));
  }
  @PostMapping("/")
  public Customer saveCustomer(@RequestBody Customer customer) {
    return customerService.saveCustomer(customer);
  }
  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
  }
  @PutMapping("/{id}")
  public Customer updateCustomer(@RequestBody Customer customer) {
    return customerService.updateCustomer(customer);
  }
}