package com.nalain.config;

import com.nalain.SpringMvcApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@EnableAutoConfiguration
@SpringBootTest(classes = {SpringMvcApplication.class, JpaIntegrationConfig.class})
@ActiveProfiles({"jpaDao"})
public class JpaIntegrationConfig {
}
