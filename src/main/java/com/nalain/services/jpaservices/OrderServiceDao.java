package com.nalain.services.jpaservices;

import com.nalain.domain.Order;
import com.nalain.services.OrderService;
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

public class OrderServiceDao implements OrderService {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<Order> listAll() {
        EntityManager em=entityManagerFactory.createEntityManager();
        return em.createQuery("FROM Order",Order.class).getResultList();
    }

    @Override
    public Order getById(Integer id) {
        EntityManager em=entityManagerFactory.createEntityManager();
        return em.find(Order.class,id);
    }

    @Override
    public Order save(Order domainEntity) {
        EntityManager em= entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Order savedOrder=em.merge(domainEntity);
        em.getTransaction().commit();

        return savedOrder;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em= entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Order.class,id));
        em.getTransaction().commit();
    }
}
