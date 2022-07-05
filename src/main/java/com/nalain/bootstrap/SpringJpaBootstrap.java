package com.nalain.bootstrap;

import com.nalain.domain.Customer;
import com.nalain.domain.Product;
import com.nalain.services.CustomerService;
import com.nalain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductService productService;
    private CustomerService customerService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
        loadCustomers();
    }



    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public  void loadProducts(){
        for (int i = 1; i <= 10; i++) {
            Product product = new Product();
            product.setDescription("Product  " + i);
            product.setPrice(new BigDecimal(1 + 25.125 * i));
            product.setImageUrl("http://www.example.com/product" + i);
            productService.save(product);
        }

        System.out.println("\n********Sample products generated****");
    }
    public  void loadCustomers(){
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
}
