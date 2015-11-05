package com.luxoft.springdata.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.luxoft.springdata.repository")
public class App {
	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
