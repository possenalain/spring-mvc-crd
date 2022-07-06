package com.nalain.services.jpaservices;

import com.nalain.domain.User;
import com.nalain.services.UserService;
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
@Getter
@Setter
public class UserServiceDaoImpl implements UserService {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private StrongPasswordEncryptor encryptor;

    @Override
    public List<User> listAll() {
     EntityManager em= entityManagerFactory.createEntityManager();
        return em.createQuery("FROM User",User.class).getResultList();
    }

    @Override
    public User getById(Integer id) {
        EntityManager em= entityManagerFactory.createEntityManager();
        return em.find(User.class, id);
    }

    @Override
    public User save(User domainEntity) {
        EntityManager em= entityManagerFactory.createEntityManager();
        if(domainEntity.getPassword()!=null){
            domainEntity.setEncryptedPassword(encryptor.encryptPassword(domainEntity.getPassword()));
        }
        em.getTransaction().begin();
        User savedUser=em.merge(domainEntity);
        em.getTransaction().commit();

        return savedUser;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em= entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.remove(user);
        em.getTransaction().commit();
    }
}
