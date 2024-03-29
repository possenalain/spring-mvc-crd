package com.nalain.services.jpaservices;

import com.nalain.SpringMvcApplication;
import com.nalain.config.JpaIntegrationConfig;
import com.nalain.domain.Customer;
import com.nalain.domain.User;
import com.nalain.services.CustomerService;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {SpringMvcApplication.class, JpaIntegrationConfig.class})
@ActiveProfiles({"jpaDao"})
@Setter
@Getter
class CustomerServiceDaoImplTest {
    @Autowired
    private CustomerService customerService;

    @Test
    void listAll() {
        List<Customer> customers = (List<Customer>) customerService.listAll();
        assertEquals(customers.size(),0);
    }

    @Test
    void getById() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("customer");
        Customer savedCustomer = customerService.save(customer);

        Customer custromerById = customerService.getById(savedCustomer.getId());
        assertEquals(savedCustomer.getId(),custromerById.getId());
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