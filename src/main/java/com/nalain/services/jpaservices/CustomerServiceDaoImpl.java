package com.nalain.services.jpaservices;

import com.nalain.domain.Customer;
import com.nalain.services.CustomerService;
import lombok.Getter;
import lombok.Setter;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpaDao")
@Setter
@Getter
public class CustomerServiceDaoImpl implements CustomerService {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private StrongPasswordEncryptor encryptor;


    @Override
    public List<Customer> listAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.createQuery("FROM Customer", Customer.class).getResultList();
    }

    @Override
    public Customer getById(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.find(Customer.class, id);
    }

    @Override
    public Customer save(Customer domainEntity) {
        EntityManager em = entityManagerFactory.createEntityManager();


        em.getTransaction().begin();
        if (domainEntity.getUser() != null && domainEntity.getUser().getPassword() != null) {
            domainEntity.getUser().setEncryptedPassword(encryptor.encryptPassword(domainEntity.getUser().getPassword()));
        }
        Customer savedCustomer = em.merge(domainEntity);
        em.getTransaction().commit();

        return savedCustomer;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Customer.class, id));
        em.getTransaction().commit();
    }
}
