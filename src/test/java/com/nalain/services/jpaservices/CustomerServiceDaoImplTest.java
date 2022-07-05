package com.nalain.services.jpaservices;

import com.nalain.SpringMvcApplication;
import com.nalain.config.JpaIntegrationConfig;
import com.nalain.domain.Customer;
import com.nalain.domain.User;
import com.nalain.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {SpringMvcApplication.class, JpaIntegrationConfig.class})
@ActiveProfiles({"jpaDao"})
class CustomerServiceDaoImplTest {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    void listAll() {
        List<Customer> customers = (List<Customer>) customerService.listAll();
        assertNotNull(customers);
    }

    @Test
    void getById() {
    }

    @Test
    void saveWithUser() {

        Customer customer = new Customer();

        User user = new User();
        user.setUsername("someone");
        user.setPassword("password");
        customer.setUser(user);

        Customer savedCustomer = customerService.save(customer);

        assertNotNull(savedCustomer.getUser());

        System.out.println("\n\n*************************");
        System.out.println(savedCustomer);
        System.out.println("*************************\n\n");
    }

    @Test
    void delete() {
    }
}