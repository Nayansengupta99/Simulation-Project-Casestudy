package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
@EnableEurekaClient
@SpringBootApplication
@ComponentScan({ "com.cognizant.*" })
public class BookApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApiServiceApplication.class, args);
	}

}
