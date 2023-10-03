package com.example.customer.controller;

import com.example.customer.entity.Customer;
import com.example.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jay Prakash Kumar
 *
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

  @Autowired
  ICustomerService customerService;

  /**
   * This API is used to get the customer
   * @param id
   * @return
   */
  @GetMapping("/{id}")
  public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
    return ResponseEntity.ok(customerService.getCustomer(id));
  }

  /**
   * @Description This API is used to save customer
   * @param customer
   * @return
   */
  @PostMapping("/")
  public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
    return  ResponseEntity.ok(customerService.saveCustomer(customer));
  }

  /**
   *
   * @param id
   */
  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
  }

  /**
   *
   * @param customer
   * @return
   */
  @PutMapping("/{id}")
  public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
    return ResponseEntity.ok(customerService.updateCustomer(customer));
  }
}