package com.itsinseo.jasoseolclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JasoseolCloneApplication {
    public static void main(String[] args) {
        SpringApplication.run(JasoseolCloneApplication.class, args);
    }

}
