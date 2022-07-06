package com.nalain.bootstrap;

import com.nalain.domain.*;
import com.nalain.domain.enums.OrderStatus;
import com.nalain.services.CustomerService;
import com.nalain.services.ProductService;
import com.nalain.services.UserService;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

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
       loadProductsTwo();
       loadUserAndCustomersTwo();
        loadCarts();
        loadOrderHistory();
    }
/*

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
    private  void loadUserAndCustomers(){
        for (int i = 1; i <= 10; i++) {

            Customer customer = new Customer();
            customer.setFirstName("firstname" +i);
            customer.setLastName("lastname "+i);
            customer.setEmail("email " +i);
            customer.setPhoneNumber("phone number "+i);

            Address billingAddress = new Address();
            billingAddress.setAddressLineOne("line one "+i);
            billingAddress.setAddressLineTwo("line two "+i);
            billingAddress.setCity("city"+i);
            billingAddress.setState("state "+i);
            billingAddress.setZipCode("zipcode "+i);

            customer.setBillingAddress(billingAddress);
           // customer.setShippingAddress(billingAddress);

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
*/

    private void loadOrderHistory() {
        List<User> users = (List<User>) userService.listAll();
        List<Product> products = (List<Product>) productService.listAll();

        users.forEach(user ->{
            Order order = new Order();
            order.setCustomer(user.getCustomer());
            order.setStatus(OrderStatus.SHIPPED);

            products.forEach(product -> {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setProduct(product);
                orderDetail.setQuantity(1);
                order.addToOrderDetails(orderDetail);
            });
        });
    }

    private void loadCarts() {
        List<User> users = (List<User>) userService.listAll();
        List<Product> products = (List<Product>) productService.listAll();

        users.forEach(user -> {
            user.setCart(new Cart());
            CartDetail cartDetail = new CartDetail();
            cartDetail.setProduct(products.get(0));
            cartDetail.setQuantity(2);
            user.getCart().addCartDetails(cartDetail);
            userService.save(user);
        });
    }


    public void loadProductsTwo(){

        Product product1 = new Product();
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");
        productService.save(product1);

        Product product2 = new Product();
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");
        productService.save(product2);

        Product product3 = new Product();
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");
        productService.save(product3);

        Product product4 = new Product();
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");
        productService.save(product4);

        Product product5 = new Product();
        product5.setDescription("Product 5");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");
        productService.save(product5);

    }

    public void loadUserAndCustomersTwo() {
        User user1 = new User();
        user1.setUsername("mweston");
        user1.setPassword("password");

        Customer customer1 = new Customer();
        customer1.setFirstName("Micheal");
        customer1.setLastName("Weston");
        customer1.setBillingAddress(new Address());
        customer1.getBillingAddress().setAddressLineOne("1 Main St");
        customer1.getBillingAddress().setCity("Miami");
        customer1.getBillingAddress().setState("Florida");
        customer1.getBillingAddress().setZipCode("33101");
        customer1.setEmail("micheal@burnnotice.com");
        customer1.setPhoneNumber("305.333.0101");
        user1.setCustomer(customer1);
        userService.save(user1);

        User user2 = new User();
        user2.setUsername("fglenanne");
        user2.setPassword("password");

        Customer customer2 = new Customer();
        customer2.setFirstName("Fiona");
        customer2.setLastName("Glenanne");
        customer2.setBillingAddress(new Address());
        customer2.getBillingAddress().setAddressLineOne("1 Key Biscane Ave");
        customer2.getBillingAddress().setCity("Miami");
        customer2.getBillingAddress().setState("Florida");
        customer2.getBillingAddress().setZipCode("33101");
        customer2.setEmail("fiona@burnnotice.com");
        customer2.setPhoneNumber("305.323.0233");
        user2.setCustomer(customer2);
        userService.save(user2);

        User user3 = new User();
        user3.setUsername("saxe");
        user3.setPassword("password");
        Customer customer3 = new Customer();
        customer3.setFirstName("Sam");
        customer3.setLastName("Axe");
        customer3.setBillingAddress(new Address());
        customer3.getBillingAddress().setAddressLineOne("1 Little Cuba Road");
        customer3.getBillingAddress().setCity("Miami");
        customer3.getBillingAddress().setState("Florida");
        customer3.getBillingAddress().setZipCode("33101");
        customer3.setEmail("sam@burnnotice.com");
        customer3.setPhoneNumber("305.426.9832");

        user3.setCustomer(customer3);
        userService.save(user3);
    }

}
