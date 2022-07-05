package com.nalain.bootstrap;

import com.nalain.domain.Customer;
import com.nalain.domain.Product;
import com.nalain.domain.User;
import com.nalain.services.CustomerService;
import com.nalain.services.ProductService;
import com.nalain.services.UserService;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Getter
@Setter
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
       loadProducts();
       /*  loadCustomers();
        loadUsers();*/
    }

    private  void loadProducts(){
        for (int i = 1; i <= 10; i++) {
            Product product = new Product();
            product.setDescription("Product  " + i);
            product.setPrice(new BigDecimal(1 + 25.125 * i));
            product.setImageUrl("http://www.example.com/product" + i);
            productService.save(product);
        }

        System.out.println("\n********Sample products generated****");
    }
    private  void loadCustomers(){
        for (int i = 1; i <= 10; i++) {

            Customer customer = new Customer();
            customer.setFirstName("firstname" +i);
            customer.setLastName("lastname "+i);
            customer.setEmail("email " +i);
            customer.setPhoneNumber("phone number "+i);
            customer.setAddressLineOne("line one "+i);
            customer.setAddressLineTwo("line two "+i);
            customer.setCity("city"+i);
            customer.setState("state "+i);
            customer.setZipCode("zipcode "+i);
            customerService.save(customer);
        }

        System.out.println("\n********Sample customers generated****");
    }

    private void loadUsers() {

        for (int i = 1; i <= 10; i++) {

            User user = new User();
            user.setUsername("user-" + i);
            user.setPassword("password+"+i);
            user.setEnabled(i%3==0);
            userService.save(user);
        }

        System.out.println("\n********Sample users generated****");
    }

}
