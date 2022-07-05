package com.nalain.services;

import com.nalain.SpringMvcApplication;
import com.nalain.config.JpaIntegrationConfig;
import com.nalain.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {SpringMvcApplication.class, JpaIntegrationConfig.class})
@ActiveProfiles({"jpaDao"})
class ProductServiceJpaDaoImplTest {


    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @Test
    void listAll() {
        List<Product> products = (List<Product>) productService.listAll();
        assertEquals(10,products.size());
    }

    @Test
    void getById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }
}