/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uasmariatrielsa.uas.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.uasmariatrielsa.uas.model.Customer;
import com.uasmariatrielsa.uas.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found")
                );
    }

    public Customer create(Customer customer) {
        if (customer.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Customer already exists"
            );
        }
        if (customerRepository.existsByName(customer.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Customer name already exists");
        }
        return customerRepository.save(customer);
    }

    public Customer update(Long id, Customer customer) {
        getById(id);
        customer.setId(id);
        return customerRepository.save(customer);
    }

    public Customer delete(Long id) {
        Customer customer = getById(id);
        customerRepository.delete(customer);
        return customer;
    }
}
