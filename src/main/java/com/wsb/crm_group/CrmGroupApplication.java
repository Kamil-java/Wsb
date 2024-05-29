package com.wsb.crm_group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class CrmGroupApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmGroupApplication.class, args);
    }
}
