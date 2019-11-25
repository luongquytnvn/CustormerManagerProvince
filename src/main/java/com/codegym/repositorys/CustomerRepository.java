package com.codegym.repositorys;

import com.codegym.models.Customer;
import com.codegym.models.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    List<Customer> findAllByProvince(Province province);
}
