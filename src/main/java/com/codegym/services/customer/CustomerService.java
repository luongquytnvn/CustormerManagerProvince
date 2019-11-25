package com.codegym.services.customer;

import com.codegym.models.Customer;
import com.codegym.models.Province;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    List<Customer> findAllByProvince(Province province);

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
