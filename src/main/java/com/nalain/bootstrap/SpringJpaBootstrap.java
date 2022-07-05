package com.nalain.bootstrap;

import com.nalain.domain.Product;
import com.nalain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
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
}
