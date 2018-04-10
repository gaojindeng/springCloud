package com.gjd.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserSvApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserSvApplication.class, args);
	}
}
