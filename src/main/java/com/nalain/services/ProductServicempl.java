package com.nalain.services;

import com.nalain.domain.DomainEntity;
import com.nalain.domain.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
@Profile("map")
public class ProductServicempl extends AbstractMapService implements ProductService {

    @Override
    public List<DomainEntity> listAll() {
        return super.listAll();
    }

    @Override
        public Product getById(Integer id) {
        return (Product) super.getById(id);
    }

  @Override
    public Product save(Product domainEntity) {
        return   (Product) super.save(domainEntity);

    }



    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

     void loadDomainObjects() {

        domainMap = new HashMap<>();

        for (int i = 1; i <= 10; i++) {

            Product product = new Product();
            product.setId(i);
            product.setDescription("Product  " + i);
            product.setPrice(new BigDecimal(1 + 25.125 * i));
            product.setImageUrl("http://www.example.com/product" + i);
            domainMap.put(i, product);

        }
    }

}
