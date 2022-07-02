package com.nalain.services;

import com.nalain.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomers();

    Customer findCustomerById(Integer id);

    Customer deleteCustomer(Integer id);

    Customer updateCustomer(Customer customer);
}
