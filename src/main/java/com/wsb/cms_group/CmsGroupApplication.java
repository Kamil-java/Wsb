package com.wsb.cms_group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class CmsGroupApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsGroupApplication.class, args);
    }
}
