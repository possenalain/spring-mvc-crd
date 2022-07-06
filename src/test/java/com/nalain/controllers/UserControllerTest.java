package com.nalain.controllers;

import com.nalain.SpringMvcApplication;
import com.nalain.config.JpaIntegrationConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = {SpringMvcApplication.class, JpaIntegrationConfig.class})
@ActiveProfiles({"jpaDao"})
class UserControllerTest {


    private static MockMvc mockMvc;

    private static UserController userController;

    @BeforeAll
    public static void setup(){
        userController =new UserController();
        mockMvc= MockMvcBuilders.standaloneSetup(userController).build();
    }
    @Test
    void userIndexTest() throws Exception {
        mockMvc.perform(get("/users/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}