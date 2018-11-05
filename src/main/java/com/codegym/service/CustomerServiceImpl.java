package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static Map<Integer, Customer> cutomers;
    static {
        cutomers = new HashMap<>();
        cutomers.put(1, new Customer(1, "hihi", "gmail.com", "ha noi"));
        cutomers.put(2, new Customer(2, "hihi1", "gmail.com", "hanoi2"));
        cutomers.put(3, new Customer(3, "hihi", "gmail.com", "ha noi"));
        cutomers.put(4, new Customer(4, "hihi1", "gmail.com", "hanoi2"));
        cutomers.put(5, new Customer(5, "hihi", "gmail.com", "ha noi"));
        cutomers.put(6, new Customer(6, "hihi1", "gmail.com", "hanoi2"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<Customer>(cutomers.values());
    }

    @Override
    public void save(Customer customer) {
        cutomers.put(customer.getId(), customer);

    }

    @Override
    public Customer findById(int id) {

        return cutomers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        cutomers.put(id, customer);

    }

    @Override
    public void remove(int id) {
        cutomers.remove(id);

    }
}
