package com.eureuni.eureunibe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EureuniApplication {

    public static void main(String[] args) {
        SpringApplication.run(EureuniApplication.class, args);
    }

}
