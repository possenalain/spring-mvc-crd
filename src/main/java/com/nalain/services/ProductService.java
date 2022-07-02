package com.nalain.services;
import com.nalain.domain.Product;


import java.util.List;

public interface ProductService {

    List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveOrUpdateProduct(Product product);

    Product deleteProduct(Integer productId);
}
