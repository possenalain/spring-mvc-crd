package com.nalain.services.jpaservices;

import com.nalain.SpringMvcApplication;
import com.nalain.config.JpaIntegrationConfig;
import com.nalain.domain.*;
import com.nalain.services.ProductService;
import com.nalain.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {SpringMvcApplication.class, JpaIntegrationConfig.class})
@ActiveProfiles({"jpaDao"})
class UserServiceDaoImplTest {

    private UserService userService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    private ProductService productService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Test
    void saveUser() {

        User user = new User();
        user.setUsername("someone");
        user.setPassword("password");

        User savedUser = userService.save(user);
        assertNotNull(savedUser.getEncryptedPassword());

        System.out.println(savedUser.getEncryptedPassword());
    }
    @Test
    void saveUserWithCustomer() {

        User user = new User();
        user.setUsername("someone");
        user.setPassword("password");


        Customer customer = new Customer();
        customer.setFirstName("customer 1");
        customer.setLastName("customer last name");

        user.setCustomer(customer);

        User savedUser = userService.save(user);

        assertNotNull(savedUser.getCustomer());

        System.out.println("\n\n*************************");
        System.out.println(savedUser);
        System.out.println("*************************\n\n");
    }


    @Test
    void addCartToUser() {

        User user = new User();
        user.setUsername("someone");
        user.setPassword("password");


       user.setCart(new Cart());

        User savedUser = userService.save(user);
        assertNotNull(savedUser.getCart());
        System.out.println("\n\n*************************");
        System.out.println(savedUser);
        System.out.println("*************************\n\n");
    }


    @Test
    void addCartToUserWithCartDetails() {

        User user = new User();
        user.setUsername("someone");
        user.setPassword("password");

        user.setCart(new Cart());

        List<Product> productList= (List<Product>) productService.listAll();

        CartDetail cdr1 = new CartDetail();
        cdr1.setProduct(productList.get(0));
        user.getCart().addCartDetails(cdr1);

        CartDetail cdr2 = new CartDetail();
        cdr2.setProduct(productList.get(1));
        user.getCart().addCartDetails(cdr2);

        User savedUser = userService.save(user);

        assertNotNull(savedUser.getCart());

        System.out.println("\n\n*************************");
        System.out.println(savedUser);
        System.out.println("*************************\n\n");
    }


}