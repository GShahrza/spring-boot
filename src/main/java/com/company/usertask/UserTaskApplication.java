package com.company.usertask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class UserTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserTaskApplication.class, args);
    }

}
