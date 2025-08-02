package com.data.session_10.repository;

import com.data.session_10.model.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    Customer findById(Long id);
    void save(Customer customer);
    void update(Customer customer);
    void delete(Long id);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}


