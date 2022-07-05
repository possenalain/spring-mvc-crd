package com.nalain.services;

import com.nalain.domain.Customer;
import com.nalain.domain.DomainEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile("map")
public class CustomerServiceImpl  extends AbstractMapService implements  CustomerService{

    @Override
    public List<DomainEntity> listAll() {
        return new ArrayList<>(domainMap.values());
    }

    @Override
    public Customer getById(Integer id) {
        return (Customer) super.getById(id);
    }

    @Override
    public Customer save(Customer domainEntity) {



        return (Customer) super.save((DomainEntity) domainEntity);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
    void  loadDomainObjects() {

       domainMap = new HashMap<>();

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

            domainMap.put(i,customer);
        }

    }

}
