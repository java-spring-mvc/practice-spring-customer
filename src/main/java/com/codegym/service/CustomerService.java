package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Long id);

    void remove(Long id);
}
