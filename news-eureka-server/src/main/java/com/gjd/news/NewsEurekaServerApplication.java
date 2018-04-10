package com.gjd.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NewsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsEurekaServerApplication.class, args);
	}
}
