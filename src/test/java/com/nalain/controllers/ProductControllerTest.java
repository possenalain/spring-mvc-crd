package com.nalain.controllers;

import com.nalain.SpringMvcApplication;
import com.nalain.config.JpaIntegrationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {SpringMvcApplication.class, JpaIntegrationConfig.class})
@ActiveProfiles({"jpaDao"})
class ProductControllerTest {

    @Test
    void listAllProducts() {
    }

    @Test
    void getProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void editProduct() {
    }

    @Test
    void newProduct() {
    }

    @Test
    void saveOrUpdateProduct() {
    }

    @Test
    void getProductService() {
    }

    @Test
    void setProductService() {
    }
}