/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uasmariatrielsa.uas.controller;

import com.uasmariatrielsa.uas.model.Customer;
import com.uasmariatrielsa.uas.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // http://localhost:8088/customer
    @GetMapping
    public List<Customer> getAll() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities()                );
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

  // http://localhost:8088/region/1   (PathVariable) Detail
    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

  // http://localhost:8088/customer
    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.update(id, customer);
    }

  // http://localhost:8088/customer/1
    @DeleteMapping("/{id}")
    public Customer delete(@PathVariable Long id) {
        return customerService.delete(id);
    }
}
