package com.nalain.controllers;

import com.nalain.SpringMvcApplication;
import com.nalain.config.JpaIntegrationConfig;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(classes = {SpringMvcApplication.class, JpaIntegrationConfig.class})
@ActiveProfiles({"jpaDao"})

class IndexControllerTest {

    private static MockMvc mockMvc;

    private static IndexController indexController;

    @BeforeAll
    public static void setup(){
        indexController=new IndexController();
        mockMvc= MockMvcBuilders.standaloneSetup(indexController).build();
    }
    @Test
    void index() throws Exception {
        mockMvc.perform(get("/"))
                    .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}
