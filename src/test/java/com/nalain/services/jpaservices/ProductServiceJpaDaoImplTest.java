package com.nalain.services.jpaservices;

import com.nalain.SpringMvcApplication;
import com.nalain.config.JpaIntegrationConfig;
import com.nalain.domain.Product;
import com.nalain.services.ProductService;
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
@Getter
@Setter
class ProductServiceJpaDaoImplTest {

    @Autowired
    private ProductService productService;

    @Test
    void listAll() {
        List<Product> products = (List<Product>) productService.listAll();
        assertNotEquals(0,products.size());
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