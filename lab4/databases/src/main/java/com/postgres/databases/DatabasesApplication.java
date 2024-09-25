package com.postgres.databases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJdbcRepositories
@EnableScheduling
@EnableTransactionManagement
public class DatabasesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabasesApplication.class, args);
    }

}
