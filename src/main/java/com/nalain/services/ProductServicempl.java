package com.nalain.services;

import com.nalain.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductServicempl implements ProductService {


    private Map<Integer, Product> products;

    public ProductServicempl() {
        loadAllProducts();
    }

    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProductById(Integer id) {
        return products.get(id);
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {

        if (product != null) {
            if (product.getId() == null) {
                product.setId(Collections.max(products.keySet()) + 1);
            }
            products.put(product.getId(), product);
            return product;
        } else {
            throw new RuntimeException("product can't be null");
        }
    }

    @Override
    public Product deleteProduct(Integer productId) {

        if (productId != null) {

            return products.remove(productId);

        } else {
            throw new RuntimeException("product id can't be null");
        }
    }

    private void loadAllProducts() {

        products = new HashMap<>();

        for (int i = 1; i <= 10; i++) {

            Product product = new Product();
            product.setId(i);
            product.setDescription("Product  " + i);
            product.setPrice(new BigDecimal(1 + 25.125 * i));
            product.setImageUrl("http://www.example.com/product" + i);
            products.put(i, product);

        }
    }
}
