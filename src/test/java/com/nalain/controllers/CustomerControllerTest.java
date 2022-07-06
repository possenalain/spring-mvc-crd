package com.nalain.controllers;

import com.nalain.SpringMvcApplication;
import com.nalain.config.JpaIntegrationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {SpringMvcApplication.class, JpaIntegrationConfig.class})
@ActiveProfiles({"jpaDao"})
class CustomerControllerTest {

    @Test
    void listAllCustomers() {
    }

    @Test
    void findById() {
    }

    @Test
    void newCustomer() {
    }

    @Test
    void saveOrUpdateCustomer() {
    }

    @Test
    void editCustomer() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void getCustomerService() {
    }

    @Test
    void setCustomerService() {
    }
}