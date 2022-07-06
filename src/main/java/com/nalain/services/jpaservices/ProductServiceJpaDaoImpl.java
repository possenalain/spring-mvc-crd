package com.nalain.services.jpaservices;

import com.nalain.domain.Product;
import com.nalain.services.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpaDao")
@Getter
@Setter
class ProductServiceJpaDaoImpl implements ProductService {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<Product> listAll() {

        EntityManager em= entityManagerFactory.createEntityManager();

        return em.createQuery("FROM Product",Product.class).getResultList() ;
    }

    @Override
    public Product getById(Integer id) {
        EntityManager em= entityManagerFactory.createEntityManager();
        return em.find(Product.class, id);
    }

    @Override
    public Product save(Product domainEntity) {

        EntityManager em= entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Product savedProduct=em.merge(domainEntity);
        em.getTransaction().commit();

        return savedProduct;
    }

    @Override
    public void delete(Integer id) {

        EntityManager em= entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        em.remove(product);
        em.getTransaction().commit();

    }
}