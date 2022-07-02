package com.nalain.services;

import com.nalain.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

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
        if(id!=null){
            return customers.get(id);
        }
        return null;
    }

    @Override
    public Customer deleteCustomer(Integer id) {
        if(id!=null){
           return customers.remove(id);
        }
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer saveOrUpdateProduct(Customer customer) {

        if(customer!=null){
            if(customer.getId()==null){
                customer.setId(Collections.max(customers.keySet())+1);
            }
           customers.put(customer.getId(),customer);
            return customer;

        }
        else {
            throw new RuntimeException("customer can't be null");
        }

    }


    private Map<Integer, Customer>  loadDummyCustomers() {

        Map<Integer, Customer> customers = new HashMap<>();

        for (int i = 1; i <= 10; i++) {

            Customer customer = new Customer();
            customer.setId(i);
            customer.setFirstName("firstname" +i);
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
