package com.nalain.services.jpaservices;

import com.nalain.SpringMvcApplication;
import com.nalain.config.JpaIntegrationConfig;
import com.nalain.domain.User;
import com.nalain.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {SpringMvcApplication.class, JpaIntegrationConfig.class})
@ActiveProfiles({"jpaDao"})
class UserServiceDaoImplTest {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    void setEncryptor() {
    }

    @Test
    void listAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void save() {

        User user = new User();
        user.setUsername("someone");
        user.setPassword("password");

        User savedUser = userService.save(user);
        assertNotNull(savedUser.getEncryptedPassword());

        System.out.println(savedUser.getEncryptedPassword());
    }

    @Test
    void delete() {
    }
}