package com.nalain.services;

import com.nalain.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductServicempl implements ProductService {


    private Map<Integer,Product> products;

    public ProductServicempl() {
        loadAllProducts();
    }

    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(products.values());
    }

    private void loadAllProducts(){

        products=new HashMap<>();

        for( int i=1;i<=10;i++){

            Product product = new Product();
            product.setId(i);
            product.setDescription("Product"+i);
            product.setPrice(new BigDecimal(1+25.125*i));
            product.setImageUrl("http://www.example.com/product"+i);
            products.put(i,product);

        }
    }
}
