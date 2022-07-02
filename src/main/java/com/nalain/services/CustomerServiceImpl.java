package com.nalain.services;

import com.nalain.domain.Customer;
import com.nalain.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl  implements  CustomerService{

    Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        this.customers = loadDummyCustomers();
    }

    @Override
    public List<Customer> findAllCustomers() {
        return new  ArrayList<>(customers.values());
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return null;
    }

    @Override
    public Customer deleteCustomer(Integer id) {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }


    private Map<Integer, Customer>  loadDummyCustomers() {

        Map<Integer, Customer> customers = new HashMap<>();

        for (int i = 1; i <= 10; i++) {

            Customer customer = new Customer();
            customer.setId(i);
            customer.setFirsName("firstname" +i);
            customer.setLastName("lastname "+i);
            customer.setEmail("email " +i);
            customer.setPhoneNumber("phone number "+i);
            customer.setAddressLineOne("line one "+i);
            customer.setAddressLineTwo("line two "+i);
            customer.setCity("city"+i);
            customer.setState("state "+i);
            customer.setZipCode("zipcode "+i);

            customers.put(i,customer);
        }
        return customers;
    }

}
