package com.company.usertask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableCaching
public class UserTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserTaskApplication.class, args);
    }

}
