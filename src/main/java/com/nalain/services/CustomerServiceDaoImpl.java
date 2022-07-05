package com.nalain.services;

import com.nalain.domain.Customer;
import com.nalain.domain.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;
@Service
@Profile("jpaDao")
public class CustomerServiceDaoImpl implements  CustomerService{
    private EntityManagerFactory entityManagerFactory;



    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
    public List<Customer> listAll() {
        EntityManager em= entityManagerFactory.createEntityManager();
        return em.createQuery("FROM Customer", Customer.class).getResultList() ;
    }

    @Override
    public Customer getById(Integer id) {
        EntityManager em= entityManagerFactory.createEntityManager();
        return em.find(Customer.class,id);
    }

    @Override
    public Customer save(Customer domainEntity) {
        EntityManager em= entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Customer savedCustomer=em.merge(domainEntity);
        em.getTransaction().commit();

        return savedCustomer;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em= entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Customer.class,id));
        em.getTransaction().commit();
    }
}
