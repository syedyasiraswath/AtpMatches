package com.titaniam.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.titaniam.demo", "com.titaniam.demo.config", "com.titaniam.demo.entity", "com.titaniam.demo.form",
		"com.titaniam.demo.controller", "com.titaniam.demo.exception", "com.titaniam.demo.service",
		"com.titaniam.demo.service.impl", "com.titaniam.demo.repository"
})
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"com.titaniam.demo.repository"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
}
