package com.codegym.services.customer;

import com.codegym.models.Customer;
import com.codegym.models.Province;
import com.codegym.repositorys.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return (List<Customer>)customerRepository.findAll();
    }

    @Override
    public List<Customer> findAllByProvince(Province province) {
        return (List<Customer>)customerRepository.findAllByProvince(province);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.delete(id);
    }
}
